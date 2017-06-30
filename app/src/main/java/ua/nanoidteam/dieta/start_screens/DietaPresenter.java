package ua.nanoidteam.dieta.start_screens;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.internal.PendingRow;
import ua.nanoidteam.dieta.App;
import ua.nanoidteam.dieta.base.BasePresenter;
import ua.nanoidteam.dieta.data.model.Product;

/**
 * Created by nanoid3 on 28.05.2017.
 */

public class DietaPresenter extends BasePresenter<DietaView> {


    String TAG = DietaPresenter.class.getSimpleName();


    public DietaPresenter() {
        App.getInstance().getComponent().inject(this);
    }

    public void loadProducts(Context context) {
        // Get a Realm instance for this thread

        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getDefaultInstance();
        Product product = realm.createObject(Product.class);
        product.setName("Product");
        product.setTypeView(0);
         realm.close();

        getView().onLoadProducts();
    }
}
