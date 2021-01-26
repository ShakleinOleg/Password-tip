package com.example.login_keeper1.storage;

import androidx.lifecycle.LiveData;

import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.List;

public interface PasswordKeeperDao {
    List<PasswordEntity> passwords();
    void putPasswords(List<PasswordEntity> passwords);
    void deleteAllPasswords();
}
