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

    public class PageFragment2 extends Fragment {
        private Button mRegisterButton;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.activity_page_fragment2, container, false);

            mRegisterButton = view.findViewById(R.id.register);

            mRegisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToMainPageFragment();
                }
            });

            // we no need to have different layouts for login and register page since they have the same layout
            // we need just to update login button text
            return view;
        }

        private void navigateToMainPageFragment() {
            NavHostFragment.findNavController(this).navigate(R.id.main7);
        }
    }
