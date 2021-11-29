package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.finalprojek2.Admin.AdminLoginActivity;
import org.meicode.finalprojek2.Staff.StaffLoginActivity;
import org.meicode.finalprojek2.User.UserLoginActivity;
import org.meicode.finalprojek2.User.UserRegisterActivity;
import org.meicode.finalprojek2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserRegisterActivity.class));
            }
        });

        binding.btnGoToLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
            }
        });

        binding.tvAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
            }
        });

        binding.tvStaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StaffLoginActivity.class));
            }
        });
    }
}