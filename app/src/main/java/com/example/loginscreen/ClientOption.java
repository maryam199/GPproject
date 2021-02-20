package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class ClientOption extends AppCompatActivity implements View.OnClickListener {
    Dialog myDialog;
    Dialog secondDialog;
    private EditText age, weight, height, lose, gain;
    private ImageView img;
    private Button button, button2;

    DatabaseReference databaseR;
    FirebaseDatabase firebaseD;//root

    String losRgain = "";
    String Num = "";

    String Age, Weight, Height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_option);

        img = findViewById(R.id.imageView34);
        age = findViewById(R.id.editTextTextMultiLine2);
        weight = findViewById(R.id.editTextTextMultiLine);
        height = findViewById(R.id.editTextTextMultiLine3);
        lose = findViewById(R.id.editTextTextPersonName);
        gain = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button10);//loose
        button2 = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseD = FirebaseDatabase.getInstance();
                databaseR = firebaseD.getReference("information");

                //get all the values:age wiegt hight

                String Age = age.getText().toString();
                String Weight = weight.getText().toString();
                String Height = height.getText().toString();


                Client client = new Client(Age, Weight, Height);

                //.child unique value
                databaseR.child(String.valueOf(age)).setValue(client);
            }
        });

        button.setOnClickListener(this);

    }//end onCreate

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(ClientOption.this, ClientOptionWeightLoss.class);
        startActivity(intent);
    }
}