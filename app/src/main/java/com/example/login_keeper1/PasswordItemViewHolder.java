package com.example.login_keeper1;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_keeper1.storage.entities.PasswordEntity;
import com.google.crypto.tink.Aead;

import java.security.GeneralSecurityException;

public class PasswordItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView mWebsiteName;
    private final TextView mLoginName;
    private final TextView mPasswordField;
    private final Button mCopyButton;
    private final ToggleButton mShowPassword;
    byte[] mAssociatedData;
    Aead mAead;
    private PasswordEntity mModel;

    public PasswordItemViewHolder(@NonNull final View itemView) {
        super(itemView);

        mWebsiteName = itemView.findViewById(R.id.websiteName);
        mLoginName = itemView.findViewById(R.id.loginView);
        mPasswordField = itemView.findViewById(R.id.passwordField);
        mCopyButton = itemView.findViewById(R.id.copyButton);
        mShowPassword = itemView.findViewById(R.id.showPassword);
        mCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyToClipboard();
                Toast.makeText(itemView.getContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        mShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updatePasswordField(!isChecked);
            }
        });
    }

    void bindTo(PasswordEntity entity) {
        mModel = entity;
        mWebsiteName.setText(entity.website);
        mLoginName.setText(entity.username);
        updatePasswordField(!mShowPassword.isChecked());
    }

    private void updatePasswordField(boolean isHidden) {
        if (isHidden) {
            mPasswordField.setText("**************");
        } else {
            String decryptedPassword = decryptPassword();
            mPasswordField.setText(decryptedPassword);
        }
    }

    private void copyToClipboard() {
        ClipboardUtils.copyToClipboard(itemView.getContext(), "Password for " + mModel.website, decryptPassword());
    }

    private String decryptPassword() {
        try {
            byte[] decrypted = mAead.decrypt(mModel.password, mAssociatedData);
            return new String(decrypted);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}