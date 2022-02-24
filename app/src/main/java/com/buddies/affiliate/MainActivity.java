package com.buddies.affiliate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.buddies.affiliate.Fragments.HomeFragment;
import com.buddies.affiliate.Fragments.ProfileFragment;
import com.buddies.affiliate.Fragments.StoreFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.nav_menu);

        chipNavigationBar.setItemSelected(R.id.nav_home,true);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        bottommenu();
    }

    private void bottommenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_notification:
                        fragment = new StoreFragment();
                        break;
                    case R.id.nav_cart:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });

    }
}