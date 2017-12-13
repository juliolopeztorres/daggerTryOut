package oob.daggertryout.ApplicationComponent.DependencyInjection;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

@Module
public class CacheModule {

    private final File cacheDir;
    private final String cacheName;
    private final int cacheSize;

    public CacheModule(File cacheDir, String cacheName, int cacheSize) {
        this.cacheDir = cacheDir;
        this.cacheName = cacheName;
        this.cacheSize = cacheSize;
    }

    @Provides
    File provideFile() {
        return new File(cacheDir, cacheName);
    }

    @Provides
    Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, cacheSize);
    }
}
