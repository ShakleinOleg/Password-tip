package com.example.login_keeper1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PasswordItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView mWebsiteName;

    public PasswordItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mWebsiteName = itemView.findViewById(R.id.websiteName);
    }

    void bindTo(String websiteName) {
        mWebsiteName.setText(websiteName);
    }
}