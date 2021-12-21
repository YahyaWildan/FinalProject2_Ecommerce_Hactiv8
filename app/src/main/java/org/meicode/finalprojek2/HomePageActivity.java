package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.finalprojek2.Clothing.ClothingAccGenderActivity;
import org.meicode.finalprojek2.Electronic.ElectronicProductListActivity;
import org.meicode.finalprojek2.OtherItem.OtherItemProductActivity;
import org.meicode.finalprojek2.databinding.ActivityHomePageBinding;

public class HomePageActivity extends AppCompatActivity {

    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.layoutGoToClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, ClothingAccGenderActivity.class));
            }
        });

        binding.layoutGoToElectronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, ElectronicProductListActivity.class));
            }
        });

        binding.layoutGoToOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, OtherItemProductActivity.class));
            }
        });
    }
}