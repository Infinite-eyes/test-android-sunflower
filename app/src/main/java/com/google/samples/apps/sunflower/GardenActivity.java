package com.google.samples.apps.sunflower;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationViewKt;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.samples.apps.sunflower.databinding.ActivityGardenBinding;
/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/10/31 6:11 PM
 **/
public class GardenActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGardenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_garden);
        drawerLayout = binding.drawerLayout;

        NavController navController = Navigation.findNavController(this, R.id.garden_nav_fragment);
        setSupportActionBar(binding.toolbar);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationViewKt.setupWithNavController(binding.navigationView,navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawerLayout,Navigation.findNavController(this,R.id.garden_nav_fragment));
    }

    public void onBackPressed(){
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


}
