package org.meicode.finalprojek2.Clothing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.Data.Network.ApiClient;
import org.meicode.finalprojek2.RecyclerViewListProduct.ListProductAdapter;
import org.meicode.finalprojek2.databinding.ActivityClothingWomenProductListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClothingWomenProductListActivity extends AppCompatActivity {

    ActivityClothingWomenProductListBinding binding;

    ListProductAdapter listProductAdapter;
    private List<BaseResponse> clothingWomenResponseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothingWomenProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listProductAdapter = new ListProductAdapter(clothingWomenResponseList, this);
        binding.rvClothingWomenProductList.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvClothingWomenProductList.setAdapter(listProductAdapter);

        getAllClothingWomen();

    }
    public void getAllClothingWomen() {
        Call<List<BaseResponse>> clothingWomenResponse = ApiClient.getInterface().getALlWomenClothing();
        clothingWomenResponse.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(ClothingWomenProductListActivity.this, "Request Successful", Toast.LENGTH_SHORT).show();
                    List<BaseResponse> data = response.body();
                    clothingWomenResponseList.addAll(data);
                    listProductAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ClothingWomenProductListActivity.this, "An error occured try again later..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(ClothingWomenProductListActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}