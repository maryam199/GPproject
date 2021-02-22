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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientOption extends AppCompatActivity {

   RadioButton radioLose, radioGain ;
    private EditText age, weight, height, loseorgain;
    private Button button;
   DatabaseReference databaseR;
   FirebaseDatabase firebaseD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_option);


       age = findViewById(R.id.editTextTextPassword2);
      weight = findViewById(R.id.editTextTextPassword3);
      height = findViewById(R.id.editTextTextPassword4);
        loseorgain = findViewById(R.id.editTextTextPassword5);
        radioLose = (RadioButton) findViewById(R.id.radioButton2);
        radioGain = (RadioButton) findViewById(R.id.FradioButton1);

        button = findViewById(R.id.button7);

       firebaseD = FirebaseDatabase.getInstance();
      databaseR = firebaseD.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("information");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Age = age.getText().toString().trim();
                String Weight = weight.getText().toString().trim();
                String Height = height.getText().toString().trim();
                String Loseorgain = loseorgain.getText().toString().trim();
                String losRgain;

                if (Age.equals("")) {
                    age.setError("الرجاء إدخال عمرك!");
                    age.requestFocus();
                    return;
                }

                if (Integer.parseInt(Age)<18) {
                    age.setError("عفوا البرنامج مخصص لعمر 18 فما فوق!");
                    age.requestFocus();
                    return;
                }

                if (Weight.equals("")) {
                    weight.setError("الرجاء إدخال وزنك!");
                    weight.requestFocus();
                    return;
                }

                if (Height.equals("")) {
                    height.setError("الرجاء إدخال طولك!");
                    height.requestFocus();
                    return;
                }

                if(radioLose.isChecked()){
                    losRgain = "انقاص الوزن";
                    Toast.makeText(ClientOption.this, "", Toast.LENGTH_SHORT).show();
                }else if(radioGain.isChecked()){
                    losRgain = "زيادة الوزن";
                    Toast.makeText(ClientOption.this, "", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ClientOption.this, "الرجاء اختيار هدفك", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Loseorgain.equals("")) {
                    loseorgain.setError("الرجاء إدخال الوزن الذي تريد انقاصه/زيادته !");
                    loseorgain.requestFocus();
                    return;
                }

                Client client = new Client(Age,Weight,Height,losRgain,Loseorgain);
                databaseR.setValue(client);
                openClientQuiz();
            }
        });


    }

    public void openClientQuiz(){
        Intent intent = new Intent(this, ClientQuiz.class);
        startActivity(intent);
    }


}
