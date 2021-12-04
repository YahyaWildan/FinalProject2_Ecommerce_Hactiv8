package org.meicode.finalprojek2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.finalprojek2.MainActivity;
import org.meicode.finalprojek2.R;
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
        startActivity(new Intent(UserRegisterActivity.this,UserLoginActivity.class));

    }

}