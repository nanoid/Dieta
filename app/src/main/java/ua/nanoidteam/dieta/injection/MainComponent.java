package ua.nanoidteam.dieta.injection;

import javax.inject.Singleton;

import dagger.Component;
import ua.nanoidteam.dieta.base.BaseFragment;
import ua.nanoidteam.dieta.product.ProductPresenter;
import ua.nanoidteam.dieta.product.ProductSubFragment;
import ua.nanoidteam.dieta.screens.info.InfoFragment;
import ua.nanoidteam.dieta.start_screens.DietaFragment;
import ua.nanoidteam.dieta.start_screens.DietaPresenter;

/**
 * Created by nanoid3 on 28.05.2017.
 */

@Singleton
@Component(modules = {AppModule.class, MainModule.class})
public interface MainComponent {

    void inject(DietaFragment fragment);

    void inject(DietaPresenter presenter);

    void inject(InfoFragment fragment);

    void inject(BaseFragment fragment);


    void inject(ProductPresenter presenter);

    void inject(ProductSubFragment fragment);

}
