package oob.daggertryout.MainComponent.Framework.DependencyInyection;

import dagger.Module;
import dagger.Provides;
import oob.daggertryout.MainComponent.Data.ClientEndpointInterface;
import oob.daggertryout.MainComponent.Data.PostRepository;
import oob.daggertryout.MainComponent.Domain.GetPostUseCase;
import oob.daggertryout.MainComponent.Domain.PostRepositoryInterface;
import oob.daggertryout.MainComponent.Domain.ViewInterface;
import retrofit2.Retrofit;

@Module
public class MainActivityModule {

    private ViewInterface view;

    public MainActivityModule(ViewInterface view) {
        this.view = view;
    }

    @Provides
    @MainActivityScopeInterface
    GetPostUseCase provideGetPostUseCase(PostRepositoryInterface postRepository) {
        return new GetPostUseCase(this.view, postRepository);
    }

    @Provides
    @MainActivityScopeInterface
    PostRepositoryInterface providePostRepository(ClientEndpointInterface clientEndpointInterface) {
        return new PostRepository(clientEndpointInterface);
    }

    @Provides
    @MainActivityScopeInterface
    ClientEndpointInterface provideClientEndpoint(Retrofit retrofit) {
        return retrofit.create(ClientEndpointInterface.class);
    }
}
