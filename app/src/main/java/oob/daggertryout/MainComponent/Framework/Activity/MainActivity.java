package oob.daggertryout.MainComponent.Framework.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import oob.daggertryout.ApplicationComponent.BaseApplication;
import oob.daggertryout.ApplicationComponent.ClientEndpointInterface;
import oob.daggertryout.ApplicationComponent.Model;
import oob.daggertryout.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textViewHello)
    TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ClientEndpointInterface service = ((BaseApplication) getApplication()).clientEndpoint;
        Call<Model> serviceCall = service.get();
        serviceCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                Model model = response.body();
                if (model != null) {
                    textViewHello.setText(String.valueOf(model.getId()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Model> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
