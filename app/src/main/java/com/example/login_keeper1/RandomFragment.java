package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class RandomFragment extends Fragment {
    private Button mRegisterButton;
    private TextView Password;
    private SeekBar LentBar;
    private Button Genbutt;

    DatabaseHelper databaseHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_random_fragment, container, false);

        mRegisterButton = view.findViewById(R.id.register);
        Password = view.findViewById(R.id.passwoord);
        LentBar = view.findViewById(R.id.LentBar);
        Genbutt = view.findViewById(R.id.Genbutt);

        LentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {
                LentBar.setProgress(progress);
                Genbutt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Password.setText(genstr(progress));
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenuFragment();
            }
        });

        return view;
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.main8);
    }

    private String genstr(int length) {
        char[] chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890".toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = chars[r.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}