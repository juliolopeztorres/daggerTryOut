package oob.daggertryout.ApplicationComponent;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientEndpointInterface {
    @GET("/posts/1")
    Call<Model> get();
}
