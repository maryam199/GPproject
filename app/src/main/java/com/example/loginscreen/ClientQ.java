package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ClientQ extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_q);
        image = (ImageView) findViewById(R.id.imageView23);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openZ();
            }
        });
    }

    public void openZ(){
        Intent intent = new Intent(this, ClientZ.class);
        startActivity(intent);

    }
}