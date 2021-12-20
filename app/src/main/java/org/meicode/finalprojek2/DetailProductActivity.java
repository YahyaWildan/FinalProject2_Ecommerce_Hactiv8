package org.meicode.finalprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import org.meicode.finalprojek2.databinding.ActivityDetailProductBinding;

public class DetailProductActivity extends AppCompatActivity {

    ActivityDetailProductBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String title = getIntent().getStringExtra("title");
        String price = getIntent().getStringExtra("price");
        String description = getIntent().getStringExtra("description");
        String image = getIntent().getStringExtra("image");

        binding.tvTitleDetailProduct.setText(title);
        binding.tvDescriptionDetailProduct.setText(description);
        binding.tvPriceDetailProduct.setText(price);

        Glide.with(DetailProductActivity.this)
                .load(image).into(binding.ivDetailProduct);

    }
}