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

import com.bruno.myapplication.R;
import com.bruno.myapplication.activities.HomeworkActivity;
import com.bruno.myapplication.models.PostHomework;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder> {
    private List<PostHomework> postHomeworks;
    private Activity activity;

    public HomeworkAdapter(List<PostHomework> postHomeworks, Activity activity) {
        this.postHomeworks = postHomeworks;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_homework_listas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostHomework postHomework = postHomeworks.get(position);

        holder.tvIdH.setText(String.valueOf(postHomework.getId().toString()));
        holder.tvTituloH.setText(postHomework.getTitulo());
        holder.tvDescripcionH.setText(String.valueOf(postHomework.getDescripcion()));
        holder.tvNivelH.setText(postHomework.getNivel());
        holder.tvEntregaH.setText(postHomework.getFecha_entrega());

        Intent enviar = new Intent(activity, HomeworkAdapter.class);
        enviar.putExtra("position",position);
        enviar.putExtra("idTareas", postHomeworks.get(position).getId());
        holder.act_homework_lst_ly.setOnClickListener(view -> {
            activity.startActivity(enviar);
        });
    }

    @Override
    public int getItemCount() {
        return postHomeworks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdH;
        private TextView tvTituloH;
        private TextView tvDescripcionH;
        private TextView tvNivelH;
        private TextView tvEntregaH;

        private LinearLayout act_homework_lst_ly;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            act_homework_lst_ly = itemView.findViewById(R.id.act_homework_lst_ly);
            tvIdH = itemView.findViewById(R.id.tvIdH);
            tvTituloH = itemView.findViewById(R.id.tvTituloH);
            tvDescripcionH = itemView.findViewById(R.id.tvDescripcionH);
            tvNivelH = itemView.findViewById(R.id.tvNivelH);
            tvEntregaH = itemView.findViewById(R.id.tvEntregaH);
        }
    }
}
