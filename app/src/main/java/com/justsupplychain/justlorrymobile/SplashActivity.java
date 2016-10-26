package com.justsupplychain.justlorrymobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.justsupplychain.justlorrymobile.constants.Constant;
import com.onesignal.OneSignal;

public class SplashActivity extends AppCompatActivity {

    private String _userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            @Override
            public void idsAvailable(String userId, String registrationId) {

                _userId = userId;
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra(Constant.ONE_SIGNAL, _userId);
                startActivity(intent);
                finish();
            }
        });
    }
}
