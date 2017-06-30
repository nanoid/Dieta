package ua.nanoidteam.dieta.screens.info;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.base.BaseActivity;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class InfoActivity  extends BaseActivity {
    @Override
    protected int getViewId() {
        return R.layout.info_activity;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(R.id.container,InfoFragment.newInstance());
    }
}
