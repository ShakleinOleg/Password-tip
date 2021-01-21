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

public class MainPageFragment extends Fragment {
    private EditText mLoginInput;
    private Button mRegisterButton;
    private Button mRegisterButton2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        mRegisterButton = view.findViewById(R.id.register);
        mRegisterButton2 = view.findViewById(R.id.register2);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenuFragment();
            }
        });
        mRegisterButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPageFragment2();
            }
        });
        return view;
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.main2);
    }
    private void navigateToPageFragment2() {
        NavHostFragment.findNavController(this).navigate(R.id.main3);
    }
}
