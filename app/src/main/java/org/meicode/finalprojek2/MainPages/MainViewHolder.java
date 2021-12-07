package org.meicode.finalprojek2.MainPages;

import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.databinding.ItemSampleBinding;

public class MainViewHolder extends RecyclerView.ViewHolder {
    ItemSampleBinding binding;

    public MainViewHolder(ItemSampleBinding binding){
        super(binding.getRoot());
        this.binding =binding;
    }

    public void setDataToView(){
        binding.ivProduk.setImageResource();
        binding.tvProduk.setText();
    }
}
