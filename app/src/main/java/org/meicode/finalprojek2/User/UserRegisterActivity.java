package org.meicode.finalprojek2.User;

import static org.meicode.finalprojek2.Database.Preference.DATABASE_REFERENCE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.finalprojek2.Admin.AdminActivity;
import org.meicode.finalprojek2.Admin.AdminAddStaffActivity;
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
                String nameUserRegister = binding.etUserRegisterName.getText().toString();
                String phoneNumberUserRegister = binding.etUserRegisterPhoneNo.getText().toString();
                String passwordUserRegister = binding.etUserRegisterPassword.getText().toString();

                if (nameUserRegister.isEmpty() || phoneNumberUserRegister.isEmpty() || passwordUserRegister.isEmpty()) {
                    Toast.makeText(UserRegisterActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
                } else {
                    DATABASE_REFERENCE.child("Users").child(phoneNumberUserRegister).child("nameUser").setValue(nameUserRegister);
                    DATABASE_REFERENCE.child("Users").child(phoneNumberUserRegister).child("passwordUser").setValue(passwordUserRegister);
                    Toast.makeText(UserRegisterActivity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserRegisterActivity.this, UserLoginPagesActivity.class));
                    finish();
                }
            }
        });

    }


}