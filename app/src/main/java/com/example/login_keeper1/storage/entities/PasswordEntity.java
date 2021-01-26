package com.example.login_keeper1.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "passwords")
public class PasswordEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "website")
    public String website;

    @ColumnInfo(name = "password")
    public String password;
}
