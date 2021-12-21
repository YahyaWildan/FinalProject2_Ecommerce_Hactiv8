package org.meicode.finalprojek2.RecyclerViewListProduct;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.DetailProductActivity;
import org.meicode.finalprojek2.databinding.ItemViewProductBinding;

import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductViewHolder> {

    private List<BaseResponse> data;
    private Context context;

    public ListProductAdapter(List<BaseResponse> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ListProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewProductBinding binding = ItemViewProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductViewHolder holder, int position) {
        BaseResponse item = data.get(position);
        holder.setDataProductToView(context, item);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailProductActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("image", item.getImage());
            intent.putExtra("price", item.getPrice());
            intent.putExtra("description", item.getDescription());
            holder.itemView.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}



