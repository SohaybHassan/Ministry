package com.sh.wm.ministry.network.utiels;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;

import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.sh.wm.ministry.network.utiels.ApiConstent.ACCEPT;
import static com.sh.wm.ministry.network.utiels.ApiConstent.ACCEPT_LANGUAGE;
import static com.sh.wm.ministry.network.utiels.ApiConstent.BASEURL;
import static com.sh.wm.ministry.network.utiels.ApiConstent.CONTENT_TYPE;
import static com.sh.wm.ministry.network.utiels.ApiConstent.HEADER_ACCEPT_LANGUAGE;
import static com.sh.wm.ministry.network.utiels.ApiConstent.HEADER_CONTENT_TYPE;
import static com.sh.wm.ministry.network.utiels.ApiConstent.TOKEN;
import static com.sh.wm.ministry.network.utiels.ApiConstent.ssoBASE_URL;


public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getName();
    public static boolean myConnection;
    private static NetworkUtils sInstance;
    private ApiInterface ssoApiInterface;
    private ApiInterface apiInterface;

    private NetworkUtils(Boolean isLogin, Context context) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(NetworkingParent(isLogin, context))
                .readTimeout(6000, TimeUnit.SECONDS)
                .connectTimeout(6000, TimeUnit.SECONDS)
                .build();

        Retrofit ssoRetrofit = new Retrofit.Builder()
                .baseUrl(ssoBASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        /*

         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getUnsafeOkHttpClient(true, context))
                .build();

        ssoApiInterface = ssoRetrofit.create(ApiInterface.class);
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static NetworkUtils getInstance(Boolean isLogin, Context context) {
        if (sInstance == null) {
            sInstance = new NetworkUtils(isLogin, context);
        }
        return sInstance;
    }

    public static void isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        connectivityManager.registerNetworkCallback(
                builder.build(),
                new ConnectivityManager.NetworkCallback() {
                    @Override
                    public void onAvailable(Network network) {
                        myConnection = true;
                    }

                    @Override
                    public void onLost(Network network) {
                        myConnection = false;
                    }
                }

        );

    }

    private OkHttpClient getUnsafeOkHttpClient(Boolean isLogin, Context context) {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);

            return new OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(NetworkingParent(isLogin, context))
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((s, sslSession) -> true)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Interceptor NetworkingParent(Boolean isLogin, Context context) {
        //Access to server useing Header
        Interceptor interceptor;
        if (isLogin) {
            interceptor = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                        .addHeader(HEADER_ACCEPT_LANGUAGE, ACCEPT_LANGUAGE)
                        .addHeader(ACCEPT, CONTENT_TYPE)
                        .addHeader(TOKEN, SharedPreferneceHelper.getToken(context));

                return chain.proceed(builder.build());
            };
        } else {
            interceptor = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                        .addHeader(HEADER_ACCEPT_LANGUAGE, ACCEPT_LANGUAGE)
                        .addHeader(ACCEPT, CONTENT_TYPE);
                return chain.proceed(builder.build());
            };
            Log.e(TAG, TOKEN + "");
        }
        return interceptor;
    }


    public ApiInterface getSsoApiInterface() {
        return ssoApiInterface;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }


}
