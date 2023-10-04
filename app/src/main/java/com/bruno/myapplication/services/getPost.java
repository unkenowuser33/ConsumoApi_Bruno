package com.bruno.myapplication.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getPost {
    // getPost para acceder a los datos de la ruta especifica
    @GET("/dg7lduzuo/raw/upload/v1696366827/dg5n51dvtzfh78dlmoxy.json")
    Call<ResponseData> showStudent();
}
