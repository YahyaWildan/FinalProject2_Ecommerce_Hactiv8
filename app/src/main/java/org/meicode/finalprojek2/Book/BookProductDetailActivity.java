package org.meicode.finalprojek2.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityBookProductDetailBinding;

public class BookProductDetailActivity extends AppCompatActivity {
    ActivityBookProductDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}