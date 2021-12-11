package org.meicode.finalprojek2.Admin;

import static org.meicode.finalprojek2.Database.Preference.DATABASE_REFERENCE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.meicode.finalprojek2.databinding.ActivityAdminAddStaffBinding;

public class AdminAddStaffActivity extends AppCompatActivity {

    ActivityAdminAddStaffBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminAddStaffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAddStaffRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameRegisterStaff = binding.etAddStaffName.getText().toString();
                String userNameRegisterStaff = binding.etAddStaffUserName.getText().toString();
                String passwordRegisterStaff = binding.etAddStaffPassword.getText().toString();
                String confirmPasswordRegisterStaff = binding.etAddStaffConfirmPassword.getText().toString();

                if (nameRegisterStaff.isEmpty() || userNameRegisterStaff.isEmpty() || passwordRegisterStaff.isEmpty() || confirmPasswordRegisterStaff.isEmpty()) {
                    Toast.makeText(AdminAddStaffActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
                } else if (!passwordRegisterStaff.equals(confirmPasswordRegisterStaff)) {
                    Toast.makeText(AdminAddStaffActivity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                } else {
                    DATABASE_REFERENCE.child("Staffs").child(userNameRegisterStaff).child("name").setValue(nameRegisterStaff);
                    DATABASE_REFERENCE.child("Staffs").child(userNameRegisterStaff).child("password").setValue(passwordRegisterStaff);
                    DATABASE_REFERENCE.child("Staffs").child(userNameRegisterStaff).child("confirmpassword").setValue(confirmPasswordRegisterStaff);
                    Toast.makeText(AdminAddStaffActivity.this, "Staff Register Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminAddStaffActivity.this, AdminActivity.class));
                    finish();
                }
            }
        });
    }

}