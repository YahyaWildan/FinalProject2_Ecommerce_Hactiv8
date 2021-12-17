package org.meicode.finalprojek2.Clothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.finalprojek2.Clothing.ClothingProductListRecycleView.ClothingProductListActivity;
import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityClothingCategoryBinding;

public class ClothingCategoryActivity extends AppCompatActivity {

    ActivityClothingCategoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothingCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvTshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClothingCategoryActivity.this, ClothingProductListActivity.class));
            }
        });
    }
}