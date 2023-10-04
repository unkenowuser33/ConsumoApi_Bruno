package com.bruno.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostHomework {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("nivel")
    @Expose
    private String nivel;

    @SerializedName("fecha_entrega")
    @Expose
    private String fecha_entrega;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    @Override
    public String toString() {
        return "PostHomework{" + "id=" + id + ", titulo='" + titulo + '\'' + ", descripcion='" + descripcion + '\'' + ", nivel='" + nivel + '\'' + ", fecha_entrega='" + fecha_entrega + '\'' + '}';
    }
}
