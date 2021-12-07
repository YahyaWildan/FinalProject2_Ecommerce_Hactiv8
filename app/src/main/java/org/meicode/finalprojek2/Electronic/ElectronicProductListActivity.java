package org.meicode.finalprojek2.Electronic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.databinding.ActivityElectronicProductListBinding;

public class ElectronicProductListActivity extends AppCompatActivity {

    ActivityElectronicProductListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}