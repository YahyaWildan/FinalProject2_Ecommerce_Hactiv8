package org.meicode.finalprojek2.Clothing.ClothingProductListRecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityClothingProductListBinding;

public class ClothingProductListActivity extends AppCompatActivity {

    ActivityClothingProductListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}