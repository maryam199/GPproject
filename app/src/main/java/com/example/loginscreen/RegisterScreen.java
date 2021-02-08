package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class RegisterScreen extends AppCompatActivity {
    private Button buttont, regUser;
    private EditText userName, passWord, userEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        regUser = (Button) findViewById(R.id.rbutton);
        buttont = (Button) findViewById(R.id.button2);
        userName = (EditText) findViewById(R.id.editTextTextPersonName2);
        passWord = (EditText) findViewById(R.id.editTextTextPassword);
        userEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        mAuth = FirebaseAuth.getInstance();

        //if (mAuth.getCurrentUser() != null) {
          //  startActivity(new Intent(getApplicationContext(), HomeFragment.class));
          //  finish();
        //}

        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().trim();
                String password = passWord.getText().toString().trim();
                String Email = userEmail.getText().toString().trim();

                if (password.equals("")) {
                    passWord.setError("كلمة المرور مطلوبه!");
                    passWord.requestFocus();
                    return;
                }


                if (Email.equals("")) {
                    userEmail.setError("البريد الإلكتروني مطلوب!");
                    userEmail.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    passWord.setError("يجب ان لا تقل كلمة المرور عن 6 رموز!");
                    passWord.requestFocus();
                    return;
                }

                if (name.equals("")) {
                    userName.setError("اسم المستخدم مطلوب!");
                    userName.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    userEmail.setError("الرجاء إخال بريد إلكتروني صحيح!");
                    userEmail.requestFocus();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterScreen.this, "تم إنشاء مستخدم بنجاح", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Check.class));
                        }else {
                            Toast.makeText(RegisterScreen.this,"خطأ"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });

    }

    public void openLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}