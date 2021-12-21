package org.meicode.finalprojek2.RecyclerViewListProduct;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.GlideApp;
import org.meicode.finalprojek2.databinding.ItemViewProductBinding;

public class ListProductViewHolder extends RecyclerView.ViewHolder {

    ItemViewProductBinding binding;

    public ListProductViewHolder(ItemViewProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataProductToView(Context context, BaseResponse item) {

        binding.tvPriceProduct.setText(item.getPrice());
        binding.tvTittleProduct.setText(item.getTitle());
        GlideApp.with(context).load(item.getImage()).into(binding.ivProduct);
    }
}
