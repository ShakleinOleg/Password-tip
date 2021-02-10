package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.PasswordEntity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class NewRecordFragment extends Fragment {
    private EditText mTitleInput;
    private EditText mUsernameInput;
    private EditText mWebsiteInput;
    private EditText mPasswordInput;
    private TextView mPasswordCaption;
    private MaterialToolbar mToolbar;

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
        mToolbar = view.findViewById(R.id.materialToolbar);
        mPasswordCaption = view.findViewById(R.id.passwordCaption);

        mToolbar = view.findViewById(R.id.materialToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainPageFragment();
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                saveAction();
                return true;
            }
        });

        return view;
    }

    private void saveAction() {
        if (assertAllFieldNotEmpty()) {
            return;
        }

        PasswordEntity entity = new PasswordEntity();

        entity.title = mTitleInput.getText().toString();
        entity.username = mUsernameInput.getText().toString();
        entity.website = mWebsiteInput.getText().toString();
        entity.password = encryptPassword(mPasswordInput.getText().toString());

        List<PasswordEntity> data = new ArrayList<>();
        data.add(entity);

        mStorage.putPasswords(data);

        navigateToMainPageFragment();
    }

    private byte[] encryptPassword(String password) {
        try {
            KeysetHandle keysetHandle = CryptUtils.keysetHandle(getContext());
            Aead aead = keysetHandle.getPrimitive(Aead.class);

            byte[] associatedData = mStorage.auth().password.getBytes();
            return aead.encrypt(password.getBytes(), associatedData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String password = NewRecordFragmentArgs.fromBundle(getArguments()).getGeneratedPassword();
        if (password == null) {
            configureRawNewRecord();
        } else {
            configureGenerated(password);
        }
    }

    private void configureRawNewRecord() {
        mPasswordInput.setEnabled(true);
        mPasswordCaption.setText("Insert password");
    }

    private void configureGenerated(String password) {
        mPasswordInput.setText(password);
        mPasswordInput.setEnabled(false);
        mPasswordCaption.setText("Generated password");
    }

    private void toastMessage(String messages) {
        Toast.makeText(getContext(), messages, Toast.LENGTH_SHORT).show();
    }

    private boolean assertAllFieldNotEmpty() {
        if (mTitleInput.getText().toString().isEmpty()
                || mUsernameInput.getText().toString().isEmpty()
                || mWebsiteInput.getText().toString().isEmpty()
                || mPasswordInput.getText().toString().isEmpty()) {
            toastMessage("You should fill all records");
            return true;
        }

        return false;
    }

    private void navigateToMainPageFragment() {
        NavHostFragment.findNavController(this).popBackStack();
    }
}
