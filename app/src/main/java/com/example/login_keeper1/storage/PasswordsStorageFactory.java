package com.example.login_keeper1.storage;

import android.content.Context;

import androidx.room.Room;

public class PasswordsStorageFactory {
    public RoomPasswordsStorage createStorage(Context context) {
        return new RoomPasswordsStorage(
                Room.databaseBuilder(
                        context.getApplicationContext(),
                        PasswordsRoomDatabase.class,
                        "passwords.db"
                )
                        .allowMainThreadQueries()
                        .build()
        );
    }
}
