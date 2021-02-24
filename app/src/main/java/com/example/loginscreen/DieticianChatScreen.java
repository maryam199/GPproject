package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DieticianChatScreen extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_home_page_dietitian);

        mAuth = FirebaseAuth.getInstance();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_home ){
                    Toast.makeText(DieticianChatScreen.this, "الرئسية" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(DieticianChatScreen.this,  DieticianChatScreen.class));
                }
                else if(item.getItemId() == R.id.nav_Profile ){
                    Toast.makeText(DieticianChatScreen.this, "الحساب الشخصي" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(DieticianChatScreen.this,  activity_profile_dietitian.class));
                }
                else if(item.getItemId() == R.id.nav_logOut ){
                    Toast.makeText(DieticianChatScreen.this, "تسجيل الخروج" , Toast.LENGTH_SHORT);
                    mAuth.signOut();
                    finish();
                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }
}