package com.apkglobal.firebaselogin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password;
    Button login, create;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();// to pass the instance function to firebase auth object
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        create=findViewById(R.id.create);
        // to hide the create button
        create.setVisibility(View.GONE);
        // to change the login button name to register

        login.setText("Register");
        // to click on login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to validate email and password is not null
                if (email.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Email and password can't be empty", Toast.LENGTH_SHORT).show();
                }
               if (password.getText().toString().length()<7){
                   Toast.makeText(RegisterActivity.this, "password length should be more than 7", Toast.LENGTH_SHORT).show();
               }



                else {
                    auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // if registeration is successful
                            if(task.isSuccessful()){
                                // to show response message to user
                                Toast.makeText(RegisterActivity.this, "Registeration successful", Toast.LENGTH_SHORT).show();
                                 // to clear form
                                email.setText("");
                                password.setText("");
                                // to return to login activity
                                finish();
                            }

                        }
                    });

                }
            }
        });
    }
}
