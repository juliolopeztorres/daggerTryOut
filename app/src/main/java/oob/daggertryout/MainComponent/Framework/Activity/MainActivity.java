package oob.daggertryout.MainComponent.Framework.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import oob.daggertryout.ApplicationComponent.BaseApplication;
import oob.daggertryout.ApplicationComponent.EndpointInterface;
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

        Retrofit retrofit = ((BaseApplication) getApplication()).retrofit;
        EndpointInterface service = retrofit.create(EndpointInterface.class);
        Call<Model> serviceCall = service.get();
        serviceCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                textViewHello.setText(String.format("El id es : %d", model.getId()));
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
