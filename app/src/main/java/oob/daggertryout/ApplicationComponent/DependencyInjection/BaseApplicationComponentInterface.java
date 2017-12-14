package oob.daggertryout.ApplicationComponent.DependencyInjection;

import dagger.Component;
import retrofit2.Retrofit;

@BaseApplicationScopeInterface
@Component(modules = ClientModule.class)
public interface BaseApplicationComponentInterface {
    Retrofit getRetrofit();
}
