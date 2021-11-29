package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(()->{
            Intent intent;
            intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
        },5000);
    }
}