package org.meicode.finalprojek2.HomePages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityHomePagesBinding;

public class HomePagesActivity extends AppCompatActivity {
    ActivityHomePagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}