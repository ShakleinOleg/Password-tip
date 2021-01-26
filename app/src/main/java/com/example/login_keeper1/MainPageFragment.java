package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.PasswordEntity;

import java.util.List;

public class MainPageFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private Button mMenuButton;
    private Button mNewRecordButton;
    private PasswordListAdapter mAdapter;
    private RoomPasswordsStorage mStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PasswordListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mMenuButton = view.findViewById(R.id.menu);
        mNewRecordButton = view.findViewById(R.id.newRecord);


        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenuFragment();
            }
        });
        mNewRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNewRecordFragment();
            }
        });

        populateListView();
        return view;
    }

    private void populateListView() {
        LoginKeeperApplication appContext = ((LoginKeeperApplication) getContext().getApplicationContext());
        mStorage = appContext.provideStorage();

        List<PasswordEntity> entities = mStorage.passwords();
        mAdapter.submit(entities);
    }

    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_menuFragment);
    }

    private void navigateToNewRecordFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_newRecordFragment);
    }
}
