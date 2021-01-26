package com.example.login_keeper1.storage;

import androidx.annotation.NonNull;

public interface StorageProvider {
    @NonNull
    RoomPasswordsStorage provideStorage();
}
