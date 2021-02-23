package com.example.loginscreen;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityHomePage extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_home_page);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_home ){
                    Toast.makeText(ActivityHomePage.this, "الرئسية" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  ActivityHomePage.class));
                }
                else if(item.getItemId() == R.id.nav_Profile ){
                    Toast.makeText(ActivityHomePage.this, "الحساب الشخصي" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  ProfileScreen.class));
                }
                else if(item.getItemId() == R.id.nav_ComDietPlan ){
                    Toast.makeText(ActivityHomePage.this, "الخطة الكاملة" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  CompleteDietPlanScreen.class));
                }
                else if(item.getItemId() == R.id.nav_AltDietPlan ){
                    Toast.makeText(ActivityHomePage.this, "الخطة البديلة" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  AlternativeDietPlanScreens.class));
                }
                else if(item.getItemId() == R.id.nav_Recipes ){
                    Toast.makeText(ActivityHomePage.this, "وصفات صحية" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  DisplyRecipScerrn.class));
                }
                else if(item.getItemId() == R.id.nav_ScanBarCode ){
                    Toast.makeText(ActivityHomePage.this, "مسح الباركود" , Toast.LENGTH_SHORT);
                    startActivity(new Intent(ActivityHomePage.this,  ScanBarCodeScreen.class));
                }
                else if(item.getItemId() == R.id.nav_logOut ){
                    Toast.makeText(ActivityHomePage.this, "تسجيل الخروج" , Toast.LENGTH_SHORT);
                    mAuth.signOut();
                    finish();
                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
/*
كل هالكود الي تحت تبع المنيو القديمة الي تحتاج كلاسات من نوع fragment وليس من نوع AppCompat


        sNavigationDrawer = findViewById(R.id.navigationDrawer);

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("الرئيسية", R.drawable.home2));
        menuItems.add(new MenuItem("الحساب", R.drawable.profile));
        menuItems.add(new MenuItem("الخطة الكاملة", R.drawable.complan));
        menuItems.add(new MenuItem("الخطة البديلة", R.drawable.altplan));
        menuItems.add(new MenuItem("وصفات صحية", R.drawable.recipes));
        menuItems.add(new MenuItem("مسح الباركود", R.drawable.scan));
        menuItems.add(new MenuItem("تسجيل الخروج", R.drawable.logout));

        sNavigationDrawer.setMenuItemList(menuItems);

        fragmentClass = HomeFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        if(fragment!=null){
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();
        }


        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        fragmentClass = HomeFragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = ProfileFragment.class;
                        break;
                    }
                    case 2:{
                        fragmentClass = ComPlanFragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = AlternativeDietPlanScreens.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = RecipesFragment.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = BarcodeFragment.class;
                        break;
                    }
                    case 6:{
                        finish();
                    }

                }



        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                if(fragment!=null){
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();
                }

            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                System.out.println("State "+newState);
            }
        });

    }
});*/
    }
}