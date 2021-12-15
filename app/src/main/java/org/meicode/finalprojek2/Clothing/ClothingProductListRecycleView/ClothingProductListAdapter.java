package org.meicode.finalprojek2.Clothing.ClothingProductListRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.databinding.ProductSampleBinding;

import java.util.List;

public class ClothingProductListAdapter extends RecyclerView.Adapter<ClothingProductListViewHolder> {

    private List<BaseResponse> baseResponses;
    public Context context;

    public ClothingProductListAdapter(List<BaseResponse> baseResponses, Context context){
        this.baseResponses = baseResponses;
        this.context = context;
    }

    @Override
    public ClothingProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProductSampleBinding binding = ProductSampleBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ClothingProductListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ClothingProductListViewHolder holder, int position) {
        BaseResponse baseResponse = baseResponses.get(position);
        holder.setDataToView(baseResponse);

    }

    @Override
    public int getItemCount() {
        return baseResponses.size();
    }
}
