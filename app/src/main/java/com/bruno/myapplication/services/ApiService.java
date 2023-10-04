package com.bruno.myapplication.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit retrofit; // Retrofit es para acceder a la ruta/link
    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://res.cloudinary.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}