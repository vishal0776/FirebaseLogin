package com.apkglobal.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    EditText email;



TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
      //  email=findViewById(R.id.email);
        //content=findViewById(R.id.hello);
       // Intent intent = getIntent();
     //   String str=email.getText().toString();


//       String str = intent.getStringExtra("message");
        //content.setText(str);
  //      content.setText("Hello" + str);




    }
}
