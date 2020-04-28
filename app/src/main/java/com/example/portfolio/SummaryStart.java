package com.example.portfolio;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

public class SummaryStart extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    MyPagerFragment myPagerFragment;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment_Detail_Movie1 fragment_detail_movie1;
    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 상세보기 화면 클릭후 item메뉴가 되지않는 오류 고치기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawer_test);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        myPagerFragment = new MyPagerFragment();
        fragment_detail_movie1 = new Fragment_Detail_Movie1();


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_1, R.id.nav_2, R.id.nav_3,R.id.nav_setting)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                Fragment fragment = null;
                if(id==R.id.nav_1){
                    fragment = myPagerFragment;
                }else if(id==R.id.nav_2){
                    fragment = fragment2;
                }else if(id == R.id.nav_3) {
                    fragment = fragment3;
                }else if(id == R.id.nav_setting){
                    fragment = fragment1;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    public void onFragmentChange(int index) {
        if(index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_detail_movie1).commit();
        }
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
