package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class PasswordFragment extends Fragment {

    private EditText mOldPasswordInput;
    private EditText mNewPasswordInput;
    private EditText mConfirmPasswordInput;

    private Button mChangePasswordButton;

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
                navigateToMenuFragment();
            }
        });

        return view;
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }
}
