package com.kat2n.practice_android.lesson4.lab4.challenge;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private Toolbar toolbar;
  private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;
  private NavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    createToolbar();
    createFloatingActionButton();
    createDrawerLayout();
    createNavigationView();
  }

  @Override
  public void onBackPressed() {
    if (drawerLayout != null) {
      if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.closeDrawer(GravityCompat.START);
      } else {
        super.onBackPressed();
      }
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public void displayToast(String message) {
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }



  private void createToolbar() {
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void createFloatingActionButton() {
    floatingActionButton = findViewById(R.id.fab);
    if (floatingActionButton != null) {
      floatingActionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Snackbar
              .make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              .setAction("Action", null).show();
        }
      });
    }
  }

  private void createDrawerLayout() {
    drawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    if (drawerLayout != null) {
      drawerLayout.addDrawerListener(toggle);
    }
    toggle.syncState();
  }

  private void createNavigationView() {
    navigationView = findViewById(R.id.nav_view);
    if (navigationView != null) {
      navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
          // Handle navigation view item clicks here.
          switch (item.getItemId()) {
            case R.id.nav_camera:
              // Handle the camera import action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_camera));
              return true;
            case R.id.nav_gallery:
              // Handle the gallery action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_gallery));
              return true;
            case R.id.nav_slideshow:
              // Handle the slideshow action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_slideshow));
              return true;
            case R.id.nav_manage:
              // Handle the tools action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_tools));
              return true;
            case R.id.nav_share:
              // Handle the share action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_share));
              return true;
            case R.id.nav_send:
              // Handle the send action (for now display a toast).
              drawer.closeDrawer(GravityCompat.START);
              displayToast(getString(R.string.chose_send));
              return true;
            default:
              return false;
          }
        }
      });
    }
  }

}
