package oob.daggertryout.ApplicationComponent;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oob.daggertryout.ApplicationComponent.DependencyInjection.BaseApplicationComponentInterface;
import oob.daggertryout.ApplicationComponent.DependencyInjection.CacheModule;
import oob.daggertryout.ApplicationComponent.DependencyInjection.DaggerBaseApplicationComponentInterface;
import oob.daggertryout.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class BaseApplication extends Application {

    public Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        // ------------ DAGGER - DI -------------- //
        BaseApplicationComponentInterface component;
        component = DaggerBaseApplicationComponentInterface.builder()
                .cacheModule(
                        new CacheModule(
                                getCacheDir(),
                                getResources().getString(R.string.cache_name),
                                getResources().getInteger(R.integer.cache_size)
                        )
                )
                .build();

        retrofit =
                new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(component.getClient())
                    .baseUrl(getResources().getString(R.string.base_url))
                    .build();

    }
}
