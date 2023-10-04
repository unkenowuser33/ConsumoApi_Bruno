package com.bruno.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostStudent {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("edad")
    @Expose
    private int edad;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("imagen_url")
    @Expose
    private String imagen_url;

    @SerializedName("cursos")
    @Expose
    private List<PostCourse> cursos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public List<PostCourse> getCursos() {
        return cursos;
    }

    public void setCursos(List<PostCourse> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "PostStudent{" + "id=" + id + ", nombre='" + nombre + '\'' + ", edad=" + edad + ", email='" + email + '\'' + ", imagen_url='" + imagen_url + '\'' + ", cursos=" + cursos + '}';
    }
}
