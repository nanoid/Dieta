package ua.nanoidteam.dieta.product.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.nanoidteam.dieta.R;
import ua.nanoidteam.dieta.data.model.Product;

/**
 * Created by nanoid3 on 29.06.2017.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    String TAG = ProductRecyclerAdapter.class.getSimpleName();
    String mSelectedCategoryId = null;
    private OnProductItemClick mOnProductItemClick;
    private List<Product> mProductList;

    public ProductRecyclerAdapter(OnProductItemClick onProductItemClick, List<Product> productList) {
        mOnProductItemClick = onProductItemClick;
        mProductList = productList;
    }


    public void setSelectedCategoryId(String selectedCategoryId) {
        mSelectedCategoryId = selectedCategoryId;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new SimpleProductHolder(LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.simple_product_list_item, parent, false));
            case 1:
                return new ProductHolder(LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.product_list_item, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                bindSimpleProduct((SimpleProductHolder) holder, position);
                break;
            case 1:
                bindProduct((ProductHolder) holder, position);
                break;


        }
    }

    @Override
    public int getItemViewType(int position) {
        return mProductList.get(position).getTypeView();
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public void bindSimpleProduct(SimpleProductHolder productHolder, int postion) {
        Context context = productHolder.itemView.getContext();
        Product product = (Product) mProductList.get(postion);
        productHolder.bindSimpleProduct(product, postion);

    }

    public void bindProduct(ProductHolder productHolder, int postion) {
        Context context = productHolder.itemView.getContext();
        Product product = (Product) mProductList.get(postion);
        productHolder.bindProduct(product, postion);
    }


    public interface OnProductItemClick {

        void onItemClick(Product product);
    }

    public class SimpleProductHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.product_list_item)
        LinearLayout mLinearLayout;


        @BindView(R.id.product_text_view)
        TextView nameProductTextView;

        private Product mProduct;

        public SimpleProductHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void bindSimpleProduct(Product product, int position) {
            mProduct = product;
            Context context = itemView.getContext();
            showGeneralInfo(context, position);
        }


        private void showGeneralInfo(Context context, int position) {
            nameProductTextView.setText(mProduct.getName());

        }

        @OnClick(R.id.product_list_item)
        public void onItemClick() {
             if (mOnProductItemClick!= null) {
                mOnProductItemClick.onItemClick(mProduct);
            }
        }
    }

    public class ProductHolder  extends RecyclerView.ViewHolder {


        @BindView(R.id.product_list_item)
        LinearLayout mLinearLayout;

        @BindView(R.id.product_icon_image_view)
        ImageView productImage;


        @BindView(R.id.product_text_view)
        TextView nameProductTextView;

        private Product mProduct;

        public ProductHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void bindProduct(Product product, int position) {
            mProduct = product;
            Context context = itemView.getContext();
            showGeneralInfo(context, position);
        }


        private void showGeneralInfo(Context context, int position) {
            nameProductTextView.setText(mProduct.getName());
            String url = mProduct.getImage();
            Glide.with(context).load(url).into(productImage);
          }

        @OnClick(R.id.product_list_item)
        public void onItemClick() {
             if (mOnProductItemClick!= null) {
                 mOnProductItemClick.onItemClick(mProduct);
            }
        }
    }

}
