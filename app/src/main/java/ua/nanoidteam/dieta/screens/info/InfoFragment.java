package ua.nanoidteam.dieta.screens.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.nanoidteam.dieta.App;
import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.base.BaseFragment;
import ua.nanoidteam.dieta.start_screens.DietaFragment;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class InfoFragment extends BaseFragment {

    public static InfoFragment newInstance() {
        InfoFragment infoFragment = new InfoFragment();
        return infoFragment;
    }


    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getActivity().getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
    }



}
