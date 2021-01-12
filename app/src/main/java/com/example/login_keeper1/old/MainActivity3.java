//package com.example.login_keeper1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity3 extends AppCompatActivity {
//
//    Button button;
//    TextView textView;
//    Random r;
//    String[] item = ["test1","test2","test3"];
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//
//        button = (Button)_findViewById(R.id.button);
//        textView = (TextView)_findViewById(R.id.textView);
//
//        r = new Random();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View V) {
//                textView.setText("" + item[r.nextInt(item.length)]);
//            }
//        });
//    }
//}