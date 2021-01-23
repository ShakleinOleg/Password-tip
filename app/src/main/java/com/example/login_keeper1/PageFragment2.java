package com.example.login_keeper1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PageFragment2 extends Fragment {

        private static final String TAG = "MainActivity";

        DatabaseHelper DatabaseHelper;
        private EditText Title, Website, Username, Password;
        private Button mRegisterButton, MainButton;

    @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.activity_page_fragment2, container, false);

            Title = view.findViewById(R.id.Title);
            Website = view.findViewById(R.id.Website);
            Username = view.findViewById(R.id.Username);
            Password = view.findViewById(R.id.Password);
            MainButton = view.findViewById(R.id.MainButton);
            mRegisterButton = view.findViewById(R.id.register);

            mRegisterButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToMainPageFragment();
                }
            });

            MainButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newEntry1 = Title.getText().toString();
                    String newEntry2 = Website.getText().toString();
                    String newEntry3 = Username.getText().toString();
                    String newEntry4 = Password.getText().toString();
                    if (Password.length() != 0){
                        AddData(newEntry1, newEntry2, newEntry3, newEntry4);
                        Password.setText("");
                    } else {
                        toastMessage("Something went wrong");
                    }
                }
            });

            MainButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newEntry1 = Title.getText().toString();
                    String newEntry2 = Website.getText().toString();
                    String newEntry3 = Username.getText().toString();
                    String newEntry4 = Password.getText().toString();
                    if (Password.length() != 0){
                        AddData(newEntry1, newEntry2, newEntry3, newEntry4);
                        Password.setText("");
                    } else {
                        toastMessage("Something went wrong");
                    }
                }
            });
            return view;
        }

        private void AddData(String newEntry1, String newEntry2, String newEntry3, String newEntry4) {
           boolean insertData1 = DatabaseHelper.addData(newEntry1);
           boolean insertData2 = DatabaseHelper.addData(newEntry2);
           boolean insertData3 = DatabaseHelper.addData(newEntry3);
           boolean insertData4 = DatabaseHelper.addData(newEntry4);

           if(insertData1){
               toastMessage("Data succsessfully Inserted!");
           } else {
               toastMessage("Something went wrong");
           }
            if(insertData2){
                toastMessage("Data succsessfully Inserted!");
            } else {
                toastMessage("Something went wrong");
            }
            if(insertData3){
                toastMessage("Data succsessfully Inserted!");
            } else {
                toastMessage("Something went wrong");
            }
            if(insertData4){
                toastMessage("Data succsessfully Inserted!");
            } else {
                toastMessage("Something went wrong");
            }

        }

        private void toastMessage(String messages) {
            Toast.makeText(this.messages, Toast.LENGTH_SHORT).show();
        }

        private void navigateToMainPageFragment() {
            NavHostFragment.findNavController(this).navigate(R.id.main7);
        }

    }




















