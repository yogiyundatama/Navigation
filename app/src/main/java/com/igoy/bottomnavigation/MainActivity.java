package com.igoy.bottomnavigation;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(panggilBottomNavigation);
        loadFragment(new HomeFragment());
    }

    BottomNavigationView.OnNavigationItemSelectedListener panggilBottomNavigation
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigationhome:
                fragment = new HomeFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigationprofile:
                fragment = new ProfileFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigationsetting:
                fragment = new SettingFragment();
                loadFragment(fragment);
                return true;
        }
        return true;
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
