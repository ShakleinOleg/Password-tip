package com.example.login_keeper1;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.AuthEntity;

public class AuthorizationFragment extends Fragment {
    private EditText mPasswordInput;
    private Button mRegisterButton;
    private RoomPasswordsStorage mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mPasswordInput = view.findViewById(R.id.password);
        mRegisterButton = view.findViewById(R.id.register);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processLoginAction();
            }
        });


        mPasswordInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    processLoginAction();
                    return true;
                }

                return false;
            }
        });

        mStorage = ((LoginKeeperApplication) getContext().getApplicationContext()).provideStorage();

        updateLoginButtonText();

        return view;
    }

    private void processLoginAction() {
        if (isRegistered()) {
            handleLoginAction();
        } else {
            handleRegisterAction();
        }
    }

    private void updateLoginButtonText() {
        if (isRegistered()) {
            mRegisterButton.setText(R.string.login);
        } else {
            mRegisterButton.setText(R.string.register);
        }
    }

    private boolean isRegistered() {
        return mStorage.auth() != null;
    }

    private void handleLoginAction() {
        AuthEntity entity = mStorage.auth();
        String password = mPasswordInput.getText().toString();

        if (entity.password.equals(password)) {
            navigateToMainPageFragment();
        } else {
            Toast.makeText(getContext(), "Wrong password", Toast.LENGTH_LONG).show();
        }
    }

    private void handleRegisterAction() {
        String password = mPasswordInput.getText().toString();

        if (password.length() < 4) {
            Toast.makeText(getContext(), "Password to short", Toast.LENGTH_LONG).show();
            return;
        }

        AuthEntity entity = new AuthEntity();
        entity.password = password;

        mStorage.putAuth(entity);

        navigateToMainPageFragment();
    }

    private void navigateToMainPageFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_authorizationFragment_to_mainPageFragment);
    }
}