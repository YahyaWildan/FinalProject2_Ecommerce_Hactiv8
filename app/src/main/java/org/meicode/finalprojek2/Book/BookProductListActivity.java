package org.meicode.finalprojek2.Book;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.meicode.finalprojek2.databinding.ActivityBookProductListBinding;


public class BookProductListActivity extends AppCompatActivity {
    ActivityBookProductListBinding binding;

    @Override
    protected void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        binding = ActivityBookProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
