package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SettingsFragment extends Fragment {
    private CheckBox mHidePasswordBox;
    private CheckBox mShowCopyBox;
    private CheckBox mShowNotificationBox;
    private SwitchCompat mDarkModeSwitch;
    private CheckBox mHideAutoclearingBox;
    private CheckBox mAllowScreenshotBox;
    private CheckBox mDestructionBox;
    private Button mAcceptChanges;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mHidePasswordBox = view.findViewById(R.id.hidePasswordBox);
        mShowCopyBox = view.findViewById(R.id.showCopyBox);
        mShowNotificationBox = view.findViewById(R.id.showNotificationBox);
        mDarkModeSwitch = view.findViewById(R.id.darkModeSwitch);
        mHideAutoclearingBox = view.findViewById(R.id.hideAutoclearingBox);
        mAllowScreenshotBox = view.findViewById(R.id.allowScreenshotBox);
        mDestructionBox = view.findViewById(R.id.destructionBox);
        mAcceptChanges = view.findViewById(R.id.acceptChanges);

        mAcceptChanges.setOnClickListener(new View.OnClickListener() {
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
}
