package org.meicode.finalprojek2.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.Staff.Staffs;
import org.meicode.finalprojek2.databinding.ActivityAdminLoginPagesBinding;

public class AdminLoginPagesActivity extends AppCompatActivity {

    ActivityAdminLoginPagesBinding binding;

    DatabaseReference adminDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminLoginPagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adminDbRef = FirebaseDatabase.getInstance().getReference().child("Admins");


        binding.btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}