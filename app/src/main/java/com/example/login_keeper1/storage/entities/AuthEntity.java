package com.example.login_keeper1.storage.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "auth")
public class AuthEntity {
    @PrimaryKey
    @NonNull
    public String password;
}
