package com.bruno.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.widget.Toast;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.bruno.myapplication.R;
import com.bruno.myapplication.adapter.StudentAdapter;
import com.bruno.myapplication.models.PostStudent;
import com.bruno.myapplication.services.ApiService;
import com.bruno.myapplication.services.ResponseData;
import com.bruno.myapplication.services.getPost;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PostStudent> postStudents = new ArrayList<>();
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;

        recyclerView = findViewById(R.id.rv_json);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter(postStudents, activity);
        recyclerView.setAdapter(studentAdapter);

        showPrueba();
    }

    private void showPrueba() { // ShowPrueba llama al ResponseData de la lista de estudiantes
        Call<ResponseData> call = ApiService.getRetrofit().create(getPost.class).showStudent();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData mData = response.body(); // OnResponse obtiene la lista mediante el mData de Estudiantes
                System.out.println("============================================");
                System.out.println("============================================");
                System.out.println("Respuesta: " + mData.getEstudiantes());
                System.out.println("============================================");
                System.out.println("============================================");
                // El if esta diciendo 'si la respuesta es satisfactoria (Si la lista tiene datos) se puede acceder a los datos de esa lista
                if (mData != null && response.isSuccessful()) {
                    postStudents = mData.getEstudiantes();
                    studentAdapter = new StudentAdapter(postStudents, activity);
                    recyclerView.setAdapter(studentAdapter);
                }else{
                    System.out.println("No hay data");
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXIÓN: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace(); // Agrega esta línea para ver detalles de la excepción en la consola
            }

        });
    }
}