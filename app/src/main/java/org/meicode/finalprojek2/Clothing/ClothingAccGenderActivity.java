package org.meicode.finalprojek2.Clothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityClothingAccGenderBinding;

public class ClothingAccGenderActivity extends AppCompatActivity {
    ActivityClothingAccGenderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothingAccGenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvMensClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClothingAccGenderActivity.this, ClothingMensProductListActivity.class));
            }
        });

        binding.tvWomensClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClothingAccGenderActivity.this, ClothingWomenProductListActivity.class));

            }
        });
    }
}