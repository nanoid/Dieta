package ua.nanoidteam.dieta.base;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class BasePresenter<T extends MainView> implements Presenter<T> {

    T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {

    }


    @Override
    public T getView() {
        return mMvpView;
    }






}
