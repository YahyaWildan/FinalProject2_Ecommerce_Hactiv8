package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.finalprojek2.Admin.AdminLoginPagesActivity;
import org.meicode.finalprojek2.Staff.StaffLoginPagesActivity;
import org.meicode.finalprojek2.User.UserLoginPagesActivity;
import org.meicode.finalprojek2.User.UserRegisterActivity;
import org.meicode.finalprojek2.databinding.ActivityMainLoginBinding;

public class MainLoginActivity extends AppCompatActivity {

    ActivityMainLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginActivity.this, UserRegisterActivity.class));
            }
        });

        binding.btnGoToLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginActivity.this, UserLoginPagesActivity.class));
            }
        });

        binding.tvAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginActivity.this, AdminLoginPagesActivity.class));
            }
        });

        binding.tvStaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginActivity.this, StaffLoginPagesActivity.class));
            }
        });
    }
}