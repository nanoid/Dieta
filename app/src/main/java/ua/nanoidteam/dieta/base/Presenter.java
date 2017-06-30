package ua.nanoidteam.dieta.base;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public interface Presenter<V extends MainView> {


    void attachView(V mvpView);

    void detachView();

    V getView();
}