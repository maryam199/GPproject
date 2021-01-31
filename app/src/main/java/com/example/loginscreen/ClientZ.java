package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ClientZ extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_z);
        image = (ImageView) findViewById(R.id.imageView18);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompletion();
            }
        });
    }

    public void openCompletion(){
        Intent intent = new Intent(this, QuizCompletion.class);
        startActivity(intent);

    }
}