package oob.daggertryout.MainComponent.Data;


import oob.daggertryout.MainComponent.Domain.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientEndpointInterface {
    @GET("posts/1")
    Call<Model> get();
}
