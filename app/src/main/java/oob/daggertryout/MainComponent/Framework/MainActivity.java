package oob.daggertryout.MainComponent.Framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import oob.daggertryout.ApplicationComponent.BaseApplication;
import oob.daggertryout.MainComponent.Data.ClientEndpointInterface;
import oob.daggertryout.MainComponent.Data.PostRepository;
import oob.daggertryout.MainComponent.Domain.GetPostUseCase;
import oob.daggertryout.MainComponent.Domain.ViewInterface;
import oob.daggertryout.MainComponent.Framework.DependencyInyection.DaggerMainActivityComponentInterface;
import oob.daggertryout.MainComponent.Framework.DependencyInyection.MainActivityComponentInterface;
import oob.daggertryout.R;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    @BindView(R.id.textViewHello)
    TextView textViewHello;

    private GetPostUseCase getPostUseCase;

    @Inject
    ClientEndpointInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // ------------ DAGGER - DI -------------- //;
        MainActivityComponentInterface component = DaggerMainActivityComponentInterface.builder()
                .baseApplicationComponentInterface(((BaseApplication) this.getApplication()).getComponent())
                .build();
        component.inject(this);

        this.getPostUseCase = new GetPostUseCase(
                this,
                new PostRepository(this.service));
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getPostUseCase.getPost();
    }

    @Override
    public void setText(String text) {
        this.textViewHello.setText(String.format(getResources().getString(R.string.text_view_message_format), text));
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
