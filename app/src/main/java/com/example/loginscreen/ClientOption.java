package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientOption extends AppCompatActivity {
    Dialog myDialog;
    Dialog secondDialog;
    private EditText age, weight, height, lose, gain;
    private ImageView img;
    private Button button, button2;
     DatabaseReference databaseR;
     FirebaseDatabase firebaseD;
    String losRgain = "";
    String Num = "";

    String Age, Weight, Height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_option);
        myDialog = new Dialog(this);
        secondDialog = new Dialog(this);

        img = findViewById(R.id.imageView34);
        //age = findViewById(R.id.editTextTextMultiLine2);
        weight = findViewById(R.id.editTextTextMultiLine);
        height = findViewById(R.id.editTextTextMultiLine3);
        lose = findViewById(R.id.editTextTextPersonName);
        gain = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button10);
        button2 = findViewById(R.id.button7);
        firebaseD = FirebaseDatabase.getInstance();
        databaseR = firebaseD.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("information");


        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Age = age.getText().toString().trim();
                if (Age.equals("")) {
                    age.setError("الرجاء إدخال عمرك!");
                    age.requestFocus();
                    return;
                }
            }
        });


         weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weight = weight.getText().toString().trim();
               if (Weight.equals("")) {
                    weight.setError("الرجاء إدخال وزنك!");
                    weight.requestFocus();
                    return;
                }

            }
        });

        height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Height = height.getText().toString().trim();
               if (Height.equals("")) {
                    height.setError("الرجاء إدخال طولك!");
                    height.requestFocus();
                    return;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losRgain = "انقاص الوزن";
                Num = lose.getText().toString().trim();
                Client info = new Client(Age,Weight,Height,losRgain,Num);

                databaseR.setValue(info);

                openClientQuiz();
            }
        });

       button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losRgain = "زيادة الوزن";
                Num = gain.getText().toString().trim();
                Client info = new Client(Age,Weight,Height,losRgain,Num);

                databaseR.setValue(info);

                openClientQuiz();
            }
        });



    }

    public void openClientQuiz(){
        Intent intent = new Intent(this, ClientQuiz.class);
        startActivity(intent);
    }


    public void ShowPopup(View v){

        myDialog.setContentView(R.layout.popup);
        myDialog.show();
    }

    public void ShowSecondPopup(View v){
        secondDialog.setContentView(R.layout.pop);
        secondDialog.show();
    }


}
