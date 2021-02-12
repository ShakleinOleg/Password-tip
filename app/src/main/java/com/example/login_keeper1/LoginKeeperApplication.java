package com.example.login_keeper1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login_keeper1.storage.PasswordsStorageFactory;
import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.StorageProvider;
import com.google.crypto.tink.aead.AeadConfig;

import java.security.GeneralSecurityException;

public class LoginKeeperApplication extends Application implements StorageProvider {
    @Nullable
    private RoomPasswordsStorage storage;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            AeadConfig.register();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @NonNull
    public RoomPasswordsStorage provideStorage() {
        if (storage == null) {
            storage = new PasswordsStorageFactory().createStorage(this);
        }
        return storage;
    }
}
