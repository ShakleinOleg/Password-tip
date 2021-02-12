package com.example.login_keeper1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_keeper1.storage.entities.PasswordEntity;
import com.google.crypto.tink.Aead;

import java.util.ArrayList;
import java.util.List;

public class PasswordListAdapter extends RecyclerView.Adapter<PasswordItemViewHolder> {

    private final Aead mAead;
    byte[] mAssociatedData;

    public PasswordListAdapter(Aead aead, byte[] associatedData) {
        mAead = aead;
        mAssociatedData = associatedData;
    }

    private List<PasswordEntity> models = new ArrayList<>();

    @NonNull
    @Override
    public PasswordItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_list_item, parent, false);
        PasswordItemViewHolder holder = new PasswordItemViewHolder(view);

        holder.mAead = mAead;
        holder.mAssociatedData = mAssociatedData;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PasswordItemViewHolder holder, int position) {
        holder.bindTo(models.get(position));
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