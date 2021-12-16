package org.meicode.finalprojek2.Clothing.ClothingProductListRecycleView;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.meicode.finalprojek2.Clothing.ClothingProductDetailActivity;
import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.MainActivity;
import org.meicode.finalprojek2.databinding.ProductSampleBinding;

public class ClothingProductListViewHolder extends RecyclerView.ViewHolder {

    ProductSampleBinding binding;
    ClothingProductListAdapter clothingProductListAdapter;

    public ClothingProductListViewHolder(ProductSampleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataToView(BaseResponse baseResponse) {
        binding.tvTitleProductList.setText(baseResponse.getTitle());
        binding.tvPriceList.setText(baseResponse.getPrice());
        Glide.with(clothingProductListAdapter.context)
                .load(baseResponse.getImage())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.ivProductList);
        binding.ivProductList.setOnClickListener(view -> {
            Intent intentClothingProductDetail= new Intent(clothingProductListAdapter.context, ClothingProductDetailActivity.class);
            intentClothingProductDetail.putExtra("Hasil", (Parcelable) binding.ivProductList.getResources());
            clothingProductListAdapter.context.startActivity(intentClothingProductDetail);
        });
    }
}
