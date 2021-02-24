package com.example.loginscreen;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DieticianPS extends AppCompatActivity {

    private TextView  userNameD;
    private TextView  EmailD;
    private TextView  passwordD;
    Button bt;

   DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietician_ps);

        userNameD = (TextView)findViewById(R.id.textView37);
        EmailD = (TextView)findViewById(R.id.textView38);
        passwordD = (TextView)findViewById(R.id.textView41);
        bt = (Button) findViewById(R.id.button10);

       // Toolbar toolbar = findViewById(R.id.toolbar);//حذفت مابين القوسين
      //  toolbar.setTitle(getString(R.string.app_name));
       // setSupportActionBar(toolbar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name = snapshot.child("name").getValue().toString();
                        String email = snapshot.child("email").getValue().toString();
                        String password = snapshot.child("password").getValue().toString();

                        userNameD.setText(name);
                        EmailD.setText(email);
                        passwordD.setText(password);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

   }

}//end class