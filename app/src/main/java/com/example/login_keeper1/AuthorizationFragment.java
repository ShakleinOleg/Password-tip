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

public class AuthorizationFragment extends Fragment {
    private EditText mLoginInput;
    private EditText mPasswordInput;
    private Button mRegisterButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginInput = view.findViewById(R.id.login);
        mPasswordInput = view.findViewById(R.id.password);
        mRegisterButton = view.findViewById(R.id.register);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistered()) {
                    handleLoginAction();
                } else {
                    handleRegisterAction();
                }
            }
        });

        // we no need to have different layouts for login and register page since they have the same layout
        // we need just to update login button text
        updateLoginButtonText();

        return view;
    }

    private void updateLoginButtonText() {
        if (isRegistered()) {
            mRegisterButton.setText(R.string.login);
        } else {
            mRegisterButton.setText(R.string.register);
        }
    }

    // This method should check if user is registered.
    private boolean isRegistered() {
        return true;
    }

    private void handleLoginAction() {
        // Here we need to validate entered credentials
        // need to check database is entered credentials is valid

        String login = mLoginInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        // if validation is OK we need to show next screen
        // if validation is failed we need show some kind of error to user
        navigateToMainPageFragment();
    }

    private void handleRegisterAction() {
        // Here we need to validate entered credentials

        String login = mLoginInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        // if validation is OK we need to show next screen
        // if validation is failed we need show some kind of error to user
        navigateToMainPageFragment();
    }

    private void navigateToMainPageFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_authorizationFragment_to_mainPageFragment);
    }
}