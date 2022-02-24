package com.buddies.affiliate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.buddies.affiliate.Fragments.HomeFragment;
import com.buddies.affiliate.Fragments.ProfileFragment;
import com.buddies.affiliate.Fragments.StoreFragment;
import com.buddies.affiliate.Fragments.WebFragment;
import com.buddies.affiliate.Fragments.amaFragment;
import com.buddies.affiliate.Fragments.flipFragment;
import com.buddies.affiliate.Fragments.justFragment;
import com.buddies.affiliate.Fragments.myaFragment;
import com.buddies.affiliate.Fragments.olaFragment;
import com.buddies.affiliate.Fragments.oyoFragment;
import com.buddies.affiliate.Fragments.panFragment;
import com.buddies.affiliate.Fragments.snapFragment;
import com.buddies.affiliate.Fragments.swFragment;
import com.buddies.affiliate.Fragments.triFragment;
import com.buddies.affiliate.Fragments.uberFragment;
import com.buddies.affiliate.Fragments.ytrsFragment;
import com.buddies.affiliate.Fragments.zomFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class FourCompareActivity extends AppCompatActivity {

    ChipNavigationBar nav_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_compare);

        nav_menu = findViewById(R.id.nav_menu);



        Intent intent = getIntent();
        String value = intent.getStringExtra("cat");

        switch (value){
            case "cab":
                loadCad();
                break;
                case "foods":
                loadfoods();
                break;
                case "hol":
                loadhol();
                break;
                case "shopping":
                loadshopping();
                break;

        }

    }

    private void loadCad() {

        nav_menu.setMenuResource(R.menu.cab);

        nav_menu.setItemSelected(R.id.ola,true);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new olaFragment()).commit();

        nav_menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.ola:
                        fragment = new olaFragment();
                        break;
                    case R.id.uber:
                        fragment = new uberFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });



    }


    private void loadfoods() {

        nav_menu.setMenuResource(R.menu.food);
        nav_menu.setItemSelected(R.id.swiggy,true);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new swFragment()).commit();

        nav_menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.swiggy:
                        fragment = new swFragment();
                        break;
                    case R.id.zomato:
                        fragment = new zomFragment();
                        break;
                        case R.id.panda:
                        fragment = new panFragment();
                        break;
                        case R.id.just:
                        fragment = new justFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });



    }


    private void loadhol() {

        nav_menu.setMenuResource(R.menu.hot);
        nav_menu.setItemSelected(R.id.oyo,true);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new oyoFragment()).commit();

        nav_menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.oyo:
                        fragment = new oyoFragment();
                        break;
                    case R.id.tri:
                        fragment = new triFragment();
                        break;
                        case R.id.yatra:
                        fragment = new ytrsFragment();
                        break;
                        case R.id.trip:
                        fragment = new WebFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });



    }



    private void loadshopping() {

        nav_menu.setMenuResource(R.menu.shop);
        nav_menu.setItemSelected(R.id.filp,true);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new flipFragment()).commit();

        nav_menu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.filp:
                        fragment = new flipFragment();
                        break;
                    case R.id.ama:
                        fragment = new uberFragment();
                        break;
                        case R.id.mintra:
                        fragment = new myaFragment();
                        break;
                        case R.id.snap:
                        fragment = new snapFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });



    }
}