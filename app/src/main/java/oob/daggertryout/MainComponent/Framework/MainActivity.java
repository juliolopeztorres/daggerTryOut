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
import oob.daggertryout.MainComponent.Domain.GetPostUseCase;
import oob.daggertryout.MainComponent.Domain.ViewInterface;
import oob.daggertryout.MainComponent.Framework.DependencyInyection.DaggerMainActivityComponentInterface;
import oob.daggertryout.MainComponent.Framework.DependencyInyection.MainActivityComponentInterface;
import oob.daggertryout.MainComponent.Framework.DependencyInyection.MainActivityModule;
import oob.daggertryout.R;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    @BindView(R.id.textViewHello)
    TextView textViewHello;

    @Inject
    GetPostUseCase getPostUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // ------------ DAGGER - DI -------------- //;
        MainActivityComponentInterface component = DaggerMainActivityComponentInterface.builder()
                .baseApplicationComponentInterface(((BaseApplication) this.getApplication()).getComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build();
        component.inject(this);
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
