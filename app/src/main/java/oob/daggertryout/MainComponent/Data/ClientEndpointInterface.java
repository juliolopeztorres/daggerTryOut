package oob.daggertryout.MainComponent.Data;


import oob.daggertryout.MainComponent.Domain.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ClientEndpointInterface {

    String CONTENT_TYPE = "Content-Type: application/json";
    String ACCEPT = "Accept: application/json";

    @Headers({CONTENT_TYPE, ACCEPT})
    @GET("posts/1")
    Call<Model> get();
}
