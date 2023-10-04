package com.bruno.myapplication.services;

import androidx.recyclerview.widget.RecyclerView;

import com.bruno.myapplication.models.PostStudent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData { //ResponseData es para recibir los datos como primera respuesta
    @SerializedName("estudiantes")
    @Expose
    List<PostStudent> estudiantes;

    public List<PostStudent> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<PostStudent> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "ResponseData{" + "estudiantes=" + estudiantes + '}';
    }
}
