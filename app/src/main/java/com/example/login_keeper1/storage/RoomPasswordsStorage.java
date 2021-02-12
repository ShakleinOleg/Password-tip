package com.example.login_keeper1.storage;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;


import com.example.login_keeper1.storage.entities.AuthEntity;
import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.List;

public class RoomPasswordsStorage implements PasswordKeeperDao {
    private final PasswordKeeperDao dao;
    public RoomPasswordsStorage(PasswordsRoomDatabase db) {
        this.dao = db.passwordsDao();
    }

    @Override
    public void putAuth(AuthEntity auth) {
        dao.putAuth(auth);
    }

    @Override
    @Nullable
    public AuthEntity auth() {
        return dao.auth();
    }

    @Override
    public void deleteAuth() {
        dao.deleteAuth();
    }

    @Override
    public List<PasswordEntity> passwords() {
        return dao.passwords();
    }

    @Override
    public void putPasswords(List<PasswordEntity> passwords) {
        dao.putPasswords(passwords);
    }

    @Override
    public void deleteAllPasswords() {
        dao.deleteAllPasswords();
    }
}
