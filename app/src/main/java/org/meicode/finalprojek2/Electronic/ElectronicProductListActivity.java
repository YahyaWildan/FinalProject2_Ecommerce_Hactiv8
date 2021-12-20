package org.meicode.finalprojek2.Electronic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import org.meicode.finalprojek2.Data.Model.BaseResponse;
import org.meicode.finalprojek2.Data.Network.ApiClient;
import org.meicode.finalprojek2.RecyclerViewListProduct.ListProductAdapter;
import org.meicode.finalprojek2.databinding.ActivityElectronicProductListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElectronicProductListActivity extends AppCompatActivity {

    ActivityElectronicProductListBinding binding;

    ListProductAdapter adapterElectronics;
    private List<BaseResponse> electronicsResponseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityElectronicProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapterElectronics = new ListProductAdapter(electronicsResponseList, this);
        binding.rvElectronicProductList.setLayoutManager(new GridLayoutManager(this,2));
        binding.rvElectronicProductList.setAdapter(adapterElectronics);


        getAllElectronics();
    }

    public void getAllElectronics() {
        Call<List<BaseResponse>> electronicsResponse = ApiClient.getInterface().getALlElectronics();
        electronicsResponse.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(ElectronicProductListActivity.this, "Request Successful", Toast.LENGTH_SHORT).show();
                    List<BaseResponse> data = response.body();
                    electronicsResponseList.addAll(data);
                    adapterElectronics.notifyDataSetChanged();
                } else {
                    Toast.makeText(ElectronicProductListActivity.this, "An error occured try again later..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(ElectronicProductListActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}