package com.example.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DieticianPS extends AppCompatActivity {

    private TextView  userNameD;
    private TextView  EmailD;
    private TextView  passwordD;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietician_ps);

        Toolbar toolbar = findViewById(R.id.toolbar);//حذفت مابين القوسين
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);


        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(DieticianPS.this, MainActivity.class));//MainActivity
                    finish();
                }
            }
        };
        // اسم المستحدم، الايميل، كلمة المرور
        userNameD = findViewById(R.id.textView22);
        //  EmailD = (TextView) findViewById(R.id.textView23);
        EmailD = findViewById(R.id.textView23);
        passwordD = findViewById(R.id.textView21);

        userNameD.setVisibility(View.GONE);
        EmailD.setVisibility(View.GONE);
        passwordD.setVisibility(View.GONE);


        /*progressBar = findViewById(R.id.progressBar);

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }*/
    }
/*

    public void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }*/

    //sign out method
    /*
    public void signOut() {
        auth.signOut();
    }*/

    /* @Override
     protected void onResume() {
         super.onResume();
         progressBar.setVisibility(View.GONE);
     }
 */

    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}//end class