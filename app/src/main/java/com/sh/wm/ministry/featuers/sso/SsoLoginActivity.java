package com.sh.wm.ministry.featuers.sso;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.databinding.ActivitySsoLoginBinding;
import com.sh.wm.ministry.featuers.main.MainActivity;
import com.sh.wm.ministry.featuers.sso.viewModel.SsoLoginViewModel;
import com.sh.wm.ministry.network.utiels.ApiConstent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SsoLoginActivity extends AppCompatActivity {

    private static final String TAG = SsoLoginActivity.class.getName();
    private static final String CLIENT_ID = "LMIS_MOL";
    private static final String CLIENT_SECRET = "_c11cb12140192965b0b40b91f1937a086dcf8c6ddb";
    private final String SSO_LOGIN_URL = "https://ssoidp.gov.ps/sso/module.php/sspoauth2/mobile_authorize.php?client_id=LMIS_MOL";

    private SsoLoginViewModel ssoLoginViewModel;
    private ActivitySsoLoginBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySsoLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.wvSsoLogin.getSettings().setJavaScriptEnabled(true);
        binding.wvSsoLogin.getSettings().setUseWideViewPort(true);
        binding.wvSsoLogin.getSettings().setBuiltInZoomControls(true);
        binding.wvSsoLogin.getSettings().setLoadWithOverviewMode(true);
        binding.wvSsoLogin.loadUrl(SSO_LOGIN_URL);


        ssoLoginViewModel = new ViewModelProvider(this).get(SsoLoginViewModel.class);

        binding.wvSsoLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Uri uri = Uri.parse(url);
                Set<String> args = uri.getQueryParameterNames();
                if (args != null) {
                    if (args.contains("code")) {
                        String code = uri.getQueryParameter("code");
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("client_id", CLIENT_ID);
                        params.put("client_secret", CLIENT_SECRET);
                        params.put("code", code);
                        getTokenBody(params);
                    }
                    if (args.contains("do")) {
                        String action = uri.getQueryParameter("do");
                        if (action == null) return;
                        if (action.equalsIgnoreCase("logout")) {
                            binding.wvSsoLogin.loadUrl(SSO_LOGIN_URL);
                        }
                    }

                }
            }
        });
    }

    private void getTokenBody(Map<String, String> params) {
        binding.pbSsoLogin.setVisibility(View.VISIBLE);
        ssoLoginViewModel.getTokenBodyLiveData(params).observe(this, ssoTokenModel -> {
            if (ssoTokenModel != null) {
                verifyToken(ssoTokenModel.getAccessToken());
            } else {
                Toast.makeText(this, "فشلت العملية", Toast.LENGTH_SHORT).show();
                binding.pbSsoLogin.setVisibility(View.GONE);
            }
        });
    }


    private void verifyToken(String token) {
        ssoLoginViewModel.verifyToken(token).observe(this, userInfoSsoModel -> {
            if (userInfoSsoModel != null) {
                String userSn = userInfoSsoModel.getUserId();
                SharedPreferences.Editor userSnEditor = getSharedPreferences(ApiConstent.USER_SN, MODE_PRIVATE).edit();
                userSnEditor.putString(ApiConstent.USER_SN, userSn);
                userSnEditor.apply();
                userSnEditor.commit();

                // Save User_Name in SharedPreference
                SharedPreferences.Editor userNameEditor = getSharedPreferences(ApiConstent.USER_NAME, MODE_PRIVATE).edit();
                userNameEditor.putString(ApiConstent.USER_NAME, userInfoSsoModel.getName());
                userNameEditor.apply();
                userNameEditor.commit();
                getUserRole(userSn);

            } else {
                Toast.makeText(this, "فشلت العملية", Toast.LENGTH_SHORT).show();
                binding.pbSsoLogin.setVisibility(View.GONE);
            }
        });
    }

    private void getUserRole(String userSn) {
        ssoLoginViewModel.getUserModel(userSn).observe(this, userRoleModel -> {
            binding.pbSsoLogin.setVisibility(View.GONE);
            if (userRoleModel != null) {

                // Save Login Status
                SharedPreferences.Editor loginEditor = getSharedPreferences(ApiConstent.USER_LOGIN_STATUS, MODE_PRIVATE).edit();
                loginEditor.putBoolean(ApiConstent.USER_LOGIN_STATUS, true);
                loginEditor.apply();
                loginEditor.commit();


                String token = userRoleModel.getAuthToken();
                Log.d(TAG, "Token : " + token);

                //Save Token
                SharedPreferences.Editor tokenEditor = getSharedPreferences(getString(R.string.key_token), MODE_PRIVATE).edit();
                tokenEditor.putString(getString(R.string.key_token), token);
                tokenEditor.apply();
                tokenEditor.commit();

                startActivity(new Intent(SsoLoginActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            } else {
                new ToastMsg(this).toastIconError(getString(R.string.proccess_failed));
            }
        });
    }

}