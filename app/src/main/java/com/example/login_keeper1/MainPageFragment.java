package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_keeper1.storage.RoomPasswordsStorage;
import com.example.login_keeper1.storage.entities.PasswordEntity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainPageFragment extends Fragment {
    private RecyclerView mRecyclerView;
//    private Button mNewRecordButton;
    private PasswordListAdapter mAdapter;
    private RoomPasswordsStorage mStorage;
    private MaterialToolbar mToolbar;
    private DrawerLayout mDrawer;
    private NavigationView mDrawerNavigation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PasswordListAdapter();
        mRecyclerView.setAdapter(mAdapter);

//        mNewRecordButton = view.findViewById(R.id.newRecord);

//        mNewRecordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navigateToNewRecordFragment();
//            }
//        });

        mDrawer = view.findViewById(R.id.drawerLayout);
        mDrawerNavigation = view.findViewById(R.id.drawerNavigation);

        mToolbar = view.findViewById(R.id.materialToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.open();
            }
        });

        mDrawerNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.generatePassword:
                        navigateToRandomFragment();
                        return true;
                    case R.id.settings:
                        navigateToSettingsFragment();
                        return true;
                    case R.id.changePassword:
                        navigateToChangePasswordFragment();
                        return true;
                    default: return false;
                }
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

    private void navigateToNewRecordFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_mainPageFragment_to_newRecordFragment);
    }

    private void navigateToSettingsFragment() {
        mDrawer.close();
        NavHostFragment.findNavController(this).navigate(R.id.action_menu_to_settingsFragment);
    }

    private void navigateToChangePasswordFragment() {
        mDrawer.close();
        NavHostFragment.findNavController(this).navigate(R.id.action_menu_to_passwordFragment);
    }

    private void navigateToRandomFragment() {
        mDrawer.close();
        NavHostFragment.findNavController(this).navigate(R.id.action_menu_to_randomFragment);
    }
}
