package com.example.login_keeper1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        Button mGenerateButton = view.findViewById(R.id.generatePassword);
        Button mSettingsButton = view.findViewById(R.id.settings);
        Button mChangePasswordButton = view.findViewById(R.id.changePassword);
        Button mBackButton = view.findViewById(R.id.back);

        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRandomFragment();
            }
        });
        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSettingsFragment();
            }
        });
        mChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToChangePasswordFragment();
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainPageFragment();
            }
        });
        return view;
    }

    private void navigateToSettingsFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_settingsFragment);
    }

    private void navigateToChangePasswordFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_passwordFragment);
    }

    private void navigateToRandomFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_randomFragment);
    }

    private void navigateToMainPageFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }
}

