package oob.daggertryout.MainComponent.Framework.DependencyInyection;


import dagger.Component;
import oob.daggertryout.ApplicationComponent.DependencyInjection.BaseApplicationComponentInterface;
import oob.daggertryout.MainComponent.Framework.MainActivity;

@MainActivityScopeInterface
@Component(modules = MainActivityModule.class, dependencies = BaseApplicationComponentInterface.class)
public interface MainActivityComponentInterface {
    void inject(MainActivity mainActivity);
}
