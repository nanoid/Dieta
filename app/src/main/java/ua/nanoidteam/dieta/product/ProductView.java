package ua.nanoidteam.dieta.product;

import java.util.List;

import ua.nanoidteam.dieta.base.MainView;
import ua.nanoidteam.dieta.data.model.Product;

/**
 * Created by nanoid3 on 11.06.2017.
 */

public interface  ProductView extends MainView {
    void onQueryProducts(List<Product> productList);
}
