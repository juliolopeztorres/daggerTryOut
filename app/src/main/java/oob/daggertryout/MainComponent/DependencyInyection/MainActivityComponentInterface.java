package oob.daggertryout.MainComponent.DependencyInyection;


import dagger.Component;
import oob.daggertryout.ApplicationComponent.DependencyInjection.BaseApplicationComponentInterface;
import oob.daggertryout.MainComponent.MainActivity;

@MainActivityScopeInterface
@Component(dependencies = BaseApplicationComponentInterface.class)
public interface MainActivityComponentInterface {
    void inject(MainActivity mainActivity);
}
