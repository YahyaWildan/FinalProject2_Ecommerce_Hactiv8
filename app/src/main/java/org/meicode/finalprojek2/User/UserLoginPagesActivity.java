package org.meicode.finalprojek2.User;

import static org.meicode.finalprojek2.Database.Preference.DATABASE_REFERENCE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.meicode.finalprojek2.Admin.AdminActivity;
import org.meicode.finalprojek2.Admin.AdminLoginPagesActivity;
import org.meicode.finalprojek2.HomePages.HomePagesActivity;
import org.meicode.finalprojek2.databinding.ActivityUserLoginPagesBinding;

public class UserLoginPagesActivity extends AppCompatActivity {
    ActivityUserLoginPagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserLoginPagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNoLoginUser = binding.etUserLoginPhoneNo.getText().toString();
                String passwordLoginUser = binding.etUserLoginPassword.getText().toString();

                if (phoneNoLoginUser.isEmpty() || passwordLoginUser.isEmpty()){
                    Toast.makeText(UserLoginPagesActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
                } else {
                    DATABASE_REFERENCE.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneNoLoginUser)) {
                                String getPasswordLogin = snapshot.child(phoneNoLoginUser).child("passwordUser").getValue(String.class);
                                if (getPasswordLogin.equals(passwordLoginUser)) {
                                    Toast.makeText(UserLoginPagesActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(UserLoginPagesActivity.this, AdminLoginPagesActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(UserLoginPagesActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(UserLoginPagesActivity.this, "Wrong Phone Number", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });


    }
}