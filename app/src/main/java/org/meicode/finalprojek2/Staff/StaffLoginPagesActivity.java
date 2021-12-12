package org.meicode.finalprojek2.Staff;

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

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityStaffLoginPagesBinding;

public class StaffLoginPagesActivity extends AppCompatActivity {
    ActivityStaffLoginPagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStaffLoginPagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStaffLogin = binding.etStaffUserName.getText().toString();
                String passwordStaffLogin = binding.etStaffPassword.getText().toString();

                if (usernameStaffLogin.isEmpty() || passwordStaffLogin.isEmpty()) {
                    Toast.makeText(StaffLoginPagesActivity.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                } else {
                    DATABASE_REFERENCE.child("Staffs").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if username/password is exist in firebase db
                            if (snapshot.hasChild(usernameStaffLogin)) {
                                String getPasswordLogin = snapshot.child(usernameStaffLogin).child("password").getValue(String.class);
                                if (getPasswordLogin.equals(passwordStaffLogin)) {
                                    Toast.makeText(StaffLoginPagesActivity.this, "Successfully Staff Logged in", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(StaffLoginPagesActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(StaffLoginPagesActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
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