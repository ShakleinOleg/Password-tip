package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.AuthEntity;

public class PasswordFragment extends Fragment {

    private EditText mOldPasswordInput;
    private EditText mNewPasswordInput;
    private EditText mConfirmPasswordInput;

    private Button mChangePasswordButton;
    private RoomPasswordsStorage mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        mOldPasswordInput = view.findViewById(R.id.oldPasswordInput);
        mNewPasswordInput = view.findViewById(R.id.newPasswordInput);
        mConfirmPasswordInput = view.findViewById(R.id.confirmPasswordInput);

        mChangePasswordButton = view.findViewById(R.id.changePassword);

        mChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePassword();
            }
        });

        mStorage = ((LoginKeeperApplication) getContext().getApplicationContext()).provideStorage();

        return view;
    }

    private void updatePassword() {
        AuthEntity entity = mStorage.auth();

        if (!entity.password.equals(mOldPasswordInput.getText().toString())) {
            Toast.makeText(getContext(), "Entered password doesnt match our records", Toast.LENGTH_LONG).show();
            return;
        }

        String newPassword = mNewPasswordInput.getText().toString();
        String confirmPassword = mConfirmPasswordInput.getText().toString();

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(getContext(), "Passwords not match. Check entered passwords.", Toast.LENGTH_LONG).show();
            return;
        }

        AuthEntity newAuth = new AuthEntity();

        newAuth.password = newPassword;
        mStorage.putAuth(newAuth);
        navigateToMenuFragment();
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }
}
