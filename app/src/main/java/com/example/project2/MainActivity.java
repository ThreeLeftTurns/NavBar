package com.example.project2;

import android.os.Bundle;

import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //Handles navigation graph for AppBar
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate the layout for this activity
        //Binding for this activity's layout
        com.example.project2.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Set the toolbar as the app bar for the activity
        setSupportActionBar(binding.appBarMain.toolbar);

        //DrawerLayout for the navigation drawer
        DrawerLayout drawer = binding.drawerLayout;
        // NavigationView for the navigation drawer's view
        NavigationView navigationView = binding.navView;

        //Setup AppBarConfiguration with top level destinations
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        //Sets up the NavController, ActionBar, and Navigation
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        //Handle back navigation with NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //Navigate up in the app's navigation layout
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}