package com.bruno.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostCourse {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("codigo")
    @Expose
    private String codigo;

    @SerializedName("profesor")
    @Expose
    private String profesor;

    @SerializedName("calificacion")
    @Expose
    private Integer calificacion;

    @SerializedName("imagen_url")
    @Expose
    private String imagen_url;

    @SerializedName("tareas")
    @Expose
    private List<PostHomework> tareas;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public List<PostHomework> getTareas() {
        return tareas;
    }

    public void setTareas(List<PostHomework> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "PostCourse{" + "id=" + id + ", nombre='" + nombre + '\'' + ", codigo='" + codigo + '\'' + ", profesor='" + profesor + '\'' + ", calificacion=" + calificacion + ", imagen_url='" + imagen_url + '\'' + ", tareas=" + tareas + '}';
    }
}
