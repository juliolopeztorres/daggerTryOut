package oob.daggertryout.ApplicationComponent.DependencyInjection;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oob.daggertryout.MainComponent.Data.ClientEndpointInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {LogModule.class, CacheModule.class})
public class ClientModule {

    private final String baseUrl;

    public ClientModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @BaseApplicationScopeInterface
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @BaseApplicationScopeInterface
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(this.baseUrl)
                .client(client)
                .build();
    }
}
