package com.example.login_keeper1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainPageFragment extends Fragment {

    private static final String TAG = "ListDataActivity";

    DatabaseHelper databaseHelper;
    private TextView mLoginInput;
    private Button mRegisterButton;
    private Button mRegisterButton2;
    private ListView ListView;
    private Object DatabaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        mRegisterButton = view.findViewById(R.id.register);
        mRegisterButton2 = view.findViewById(R.id.register2);
        ListView = view.findViewById(R.id.ListView);
        DatabaseHelper = new DatabaseHelper(this);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenuFragment();
            }
        });
        mRegisterButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPageFragment2();
            }
        });
        populateListView();
        return view;
    }

    private void populateListView() {
        Log.d(TAG, "populatedLastView: Displaying data in the ListView");
        Cursor data = DatabaseHelper.GetData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            ListData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, ListData);
        ListView.setAdapter(adapter);
    }
    private void toastMessage(String messages) {
        Toast.makeText(this.messages, Toast.LENGTH_SHORT).show();
    }
    private void navigateToMenuFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.main2);
    }
    private void navigateToPageFragment2() {
        NavHostFragment.findNavController(this).navigate(R.id.main3);
    }
}










