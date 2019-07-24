package com.logixcess.republiccargo.customer.activities;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.customer.fragments.AgentLocationFragment;
import com.logixcess.republiccargo.customer.fragments.NotificationsFragment;
import com.logixcess.republiccargo.customer.fragments.OrdersFragment;
import com.logixcess.republiccargo.customer.fragments.RequestsFragment;
import com.logixcess.republiccargo.customer.fragments.ReservationFragment;
import com.logixcess.republiccargo.customer.fragments.ReserveByAirFragment;
import com.logixcess.republiccargo.customer.fragments.ReserveByOceanFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AgentLocationFragment.OnFragmentInteractionListener, NotificationsFragment.OnFragmentInteractionListener, OrdersFragment.OnFragmentInteractionListener, RequestsFragment.OnFragmentInteractionListener, ReservationFragment.OnFragmentInteractionListener, ReserveByOceanFragment.OnFragmentInteractionListener, ReserveByAirFragment.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        loadFragment(new ReservationFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_home) {
            // Handle the booking section
            fragment = new ReservationFragment();
        }
        else if (id == R.id.nav_booking)
        {
            fragment =  new OrdersFragment();
        }
        else if (id == R.id.nav_tracking)
        {
            fragment = new RequestsFragment();
        }
        else if (id == R.id.nav_notifications)
        {
            fragment =  new ReservationFragment();
        }
        else if (id == R.id.nav_logout)
        {
            fragment = new AgentLocationFragment();
        }
        else if (id == R.id.nav_share)
        {
        }
//        else if (id == R.id.nav_send)
//        {
//        }
        loadFragment(fragment);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
