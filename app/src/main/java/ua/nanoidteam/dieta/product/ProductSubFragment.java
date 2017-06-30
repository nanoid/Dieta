package ua.nanoidteam.dieta.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.base.BaseFragment;
import ua.nanoidteam.dieta.data.model.Product;
import ua.nanoidteam.dieta.product.adapter.ProductRecyclerAdapter;

/**
 * Created by nanoid3 on 11.06.2017.
 */

public class ProductSubFragment extends BaseFragment implements ProductView, ProductRecyclerAdapter.OnProductItemClick {

    private String TAG = ProductSubFragment.class.getSimpleName();

    @Inject
    ProductPresenter mProductPresenter;

    @BindView(R.id.product_recycler_view)
    RecyclerView mRecyclerView;

    ProductRecyclerAdapter mProductRecyclerAdapter;

    public static ProductSubFragment newInstance() {
        ProductSubFragment productSubFragment = new ProductSubFragment();
        return productSubFragment;
    }


    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_sub_product, container, false);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      /*  TextView titleTextView = (TextView) getActivity().findViewById(R.id.category_title_text_view);

        ImageButton imageButton = (ImageButton) getActivity().findViewById(R.id.back_image_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             *//*   if (mCategoryPresenter.getPreCategory(mCategoryModel.getCurrentCategory()) == null) {
                    ;
                    replaceFragment(FilterCategoryFragment.newInstance());
                } else {
                    replaceFragment(FilterSubCategoryFragment.newInstance());
                }*//*
            }

        });
*/
        return super.onCreateView(inflater, container, savedInstanceState);
    }


   /* private void replaceFragment(Fragment fragment) {
        getFragmentManager().popBackStack();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.setCustomAnimations(R.animator.enter_from_left, R.animator.exit_to_left);
        //transaction.hide(FilterSubCategoryFragment.this);
        transaction.replace(R.id.container_category, fragment);
        transaction.commit();
    }
*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("view_created", "view_created");
        mProductPresenter.attachView(this);
        mProductPresenter.queryProducts();
    }






    @Override
    public void onQueryProducts(List<Product> productList) {
      Log.e(TAG, String.valueOf(productList.size()));
        mProductRecyclerAdapter = new ProductRecyclerAdapter(this,productList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mProductRecyclerAdapter);
     }

    @Override
    public void onItemClick(Product product) {

    }
}
