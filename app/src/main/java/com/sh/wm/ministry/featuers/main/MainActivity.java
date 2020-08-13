package com.sh.wm.ministry.featuers.main;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.HomeFragment;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.main.adapter.FloatingMenuAdapter;
import com.sh.wm.ministry.featuers.main.modelMain.NavigationModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnHomeFragmentInteractionListener, OnFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout sideDrawer;
    private AppCompatImageButton sideButton;
    private CoordinatorLayout.LayoutParams params;
    public NavController navController;
    private static boolean isDrawerVisiable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sideDrawer = findViewById(R.id.side_drawer_layout);
        sideButton = findViewById(R.id.btn_side_menu);
        params = (CoordinatorLayout.LayoutParams) sideButton.getLayoutParams();

        setSupportActionBar(findViewById(R.id.toolbar));
        MaterialTextView toolbarTitle = findViewById(R.id.toolbar_title);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.major_services);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.main_nav_view);

        //set user name in navigation header
        View headerLayout = navigationView.getHeaderView(0);
        TextView usernametV = headerLayout.findViewById(R.id.tv_username_header);
        usernametV.setText(SharedPreferneceHelper.getUserName(this));
//
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_user_file, R.id.nav_signout, R.id.nav_major_services)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.nav_home) {
                toolbarTitle.setText(R.string.menu_home);
                closeDrawer();
                sideButton.setVisibility(View.GONE);
                sideDrawer.setVisibility(View.GONE);


            } else {
                toolbarTitle.setText(R.string.menu_user_file);
                sideButton.setVisibility(View.VISIBLE);
            }
        });

        String[] navItemTitle = getResources().getStringArray(R.array.nav_item_name);
        String[] navItemImage = getResources().getStringArray(R.array.nav_item_image);
        ArrayList<NavigationModel> list = new ArrayList<>();

        for (int i = 0; i < navItemTitle.length; i++) {
            NavigationModel models = new NavigationModel(navItemImage[i], navItemTitle[i]);
            list.add(models);
        }
        ListView listView = findViewById(R.id.lv_float_menu);
        FloatingMenuAdapter adapter = new FloatingMenuAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (i) {
                case 0:
                    navController.navigate(R.id.nav_major_services);
                    break;
                case 1:
                    navController.navigate(R.id.nav_address_contact);
                    break;
                case 2:
                    navController.navigate(R.id.nav_healh);
                    break;
                case 3:
                    navController.navigate(R.id.nav_dependents);
                    break;
                case 4:
                    navController.navigate(R.id.nav_educational_status);
                    break;
                case 5:
                    navController.navigate(R.id.nav_training_programs);
                    break;
                case 6:
                    navController.navigate(R.id.nav_work_experience);
                    break;
                case 7:
                    navController.navigate(R.id.nav_career);
                    break;
                case 8:
                    navController.navigate(R.id.nav_languages);
                    break;
                case 9:
                    navController.navigate(R.id.nav_practical_status);
                    break;
                case 10:
                    break;

            }
            closeDrawer();
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this
                , sideDrawer
                , null
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow_back);
                params.setMarginEnd((int) convertDpToPx());
                sideButton.setLayoutParams(params);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow);
                params.setMarginEnd(0);
                sideButton.setLayoutParams(params);
            }
        };
        sideDrawer.addDrawerListener(toggle);
        toggle.syncState();

        sideButton.setOnClickListener(view -> {
            if (!getSideDrawerVisibility()) {
                sideDrawer.openDrawer(GravityCompat.END);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow_back);
                params.setMarginEnd((int) convertDpToPx());
                sideButton.setLayoutParams(params);
                sideDrawer.setVisibility(View.VISIBLE);
                setSideDrawerVisiability(true);
            } else {
                closeDrawer();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private float convertDpToPx() {
        Resources r = getResources();
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                (float) 94,
                r.getDisplayMetrics()
        );
    }

    private void closeDrawer() {
        sideDrawer.closeDrawer(GravityCompat.END);
        sideButton.setImageResource(R.drawable.ic_baseline_arrow);
        params.setMarginEnd(0);
        sideButton.setLayoutParams(params);
        sideDrawer.setVisibility(View.GONE);
        setSideDrawerVisiability(false);
    }

    @Override
    public void onHomeFragmentInteraction(int cardPos) {
        switch (cardPos) {
            case 1:
                navController.navigate(R.id.nav_worker_complaint_form1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                navController.navigate(R.id.nav_visit_sevices);
                break;
        }
    }

    @Override
    public void onFragmentInteraction(int id) {
        switch (id) {
            case 11:
                navController.navigate(R.id.nav_major_services);
                break;
            case 21:
                navController.navigate(R.id.nav_worker_complaint_form2);
                break;
            case 41:
                navController.navigate(R.id.nav_add_dependents);
                break;
            case 51:
                navController.navigate(R.id.nav_add_education);
                break;
            case 71:
                navController.navigate(R.id.nav_add_work_experience);
                break;
            case 91:
                navController.navigate(R.id.nav_add_language);
                break;
            case 10:
                navController.navigate(R.id.nav_add_practical_status);
                break;
            case R.id.inspection_mng_card:
                navController.navigate(R.id.nav_inspection_mng);
                break;
            case  R.id.inspection_dec_btn :
                navController.navigate(R.id.nav_action_taking);
                break;
            case R.id.inspection_plane_mng_card:
                navController.navigate(R.id.nav_inspection_plane_management);
                break;
            case R.id.inspection_plane_prp_btn :
                //        navController.navigate(R.id.nav_inspection_mng);

                break;
            case R.id.inspection_visit_btn :
                navController.navigate(R.id.nav_visit_out_of_plane);
                break;
        }

    }

    @Override
    public void onFragmentInteraction(int id, Bundle bundle) {
        switch (id){
            case 72:
                navController.navigate(R.id.nav_add_work_experience,bundle);
                break;
            case 92:
                navController.navigate(R.id.nav_add_language,bundle);
                break;
            case 10:
                navController.navigate(R.id.nav_add_practical_status,bundle);
                break;
        }
    }

    @Override
    public void onHomeSlideNav(int id) {
        switch (id) {
            case 1:
                navController.navigate(R.id.nav_move_facility);
                break;
            case 2:
                navController.navigate(R.id.nav_new_work_place);
                break;
            case 3:
                navController.navigate(R.id.nav_leaving_work_place);
                break;
            case 4:
                navController.navigate(R.id.nav_alarm_form);
                break;
            case 5:
                navController.navigate(R.id.nav_legal_action);
                break;
            case 6:
                navController.navigate(R.id.nav_close_facility);
                break;
            case 7:
                navController.navigate(R.id.nav_adjustment_report);
                break;
        }
    }

    private void setSideDrawerVisiability(boolean isDrawerVisiable) {
        MainActivity.isDrawerVisiable = isDrawerVisiable;
    }

    private boolean getSideDrawerVisibility() {
        return isDrawerVisiable;
    }
}