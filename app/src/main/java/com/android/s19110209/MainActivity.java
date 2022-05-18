package com.android.s19110209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.s19110209.Fragments.CardFragment;
import com.android.s19110209.Fragments.HomeFragment;
import com.android.s19110209.Fragments.InternalFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout =findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open_Drawer,R.string.Close_Drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                HomeFragment homeFragment =new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,homeFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_internal:
                InternalFragment internalFragment=new InternalFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,internalFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_card:
                CardFragment cardFragment=new CardFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,cardFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_about:
                Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStackImmediate();
        try {
            String fragmentName = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
            Toast.makeText(getApplicationContext(), fragmentName, Toast.LENGTH_SHORT).show(); // Debug to see if the correct name is being shown
        } catch (NullPointerException npe) {
            // Print to console
            // It always catches an error here and I don't know why
        }
    }
}