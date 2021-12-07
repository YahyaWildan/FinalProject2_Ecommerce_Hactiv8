package org.meicode.finalprojek2.Clothing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityClothingProductDetailBinding;

public class ClothingProductDetailActivity extends AppCompatActivity {
    ActivityClothingProductDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}