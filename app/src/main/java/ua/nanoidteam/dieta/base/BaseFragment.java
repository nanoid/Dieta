package ua.nanoidteam.dieta.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ua.nanoidteam.dieta.App;
import ua.nanoidteam.dieta.R;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getActivity().getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflateView(inflater, container);
        ButterKnife.bind(this, view);
        return view;
    }


    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.disallowAddToBackStack();
        //transaction.addToBackStack(null);
        transaction.commit();


    }


    protected abstract View inflateView(LayoutInflater inflater, ViewGroup container);


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
