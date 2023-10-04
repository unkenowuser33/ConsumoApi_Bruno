package com.bruno.myapplication.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bruno.myapplication.activities.CourseActivity;
import com.bruno.myapplication.R;
import com.bruno.myapplication.activities.HomeworkActivity;
import com.bruno.myapplication.models.PostCourse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<PostCourse> postCourses;
    private Activity activity;

    public CourseAdapter(List<PostCourse> postCourses, Activity activity) {
        this.postCourses = postCourses;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_course_listas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostCourse postCourse = postCourses.get(position);

        holder.tvIdC.setText(String.valueOf(postCourse.getId().toString()));
        holder.tvNombreC.setText(postCourse.getNombre());
        holder.tvCodigoC.setText(String.valueOf(postCourse.getCodigo()));
        holder.tvProfesorC.setText(postCourse.getProfesor());
        holder.tvCalificacionC.setText(String.valueOf(postCourse.getCalificacion().toString()));
        Picasso.get().load(postCourse.getImagen_url()).into(holder.ivImagenC);

        Intent enviar = new Intent(activity, HomeworkActivity.class);

        enviar.putExtra("position",position);
        enviar.putExtra("idCursos", postCourses.get(position).getId());
        holder.act_course_lst_ly.setOnClickListener(view -> {
            activity.startActivity(enviar);
        });
    }

    @Override
    public int getItemCount() {
        return postCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdC;
        private TextView tvNombreC;
        private TextView tvCodigoC;
        private TextView tvProfesorC;
        private TextView tvCalificacionC;
        private ImageView ivImagenC;

        private LinearLayout act_course_lst_ly;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            act_course_lst_ly = itemView.findViewById(R.id.act_course_lst_ly);
            tvIdC = itemView.findViewById(R.id.tvIdC);
            tvNombreC = itemView.findViewById(R.id.tvNombreC);
            tvCodigoC = itemView.findViewById(R.id.tvCodigoC);
            tvProfesorC = itemView.findViewById(R.id.tvProfesorC);
            tvCalificacionC = itemView.findViewById(R.id.tvCalificacionC);
            ivImagenC = itemView.findViewById(R.id.ivImagenC);
        }
    }
}
