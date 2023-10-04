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
import com.bruno.myapplication.models.PostStudent;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<PostStudent> postStudents;
    private Activity activity;

    public StudentAdapter(List<PostStudent> postStudents, Activity activity) {
        this.postStudents = postStudents;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_listas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostStudent postStudent = postStudents.get(position);

        holder.tvIdA.setText(String.valueOf(postStudent.getId().toString()));
        holder.tvNombreA.setText(postStudent.getNombre());
        holder.tvEdadA.setText(String.valueOf(postStudent.getEdad()));
        holder.tvCorreo.setText(postStudent.getEmail());
        Picasso.get().load(postStudent.getImagen_url()).into(holder.ivImagenA);

        holder.act_main_lst_ly.setOnClickListener(view -> {
            Intent enviar = new Intent(activity, CourseActivity.class);
            enviar.putExtra("position",position);
            enviar.putExtra("idStudiante", postStudents.get(position).getId());
            activity.startActivity(enviar);
        });
    }

    @Override
    public int getItemCount() {
        return postStudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdA;
        private TextView tvNombreA;
        private TextView tvEdadA;
        private TextView tvCorreo;
        private ImageView ivImagenA;

        private LinearLayout act_main_lst_ly;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            act_main_lst_ly = itemView.findViewById(R.id.act_main_lst_ly);
            tvIdA = itemView.findViewById(R.id.tvIdA);
            tvNombreA = itemView.findViewById(R.id.tvNombreA);
            tvEdadA = itemView.findViewById(R.id.tvEdadA);
            tvCorreo = itemView.findViewById(R.id.tvCorreoA);
            ivImagenA = itemView.findViewById(R.id.ivImagenA);
        }
    }
}
