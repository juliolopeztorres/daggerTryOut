package oob.daggertryout.ApplicationComponent;

import android.app.Application;

import oob.daggertryout.ApplicationComponent.DependencyInjection.BaseApplicationComponentInterface;
import oob.daggertryout.ApplicationComponent.DependencyInjection.CacheModule;
import oob.daggertryout.ApplicationComponent.DependencyInjection.ClientModule;
import oob.daggertryout.ApplicationComponent.DependencyInjection.DaggerBaseApplicationComponentInterface;
import oob.daggertryout.R;
import timber.log.Timber;

public class BaseApplication extends Application {
    BaseApplicationComponentInterface component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        // ------------ DAGGER - DI -------------- //;
        this.component = DaggerBaseApplicationComponentInterface.builder()
                .cacheModule(
                        new CacheModule(
                                getCacheDir(),
                                getResources().getString(R.string.cache_name),
                                getResources().getInteger(R.integer.cache_size)
                        )
                )
                .clientModule(new ClientModule(getString(R.string.base_url)))
                .build();
    }

    public BaseApplicationComponentInterface getComponent() {
        return component;
    }
}
