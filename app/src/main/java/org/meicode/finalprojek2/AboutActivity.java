package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}