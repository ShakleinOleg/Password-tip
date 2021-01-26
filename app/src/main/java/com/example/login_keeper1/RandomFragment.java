package com.example.login_keeper1;

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
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class RandomFragment extends Fragment {
//    DatabaseHelper databaseHelper;

    private TextView mPasswordTitle;
    private SeekBar mLentBar;
    private Button mGenerateButton;
    private SwitchCompat mLowerCaseSwitch;
    private SwitchCompat mUpperCaseSwitch;
    private SwitchCompat mNumberSwitch;
    private SwitchCompat mSpecialCharSwitch;
    private SwitchCompat mCustomCharsetSwitch;
    private EditText mWordInput;
    private Button mRegisterButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_random, container, false);


        mPasswordTitle = view.findViewById(R.id.passwordTitle);
        mLentBar = view.findViewById(R.id.lentBar);
        mGenerateButton = view.findViewById(R.id.generate);
        mLowerCaseSwitch = view.findViewById(R.id.lowerCaseSwitch);
        mUpperCaseSwitch = view.findViewById(R.id.upperCaseSwitch);
        mNumberSwitch = view.findViewById(R.id.numberSwitch);
        mSpecialCharSwitch = view.findViewById(R.id.specialCharsSwitch);
        mCustomCharsetSwitch = view.findViewById(R.id.customCharsetSwitch);
        mWordInput = view.findViewById(R.id.wordInput);
        mRegisterButton = view.findViewById(R.id.register);

        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPasswordTitle.setText(genstr(mLentBar.getProgress()));
            }
        });

//        mLentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {
//                mLentBar.setProgress(progress);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
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