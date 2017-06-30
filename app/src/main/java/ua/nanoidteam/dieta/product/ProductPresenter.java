package ua.nanoidteam.dieta.product;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.nanoidteam.dieta.App;
import ua.nanoidteam.dieta.base.BasePresenter;
import ua.nanoidteam.dieta.data.model.Product;
import ua.nanoidteam.dieta.start_screens.DietaPresenter;

/**
 * Created by nanoid3 on 11.06.2017.
 */

public class ProductPresenter extends BasePresenter<ProductView> {
    String TAG = ProductPresenter.class.getSimpleName();


    public ProductPresenter() {
        App.getInstance().getComponent().inject(this);
    }


    public void queryProducts() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> r1 = realm.where(Product.class).findAll();
        getView().onQueryProducts(r1);
    }
}
