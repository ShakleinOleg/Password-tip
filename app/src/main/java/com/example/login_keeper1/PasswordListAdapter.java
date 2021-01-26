package com.example.login_keeper1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class PasswordListAdapter extends RecyclerView.Adapter<PasswordItemViewHolder> {

    private List<PasswordEntity> models = new ArrayList<>();

    @NonNull
    @Override
    public PasswordItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_list_item, parent, false);
        return new PasswordItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PasswordItemViewHolder holder, int position) {
        holder.bindTo(models.get(position).website);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void submit(List<PasswordEntity> models) {
        this.models = models;
        notifyDataSetChanged();
    }
}