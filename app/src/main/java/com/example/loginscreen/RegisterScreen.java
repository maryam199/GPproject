package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterScreen extends AppCompatActivity {
    private Button button;
    private Button buttont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        button = (Button) findViewById(R.id.rbutton);
        buttont = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheck();
            }
        });

        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });

    }

    public void openLogIn(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void openCheck(){
        Intent intent = new Intent(this, Check.class);
        startActivity(intent);

    }

}