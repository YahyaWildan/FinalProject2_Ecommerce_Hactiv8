package org.meicode.finalprojek2.HomePages;

import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.databinding.ItemSampleBinding;

public class HomePagesViewHolder extends RecyclerView.ViewHolder {
    ItemSampleBinding binding;

    public HomePagesViewHolder(ItemSampleBinding binding){
        super(binding.getRoot());
        this.binding =binding;
    }

    public void setDataToView(){
    }
}
