package com.bruno.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bruno.myapplication.R;
import com.bruno.myapplication.adapter.CourseAdapter;
import com.bruno.myapplication.adapter.HomeworkAdapter;
import com.bruno.myapplication.adapter.StudentAdapter;
import com.bruno.myapplication.models.PostCourse;
import com.bruno.myapplication.models.PostHomework;
import com.bruno.myapplication.services.ApiService;
import com.bruno.myapplication.services.ResponseData;
import com.bruno.myapplication.services.getPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeworkActivity extends AppCompatActivity {
    private List<PostHomework> postHomeworks = new ArrayList<>();
    private RecyclerView recyclerView;
    private HomeworkAdapter homeworkAdapter;
    private Activity activity;
    private Integer position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        activity = HomeworkActivity.this;

        recyclerView = findViewById(R.id.rv_json_homework);
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Lista de Tareas" + postHomeworks);
        System.out.println("============================================");
        System.out.println("============================================");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*courseAdapter = new CourseAdapter(postCourses, activity);
        recyclerView.setAdapter(courseAdapter);*/
        if (getIntent().getExtras() != null) {
            position = getIntent().getIntExtra("position", 0);
        }
        showPruebaH();
    }

    private void showPruebaH() {
        Call<ResponseData> call = ApiService.getRetrofit().create(getPost.class).showStudent();
        call.enqueue(new Callback<ResponseData>() { // Importante
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData mData = response.body();
                if (mData != null && response.isSuccessful()) {
                    postHomeworks = mData.getEstudiantes().get(position).getCursos().get(position).getTareas();
                    homeworkAdapter = new HomeworkAdapter(postHomeworks, activity);
                    recyclerView.setAdapter(homeworkAdapter);
                } else {
                    System.out.println("No hay data");
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(HomeworkActivity.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
