package com.example.loginscreen;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityHomePage extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final int POS_CLOSE=0;
    private static final int POS_HOME=1;
    private static final int POS_PROFILE=2;
    private static final int POS_COM_PLAN=3;
    private static final int POS_ALT_PLAN=4;
    private static final int POS_RECIPES=5;
    private static final int POS_BARCODE=6;
    private static final int POS_LOGOUT=7;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_CLOSE),
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_PROFILE),
                createItemFor(POS_COM_PLAN),
                createItemFor(POS_ALT_PLAN),
                createItemFor(POS_RECIPES),
                createItemFor(POS_BARCODE),
                new SpaceItem(220),
                createItemFor(POS_LOGOUT)

        ));

        adapter.setListeners(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_HOME);

    }

    private DrawerItem createItemFor(int position){
        return new SimpleItem(screenIcons[position],screenTitles[position]).
                WithIconTint(color(R.color.green))
                .WithTextTint(R.color.black)
                .WithSelectedIconTint(R.color.green)
                .WithSelectedTextTint(R.color.green);
    }

    @ColorInt
    private int color(@ColorRes int res){
        return ContextCompat.getColor(this, res);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i=0 ; i< ta.length() ; i++){
            int id = ta.getResourceId(i , 0);
            if(id != 0){
                icons[i] = ContextCompat.getDrawable(this,id);

            }
        }
        ta.recycle();
        return icons;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void OnItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if( position == POS_HOME){
            HomeFragment homeFragment = new HomeFragment();
            transaction.replace(R.id.container , homeFragment);
        }
        else if( position == POS_PROFILE){
            ProfileFragment profileFragment = new ProfileFragment();
            transaction.replace(R.id.container , profileFragment);
        }
        else if( position == POS_COM_PLAN){
            ComPlanFragment comPlanFragment = new ComPlanFragment();
            transaction.replace(R.id.container , comPlanFragment);
        }
        else if( position == POS_ALT_PLAN){
            AltPlanFragment altPlanFragment = new AltPlanFragment();
            transaction.replace(R.id.container , altPlanFragment);
        }
        else if( position == POS_RECIPES){
            RecipesFragment recipesFragment = new RecipesFragment();
            transaction.replace(R.id.container , recipesFragment);
        }
        else if( position == POS_BARCODE){
            BarcodeFragment barcodeFragment = new BarcodeFragment();
            transaction.replace(R.id.container , barcodeFragment);
        }
        else if (position == POS_LOGOUT){
            finish();
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }
}