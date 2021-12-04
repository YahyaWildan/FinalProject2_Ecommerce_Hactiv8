package org.meicode.finalprojek2.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.Staff.Staffs;
import org.meicode.finalprojek2.databinding.ActivityAdminAddStaffBinding;

public class AdminAddStaffActivity extends AppCompatActivity {

    ActivityAdminAddStaffBinding binding;
    DatabaseReference staffDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminAddStaffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        staffDbRef = FirebaseDatabase.getInstance().getReference().child("Staffs");

        binding.btnAddStaffRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStaffData();
            }
        });
    }

    public boolean addStaffData(){
        String username = binding.etAddStaffAdminUserName.getText().toString();
        String password = binding.etAddStaffAdminPassword.getText().toString();
        String confirmPassword = binding.etAddStaffConfirmPassword.getText().toString();

        if (!password.equals(confirmPassword)){
            Toast.makeText(AdminAddStaffActivity.this, "Password Would Not be Matched", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            Staffs staffs = new Staffs(username,password,confirmPassword);

            staffDbRef.push().setValue(staffs);
            Toast.makeText(AdminAddStaffActivity.this, "Staff inserted", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

}