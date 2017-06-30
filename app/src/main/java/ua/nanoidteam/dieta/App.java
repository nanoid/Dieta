package ua.nanoidteam.dieta;

import android.app.Application;

import io.realm.Realm;
import ua.nanoidteam.dieta.injection.DaggerMainComponent;
import ua.nanoidteam.dieta.injection.MainComponent;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class App extends Application {

    private static App app;
    MainComponent mMainComponent;

    public synchronized static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initialize();
    }

    private void initialize() {
        mMainComponent = DaggerMainComponent.builder().build();//;appModule(new AppModule(this)).mainModule(new MainModule()).build();
        Realm.init(this);
    }

    public MainComponent getComponent() {
        return mMainComponent;
    }
}