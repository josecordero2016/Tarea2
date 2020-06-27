package com.example.tarea2.interfaz;

import com.example.tarea2.Modelos.Bancos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface retrofit_interfaz {
    @Headers({
            "Public-Merchant-Id:c1db6bee50a1493dac1d337285414418"
    })

    @GET("transfer-subscriptions/v1/bankList")
    Call<List<Bancos>> getPosts();
}
