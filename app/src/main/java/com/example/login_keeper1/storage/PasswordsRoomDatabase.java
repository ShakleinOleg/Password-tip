package com.example.login_keeper1.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.login_keeper1.storage.entities.PasswordEntity;


@Database(entities = {PasswordEntity.class}, version = 1)
public abstract class PasswordsRoomDatabase extends RoomDatabase {
    abstract RoomPasswordKeeperDao passwordsDao();
}
