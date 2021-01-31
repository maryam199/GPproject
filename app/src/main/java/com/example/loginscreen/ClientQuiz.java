package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ClientQuiz extends AppCompatActivity {
private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_quiz);
        image = (ImageView) findViewById(R.id.imageView15);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQui();
            }
        });
    }

    public void openQui(){
        Intent intent = new Intent(this, ClintQui.class);
        startActivity(intent);

    }

}