package com.example.login_keeper1;

import android.content.Context;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;

public class CryptUtils {
    private static final String PREF_FILE_NAME = "password_tip_pref";
    private static final String TINK_KEYSET_NAME = "password_tip_keyset";
    private static final String MASTER_KEY_URI = "android-keystore://password_tip_master_key";

    static KeysetHandle keysetHandle(Context context) {
        try {
            return new AndroidKeysetManager.Builder()
                    .withSharedPref(context.getApplicationContext(), TINK_KEYSET_NAME, PREF_FILE_NAME)
                    .withKeyTemplate(AeadKeyTemplates.AES256_GCM)
                    .withMasterKeyUri(MASTER_KEY_URI)
                    .build()
                    .getKeysetHandle();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
