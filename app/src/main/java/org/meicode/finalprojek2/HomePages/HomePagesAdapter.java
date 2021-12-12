package org.meicode.finalprojek2.HomePages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.databinding.ItemSampleBinding;

import java.util.ArrayList;

public class HomePagesAdapter extends RecyclerView.Adapter<HomePagesViewHolder> {
    int images[];
    private ArrayList<String> dataList;
    public Context context;

    public HomePagesAdapter(Context context, int images[]){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public HomePagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSampleBinding binding = ItemSampleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomePagesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePagesViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.setDataToView(item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
