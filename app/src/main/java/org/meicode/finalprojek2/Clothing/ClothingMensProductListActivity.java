package org.meicode.finalprojek2.Clothing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.Data.Network.ApiClient;
import org.meicode.finalprojek2.OtherItem.OtherItemProductActivity;
import org.meicode.finalprojek2.RecyclerViewListProduct.ListProductAdapter;
import org.meicode.finalprojek2.databinding.ActivityClothingMensProductListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClothingMensProductListActivity extends AppCompatActivity {
    ActivityClothingMensProductListBinding binding;

    ListProductAdapter listProductAdapter;
    private List<BaseResponse> clothingMensResponseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothingMensProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listProductAdapter = new ListProductAdapter(clothingMensResponseList, this);
        binding.rvClothingMensProductList.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvClothingMensProductList.setAdapter(listProductAdapter);

        getAllClothingMens();

    }

    public void getAllClothingMens() {
        Call<List<BaseResponse>> clothingMensResponse = ApiClient.getInterface().getMenClothing();
        clothingMensResponse.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(ClothingMensProductListActivity.this, "Request Successful", Toast.LENGTH_SHORT).show();
                    List<BaseResponse> data = response.body();
                    clothingMensResponseList.addAll(data);
                    listProductAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ClothingMensProductListActivity.this, "An error occured try again later..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(ClothingMensProductListActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}