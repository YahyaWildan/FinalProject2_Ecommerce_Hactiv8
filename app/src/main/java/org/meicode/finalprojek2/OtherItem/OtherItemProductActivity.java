package org.meicode.finalprojek2.OtherItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.Data.Network.ApiClient;
import org.meicode.finalprojek2.Electronic.ElectronicProductListActivity;
import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.RecyclerViewListProduct.ListProductAdapter;
import org.meicode.finalprojek2.databinding.ActivityOtherItemProductBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherItemProductActivity extends AppCompatActivity {
    ActivityOtherItemProductBinding binding;
    ListProductAdapter listProductAdapter;
    private List<BaseResponse> otherResponseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherItemProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listProductAdapter = new ListProductAdapter(otherResponseList, this);
        binding.rvOtherProductList.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvOtherProductList.setAdapter(listProductAdapter);
        getAllOthers();


    }

    public void getAllOthers() {
        Call<List<BaseResponse>> othersResponse = ApiClient.getInterface().getALlJewelery();
        othersResponse.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(OtherItemProductActivity.this, "Request Successful", Toast.LENGTH_SHORT).show();
                    List<BaseResponse> data = response.body();
                    otherResponseList.addAll(data);
                    listProductAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(OtherItemProductActivity.this, "An error occured try again later..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(OtherItemProductActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}