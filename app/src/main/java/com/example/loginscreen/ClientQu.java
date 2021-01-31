package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ClientQu extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_qu);
        image = (ImageView) findViewById(R.id.imageView9);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ();
            }
        });
    }

    public void openQ(){
        Intent intent = new Intent(this, ClientQ.class);
        startActivity(intent);

    }
}