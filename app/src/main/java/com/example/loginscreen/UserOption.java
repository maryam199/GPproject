package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserOption extends AppCompatActivity {
    private Button button;
    private Button user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_option);
        button = (Button) findViewById(R.id.button6);
        user = (Button) findViewById(R.id.button5);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDieticianOption();
            }
        });
    }

    public void openDieticianOption(){
        Intent intent = new Intent(this, DieticianOption.class);
        startActivity(intent);

    }

    public void openInfo(){
        Intent intent2 = new Intent(this, ClientOption.class);
        startActivity(intent2);

    }
}