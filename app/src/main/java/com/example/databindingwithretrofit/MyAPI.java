package com.example.databindingwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    @GET("androidwebmvvm.php")
    Call<List<MyList>> getartistdata();
}
