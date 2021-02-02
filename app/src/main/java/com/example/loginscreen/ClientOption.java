package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClientOption extends AppCompatActivity {
    Dialog myDialog;
    Dialog secondDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_option);
        myDialog = new Dialog(this);
        secondDialog = new Dialog(this);
    }

    public void ShowPopup(View v){

        myDialog.setContentView(R.layout.popup);
        myDialog.show();
    }

    public void ShowSecondPopup(View v){
        secondDialog.setContentView(R.layout.pop);
        secondDialog.show();
    }

}