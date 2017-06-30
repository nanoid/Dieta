package ua.nanoidteam.dieta.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.nanoidteam.dieta.App;

/**
 * Created by nanoid3 on 28.05.2017.
 */
@Module
public class AppModule {

    App mApp;

    public AppModule(App application) {
        mApp = application;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return mApp;
    }
}
