package com.cescristorey.caculadorapracticadesdecero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.cescristorey.caculadorapracticadesdecero.fragments.fragment_calculadora;
import com.cescristorey.caculadorapracticadesdecero.fragments.fragment_chat;
import com.cescristorey.caculadorapracticadesdecero.fragments.fragment_cientifica;
import com.cescristorey.caculadorapracticadesdecero.fragments.fragment_send;
import com.cescristorey.caculadorapracticadesdecero.fragments.fragment_share;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                    new fragment_calculadora()).commit();
            navigationView.setCheckedItem(R.id.nav_caculadora);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_caculadora:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                        new fragment_calculadora()).commit();
                break;

            case R.id.nav_calculadoraCientifica:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                        new fragment_cientifica()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                        new fragment_chat()).commit();
                break;
            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                        new fragment_share()).commit();
                break;
            case R.id.nav_send:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container,
                        new fragment_send()).commit();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}
