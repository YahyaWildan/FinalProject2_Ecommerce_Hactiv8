package org.meicode.finalprojek2.OtherItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityOtherItemProductBinding;

public class OtherItemProductActivity extends AppCompatActivity {
    ActivityOtherItemProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}