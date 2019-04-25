package com.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.retrofitexample.model.UserProfile;
import com.retrofitexample.retrofit.ApiClient;
import com.retrofitexample.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + ">>";
    private TextView mTvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResponse = findViewById(R.id.tvResponse);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserProfile> call = apiService.getUserProfile("312",
                "dcWC09jA2Bc:APA91bFXwY6OdPlcdNm90mpAQ5bHejt9QstTmP71ulr2RBZK1omvW2pswlcNGW9WS-cQNQTln2Wa_FHs40qQ67NObw8PcAmwlvVxJ0X2MshLyq8c9p8v22cxZz5iJNq05NGenYwNKR6Y",
                "31f29bbc8a8c3a47", "android");
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                UserProfile myreponse = response.body();
                mTvResponse.setText(myreponse.toString());
                Log.e(TAG, "response : " + response.toString());
                Log.e(TAG, "response : " + myreponse.toString());
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                // Log error here since request failed
                mTvResponse.setText(t.getLocalizedMessage());
            }
        });
    }
}
