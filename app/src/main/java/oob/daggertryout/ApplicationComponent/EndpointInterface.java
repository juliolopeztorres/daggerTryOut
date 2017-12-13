package oob.daggertryout.ApplicationComponent;


import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {
    @GET("/posts/1")
    Call<Model> get();
}
