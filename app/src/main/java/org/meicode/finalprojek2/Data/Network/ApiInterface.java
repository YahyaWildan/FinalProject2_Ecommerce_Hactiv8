package org.meicode.finalprojek2.Data.Network;

import org.meicode.finalprojek2.Data.Model.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


//    method dengan anotasi@get(endpoint)
    @GET("men's%20clothing")
    public Call<List<BaseResponse>> getMenClothing();

    @GET("electronics")
    public Call<List<BaseResponse>> getALlElectronics();

    @GET("women's%20clothing")
    public Call<List<BaseResponse>> getALlWomenClothing();

    @GET("jewelery")
    public Call<List<BaseResponse>> getALlJewelery();

}
