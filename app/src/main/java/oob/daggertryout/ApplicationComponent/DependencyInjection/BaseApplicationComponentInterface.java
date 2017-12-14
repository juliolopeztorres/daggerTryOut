package oob.daggertryout.ApplicationComponent.DependencyInjection;

import dagger.Component;
import oob.daggertryout.ApplicationComponent.ClientEndpointInterface;

@BaseApplicationScopeInterface
@Component(modules = ClientModule.class)
public interface BaseApplicationComponentInterface {
    ClientEndpointInterface getClientEndpoint();
}
