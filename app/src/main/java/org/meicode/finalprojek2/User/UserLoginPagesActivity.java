package org.meicode.finalprojek2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityUserLoginPagesBinding;

public class UserLoginPagesActivity extends AppCompatActivity {
    ActivityUserLoginPagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_pages);
    }
}