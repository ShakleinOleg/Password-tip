package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

public class RandomFragment extends Fragment {
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

        setCustomSwitchListener();
        setSelectionRequiredListener();

        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAction();
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

    private void setSelectionRequiredListener() {
        CompoundButton.OnCheckedChangeListener listener = selectionRequiredListener();
        mUpperCaseSwitch.setOnCheckedChangeListener(listener);
        mLowerCaseSwitch.setOnCheckedChangeListener(listener);
        mNumberSwitch.setOnCheckedChangeListener(listener);
        mSpecialCharSwitch.setOnCheckedChangeListener(listener);
    }

    private CompoundButton.OnCheckedChangeListener selectionRequiredListener() {
        final List<SwitchCompat> switchGroup = new ArrayList<>();

        switchGroup.add(mUpperCaseSwitch);
        switchGroup.add(mLowerCaseSwitch);
        switchGroup.add(mNumberSwitch);
        switchGroup.add(mSpecialCharSwitch);
        switchGroup.add(mCustomCharsetSwitch);

        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (int i = 0; i < switchGroup.size(); i++) {
                    if (switchGroup.get(i).isChecked()) {
                        return;
                    }
                }
                buttonView.setChecked(true);
            }
        };
    }

    private void setCustomSwitchListener() {
        CompositeOnCheckedChangeListener listener = new CompositeOnCheckedChangeListener();
        listener.add(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mUpperCaseSwitch.setEnabled(false);
                    mLowerCaseSwitch.setEnabled(false);
                    mNumberSwitch.setEnabled(false);
                    mSpecialCharSwitch.setEnabled(false);
                    mWordInput.setVisibility(View.VISIBLE);
                } else {
                    mUpperCaseSwitch.setEnabled(true);
                    mLowerCaseSwitch.setEnabled(true);
                    mNumberSwitch.setEnabled(true);
                    mSpecialCharSwitch.setEnabled(true);
                    mWordInput.setVisibility(View.GONE);
                }
            }
        });

        listener.add(selectionRequiredListener());
        mCustomCharsetSwitch.setOnCheckedChangeListener(listener);
    }

    private void generateAction() {
        PasswordGenerator generator = createGenerator();
        String generatedPassword = generator.generate();
        mPasswordTitle.setText(generatedPassword);
    }

    private PasswordGenerator createGenerator() {
        if (mCustomCharsetSwitch.isChecked()) {
            return new PasswordGenerator(mLentBar.getProgress(), mWordInput.getText().toString());
        } else {
            return new PasswordGenerator(
                    mLentBar.getProgress(),
                    mUpperCaseSwitch.isChecked(),
                    mLowerCaseSwitch.isChecked(),
                    mSpecialCharSwitch.isChecked(),
                    mNumberSwitch.isChecked()
            );
        }
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }

    private class CompositeOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        private List<CompoundButton.OnCheckedChangeListener> mListeners = new ArrayList<>();

        void add(CompoundButton.OnCheckedChangeListener listener) {
            mListeners.add(listener);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            for (int i = 0; i < mListeners.size(); i++) {
                mListeners.get(i).onCheckedChanged(buttonView, isChecked);
            }
        }
    }
}