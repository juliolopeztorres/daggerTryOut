package oob.daggertryout.MainComponent.Data;

import android.support.annotation.NonNull;
import oob.daggertryout.MainComponent.Domain.Model;
import oob.daggertryout.MainComponent.Domain.PostRepositoryInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository implements PostRepositoryInterface {

    private ClientEndpointInterface clientEndpointInterface;

    public PostRepository(ClientEndpointInterface clientEndpointInterface) {
        this.clientEndpointInterface = clientEndpointInterface;
    }

    @Override
    public void getPost(final OnPostCallbacks listener) {
        Call<Model> serviceCall = this.clientEndpointInterface.get();
        serviceCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                Model model = response.body();
                if (model != null) {
                    listener.onSuccess(String.valueOf(model.getId()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Model> call, @NonNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
