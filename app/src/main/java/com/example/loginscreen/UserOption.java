package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserOption extends AppCompatActivity {
    private Button dietician, client;
    private DatabaseReference databaseR;
    private FirebaseDatabase firebaseD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_option);
        dietician = (Button) findViewById(R.id.button6);
        client = (Button) findViewById(R.id.button5);
        firebaseD = FirebaseDatabase.getInstance();
        databaseR = firebaseD.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("type");

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "مستخدم";
                databaseR.setValue(data);
                openClientOption();
            }
        });

        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dat = "أخصائي تغذية";
                databaseR.setValue(dat);
                openDieticianOption();
            }
        });


    }

    public void openClientOption(){
        Intent intent = new Intent(this, ClientOption.class);
        startActivity(intent);
    }

    public void openDieticianOption(){
        Intent intent = new Intent(this, DieticianOption.class);
        startActivity(intent);
    }
}