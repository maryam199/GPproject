package com.example.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button button, login;
    private EditText userEmail, passWord;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonregester);
        userEmail = findViewById(R.id.editTextTextPersonName2);
        passWord = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                // authenticate the user

                mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if(user.isEmailVerified()){
                                Toast.makeText(MainActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), ActivityHomePage.class));
                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this,"تحقق من بريدك الإلكتروني لتفعيل حسابك!", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(MainActivity.this,"خطأ"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }



    public void openRegister(){
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);

    }

}