package org.meicode.finalprojek2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.finalprojek2.databinding.ActivityUserRegisterPagesBinding;

public class UserRegisterActivity extends AppCompatActivity {
    ActivityUserRegisterPagesBinding binding;

    DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserRegisterPagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        binding.btnUserRegisterCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }
    public void registerUser(){
        String name = binding.etUserRegisterName.getText().toString();
        String phoneNumber = binding.etUserRegisterPhoneNo.getText().toString();
        String password = binding.etUserRegisterPassword.getText().toString();

        Users users = new Users(name,phoneNumber,password);
        userDbRef.push().setValue(users);
        Toast.makeText(UserRegisterActivity.this,"User Register Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UserRegisterActivity.this, UserLoginPagesActivity.class));

    }

}