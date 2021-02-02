package com.example.login_keeper1.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.login_keeper1.storage.entities.AuthEntity;
import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.List;

@Dao
public abstract class RoomPasswordKeeperDao implements PasswordKeeperDao {
    @Insert
    public abstract void putAuth(AuthEntity auth);

    @Query("SELECT * FROM auth LIMIT 1")
    public abstract AuthEntity auth();

    @Query("DELETE FROM passwords")
    public abstract void deleteAuth();

    @Query("SELECT * FROM passwords")
    public abstract List<PasswordEntity> passwords();

    @Insert
    public abstract void putPasswords(List<PasswordEntity> passwords);

    @Query("DELETE FROM passwords")
    public abstract void deleteAllPasswords();
}
