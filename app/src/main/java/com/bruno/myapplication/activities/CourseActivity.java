package com.bruno.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bruno.myapplication.R;
import com.bruno.myapplication.adapter.CourseAdapter;
import com.bruno.myapplication.models.PostCourse;
import com.bruno.myapplication.services.ApiService;
import com.bruno.myapplication.services.ResponseData;
import com.bruno.myapplication.services.getPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {
    private List<PostCourse> postCourses = new ArrayList<>();
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private Activity activity;
    private Integer position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        activity = CourseActivity.this;

        recyclerView = findViewById(R.id.rv_json_course);
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Lista de cursos" + postCourses);
        System.out.println("============================================");
        System.out.println("============================================");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*courseAdapter = new CourseAdapter(postCourses, activity);
        recyclerView.setAdapter(courseAdapter);*/
        if (getIntent().getExtras() != null) {
            position = getIntent().getIntExtra("position", 0);
        }
        showPruebaC();
    }

    private void showPruebaC() {
        Call<ResponseData> call = ApiService.getRetrofit().create(getPost.class).showStudent();
        call.enqueue(new Callback<ResponseData>() { // Importante
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData mData = response.body();
                if (mData != null && response.isSuccessful()) {
                    postCourses = mData.getEstudiantes().get(position).getCursos();
                    courseAdapter = new CourseAdapter(postCourses, activity);
                    recyclerView.setAdapter(courseAdapter);
                } else {
                    System.out.println("No hay data");
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(CourseActivity.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
