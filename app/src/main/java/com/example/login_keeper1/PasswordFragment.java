package com.example.login_keeper1;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.concurrent.ThreadLocalRandom;

public class PasswordFragment extends Fragment {
            private Button mRegisterButton;
            private TextView Password;
            private SeekBar LentBar;
            private Button Genbutt;

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                View view = inflater.inflate(R.layout.activity_password_fragment, container, false);

                mRegisterButton = view.findViewById(R.id.register);

                mRegisterButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navigateToMenuFragment();
                    }
                });

                // we no need to have different layouts for login and register page since they have the same layout
                // we need just to update login button text
                return view;
            }

            private void navigateToMenuFragment() {
                NavHostFragment.findNavController(this).navigate(R.id.main10);
            }

            private static final int MIN_CODE = 33, MAX_CODE = 126;

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            private static String process(int length){
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < length; i++){
                    builder.append((char) ThreadLocalRandom.current().nextInt(MIN_CODE, MAX_CODE + 1));
                }

                return builder.toString();
            }
        }
