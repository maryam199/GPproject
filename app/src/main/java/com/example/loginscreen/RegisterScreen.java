package com.example.loginscreen;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.regex.Pattern;

import static com.example.loginscreen.ScanBarCodeScreen.text;

public class RegisterScreen extends AppCompatActivity {
    private Button buttont, regUser;
    private EditText userName, passWord, userEmail;
    RadioButton radioGenderMale, radioGenderFemale ;
    String gender = "";
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        regUser = (Button) findViewById(R.id.rbutton);
        buttont = (Button) findViewById(R.id.button2);
        userName = (EditText) findViewById(R.id.editTextTextPersonName2);
        passWord = (EditText) findViewById(R.id.editTextTextPassword);
        userEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);

        radioGenderMale = (RadioButton) findViewById(R.id.FradioButton1);
        radioGenderFemale = (RadioButton) findViewById(R.id.radioButton2);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");


       // if (mAuth.getCurrentUser() != null) {
          //  startActivity(new Intent(getApplicationContext(), HomeFragment.class));
         //   finish();
      //  }

        regUser.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = userName.getText().toString().trim();
                String password = passWord.getText().toString().trim();
                String Email = userEmail.getText().toString().trim();

                if(radioGenderMale.isChecked()){
                    gender = "ذكر";
                    Toast.makeText(RegisterScreen.this, "", Toast.LENGTH_SHORT).show();
                }else if(radioGenderFemale.isChecked()){
                    gender = "انثى";
                    Toast.makeText(RegisterScreen.this, "", Toast.LENGTH_SHORT).show();
                }


                if (password.equals("")) {
                    passWord.setError("كلمة المرور مطلوبه!");
                    passWord.requestFocus();
                    return;
                }

                if (name.equals("")) {
                    userName.setError("اسم المستخدم مطلوب!");
                    userName.requestFocus();
                    return;
                }

                if (Email.equals("")) {
                    userEmail.setError("البريد الإلكتروني مطلوب!");
                    userEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    userEmail.setError("الرجاء إخال بريد إلكتروني صحيح!");
                    userEmail.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    passWord.setError("يجب ان لا تقل كلمة المرور عن 6 رموز!");
                    passWord.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(RegisterScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User information = new User(name,gender,password,Email);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(RegisterScreen.this, "تم إنشاء مستخدم بنجاح", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), UserOption.class));
                                }
                            });

                        }else {
                            Toast.makeText(RegisterScreen.this,"خطأ"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });
        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAC();
            }
        });
    }

public void openAC(){
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
}

}