package ua.nanoidteam.dieta.start_screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.OnClick;
import ua.nanoidteam.dieta.App;
import ua.nanoidteam.dieta.Prefs;
import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.base.BaseFragment;
import ua.nanoidteam.dieta.product.ProductActivity;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class DietaFragment extends BaseFragment implements DietaView {

    @Inject
    DietaPresenter mDietaPresenter;

    public static DietaFragment newInstance() {
        DietaFragment dietaFragment = new DietaFragment();
        return dietaFragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_dieta, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getActivity().getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDietaPresenter.attachView(this);
        if (!Prefs.getFirstStart(getActivity())) {
            mDietaPresenter.loadProducts(getActivity());
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @OnClick(R.id.product_grid)
    public void onProductGridClick() {
        startActivity(new Intent(getActivity(), ProductActivity.class));
    }


    @Override
    public void onLoadProducts() {
        Prefs.setFirstStart(getActivity(), true);
    }
}
