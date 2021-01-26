package com.example.login_keeper1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login_keeper1.storage.PasswordsStorageFactory;
import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.StorageProvider;

public class LoginKeeperApplication extends Application implements StorageProvider {
    @Nullable
    private RoomPasswordsStorage storage;

    @Override
    @NonNull
    public RoomPasswordsStorage provideStorage() {
        if (storage == null) {
            storage = new PasswordsStorageFactory().createStorage(this);
        }
        return storage;
    }
}
