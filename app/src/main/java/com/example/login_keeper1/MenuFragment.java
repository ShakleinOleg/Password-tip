package com.example.login_keeper1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

    public class MenuFragment extends Fragment {
        private Button mRegisterButton;
        private Button mRegisterButton2;
        private Button mRegisterButton3;
        private Button mRegisterButton4;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.activity_menu_fragment, container, false);

            mRegisterButton = view.findViewById(R.id.register);
            mRegisterButton2 = view.findViewById(R.id.register2);
            mRegisterButton3 = view.findViewById(R.id.register3);
            mRegisterButton4 = view.findViewById(R.id.register4);

            mRegisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToRandomFragment();
                }
            });
            mRegisterButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToSettingsFragment();
                }
            });
            mRegisterButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToPasswordFragment();
                }
            });
            mRegisterButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToMainPageFragment();
                }
            });
            return view;
        }
            // we no need to have different layouts for login and register page since they have the same layout
            // we need just to update login button text
        private void navigateToSettingsFragment() {
             NavHostFragment.findNavController(this).navigate(R.id.main5);
        }
        private void navigateToPasswordFragment() {
            NavHostFragment.findNavController(this).navigate(R.id.main6);
        }
        private void navigateToRandomFragment() {
            NavHostFragment.findNavController(this).navigate(R.id.main4);
        }
        private void navigateToMainPageFragment() {
            NavHostFragment.findNavController(this).navigate(R.id.main11);
        }
    }

