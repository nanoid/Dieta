package ua.nanoidteam.dieta;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nanoid3 on 30.06.2017.
 */

public class Prefs {

    private static final String TAG = Prefs.class.getSimpleName();
    private static final String PREFERENCES_NAME = "development_preferences";

    private static final String PREFERENCES_FIRST_START = "first_start";


    private static SharedPreferences.Editor registrationEditor = null;
    private Context mContext;

    private Prefs() {
    }

    public static void setFirstStart(Context context, boolean isFirst) {
        registrationEditor = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        registrationEditor.putBoolean(PREFERENCES_FIRST_START, isFirst);
        registrationEditor.commit();
    }


    public static boolean getFirstStart(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).
                getBoolean(PREFERENCES_FIRST_START, false);
    }



}
