package org.meicode.finalprojek2.Clothing.ClothingProductListRecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.Data.Network.ApiService;
import org.meicode.finalprojek2.Data.Network.NetworkClient;
import org.meicode.finalprojek2.databinding.ActivityClothingProductListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class ClothingProductListActivity extends AppCompatActivity {

    ActivityClothingProductListBinding binding;

    ClothingProductListAdapter clothingProductListAdapter;

    List<BaseResponse> clothingResult;

    BaseResponse baseResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothingProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        clothingResult = new ArrayList<>();
        clothingProductListAdapter = new ClothingProductListAdapter(clothingResult,this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        binding.rvClothingProductList.addItemDecoration(dividerItemDecoration);
        binding.rvClothingProductList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvClothingProductList.setAdapter(clothingProductListAdapter);
        fetchData();

    }

    private void fetchData() {
        NetworkClient.getInstance().create(ApiService.class).getProducts(baseResponse.category).enqueue((new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {
                if(response.code() == 200 && response.body() != null){
                    clothingResult.addAll(response.body());
                    clothingProductListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {
                Toast.makeText(ClothingProductListActivity.this,"error"+t.getLocalizedMessage(),
                        Toast.LENGTH_LONG).show();

            }
        }));
    }
}