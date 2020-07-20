package com.sh.wm.ministry.featuers;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.main.MainActivity;
import com.sh.wm.ministry.featuers.sso.SsoLoginActivity;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isTaskRoot()
                && getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
                && getIntent().getAction() != null && getIntent().getAction().equals(Intent.ACTION_MAIN)) {
            finish();
            return;
        }

            if (SharedPreferneceHelper.isLoggedIn(this)) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            } else {
                startActivity(new Intent(SplashActivity.this, SsoLoginActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

    }

}