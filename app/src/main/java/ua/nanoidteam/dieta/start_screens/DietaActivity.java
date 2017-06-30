package ua.nanoidteam.dieta.start_screens;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ua.nanoidteam.dieta.Prefs;
import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.base.BaseActivity;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class DietaActivity extends BaseActivity{
    @Override
    protected int getViewId() {
        return R.layout.dieta_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            addFragment(R.id.container,DietaFragment.newInstance());
    }
}
