package org.meicode.finalprojek2.Staff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.meicode.finalprojek2.R;
import org.meicode.finalprojek2.databinding.ActivityStaffLoginPagesBinding;

public class StaffLoginPagesActivity extends AppCompatActivity {
    ActivityStaffLoginPagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}