package ua.nanoidteam.dieta.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.nanoidteam.dieta.product.ProductPresenter;
import ua.nanoidteam.dieta.start_screens.DietaPresenter;

/**
 * Created by nanoid3 on 28.05.2017.
 */

@Module
public class MainModule {
    @Provides
    @Singleton
    DietaPresenter providesDietaPresenter() {
        return new DietaPresenter();
    }

    @Provides
    @Singleton
    ProductPresenter providesProductPresenter() {
        return new ProductPresenter();
    }
}
