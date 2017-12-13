package oob.daggertryout.ApplicationComponent.DependencyInjection;

import dagger.Component;
import okhttp3.OkHttpClient;

@Component(modules = ClientModule.class)
public interface BaseApplicationComponentInterface {
    OkHttpClient getClient();
}
