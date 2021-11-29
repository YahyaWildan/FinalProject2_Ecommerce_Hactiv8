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

import org.meicode.finalprojek2.MainActivity;
import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityUserRegisterPagesBinding;

public class UserRegisterActivity extends AppCompatActivity {
    ActivityUserRegisterPagesBinding binding;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        binding.btnUserRegisterCreateAccount.setOnClickListener(v->{
            if(binding.etUserRegisterName.getText().length()>0 && binding.etUserRegisterPhoneNo.getText().length()>0 && binding.etUserRegisterPassword.getText().length()>0 ){
                register(binding.etUserRegisterName.getText().toString(), binding.etUserRegisterPassword.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "Silahkan Lengkapi Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private  void reload(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    private void register(String email, String password){
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!= null) {
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser!= null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name);
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    } else{
                        Toast.makeText(getApplicationContext(), "Register gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}