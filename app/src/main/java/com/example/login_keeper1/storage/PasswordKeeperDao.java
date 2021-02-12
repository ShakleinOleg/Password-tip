package com.example.login_keeper1.storage;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.login_keeper1.storage.entities.AuthEntity;
import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.List;

public interface PasswordKeeperDao {

    void putAuth(AuthEntity auth);
    @Nullable
    AuthEntity auth();
    void deleteAuth();

    List<PasswordEntity> passwords();
    void putPasswords(List<PasswordEntity> passwords);
    void deleteAllPasswords();
}
