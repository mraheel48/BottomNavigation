package com.example.bottomnavigation.Ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigation.Fragment.FavoriteFragment;
import com.example.bottomnavigation.Fragment.HomeFragment;
import com.example.bottomnavigation.Fragment.SearchFragment;
import com.example.bottomnavigation.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    FavoriteFragment favoriteFragment = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);

        navigationView.setOnNavigationItemSelectedListener(listener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_home:
                            selectFragment = homeFragment;
                            break;
                        case R.id.menu_favorites:
                            selectFragment = favoriteFragment;
                            break;
                        case R.id.menu_search:
                            selectFragment = searchFragment;
                            break;
                    }

                    assert selectFragment != null;
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectFragment).commit();

                    return true;
                }
            };
}
