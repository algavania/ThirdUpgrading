package com.upgrading.thirdupgrading.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.upgrading.thirdupgrading.R;
import com.upgrading.thirdupgrading.fragment.FirstFragment;
import com.upgrading.thirdupgrading.fragment.SecondFragment;
import com.upgrading.thirdupgrading.fragment.ThirdFragment;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_beranda);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_beranda:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
                break;
            case R.id.nav_kelola:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
                break;
            case R.id.nav_transaksi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThirdFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }
}