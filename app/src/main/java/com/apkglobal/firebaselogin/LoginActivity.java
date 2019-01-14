package com.apkglobal.firebaselogin;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button login,create;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        create=findViewById(R.id.create);

        // to click on create button to jump to register activity
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")||password.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                                        // clear the form
                                        email.setText("");
                                        password.setText("");
                                        startActivity( new Intent(LoginActivity.this,HelloActivity.class));
                                       // String str = email.getText().toString();

                                       // Intent intent = new Intent(getApplicationContext(), HelloActivity.class);
                                        //intent.putExtra("message", str);

                                        //startActivity(intent);


                                    }
                                    else {
                                        Toast.makeText(LoginActivity.this, "credential incorrect", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                }
            }
        });


    }
}
