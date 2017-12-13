package oob.daggertryout.ApplicationComponent;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oob.daggertryout.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class BaseApplication extends Application {

    public Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        // ------------ CREATE LOGGING -------------- //
        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // ------------ CREATE CACHE -------------- //
        File cacheFile = new File(getCacheDir(), getResources().getString(R.string.cache_name));
        Cache cache = new Cache(cacheFile, getResources().getInteger(R.integer.cache_size));

        // ------------ CREATE HTTP CLIENT -------------- //

        OkHttpClient okHttpClient =
                new OkHttpClient.Builder()
                        .addInterceptor(httpLoggingInterceptor)
                        .cache(cache)
                        .build();

        // ------------ CREATE HTTP CLIENT WRAPPER -------------- //
        retrofit =
                new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(
                            new GsonBuilder().setLenient().create()
                    ))
                    .client(okHttpClient)
                    .baseUrl(getResources().getString(R.string.base_url))
                    .build();

    }
}
