package com.example.login_keeper1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class NewRecordFragment extends Fragment {
    private EditText mTitleInput;
    private EditText mUsernameInput;
    private EditText mWebsiteInput;
    private EditText mPasswordInput;
    private Button mAddRecordButton;
    private Button mBackButton;

    private RoomPasswordsStorage mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_record_fragment, container, false);
        LoginKeeperApplication appContext = ((LoginKeeperApplication) getContext().getApplicationContext());
        mStorage = appContext.provideStorage();

        mTitleInput = view.findViewById(R.id.titleInput);
        mUsernameInput = view.findViewById(R.id.usernameInput);
        mWebsiteInput = view.findViewById(R.id.websiteInput);
        mPasswordInput = view.findViewById(R.id.passwordInput);
        mAddRecordButton = view.findViewById(R.id.addRecord);
        mBackButton = view.findViewById(R.id.back);

        mBackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainPageFragment();
            }
        });

        mAddRecordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPasswordInput.length() == 0) {
                    toastMessage("Something went wrong");
                    return;
                }

                PasswordEntity entity = new PasswordEntity();

                entity.title = mTitleInput.getText().toString();
                entity.username = mUsernameInput.getText().toString();
                entity.website = mWebsiteInput.getText().toString();
                entity.password = mPasswordInput.getText().toString();

                List<PasswordEntity> data = new ArrayList<>();
                data.add(entity);

                mStorage.putPasswords(data);
            }
        });

        return view;
    }

    private void toastMessage(String messages) {
        Toast.makeText(getContext(), messages, Toast.LENGTH_SHORT).show();
    }

    private void navigateToMainPageFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }
}
