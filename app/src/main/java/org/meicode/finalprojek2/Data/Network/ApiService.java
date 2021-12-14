package org.meicode.finalprojek2.Data.Network;

import org.meicode.finalprojek2.Data.Model.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products")
    public Call<List<BaseResponse>> getProducts();
}
