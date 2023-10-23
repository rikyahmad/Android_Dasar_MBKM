package com.staygrateful.mbkmsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.staygrateful.mbkmsample.databinding.ActivityMainBinding;
import com.staygrateful.mbkmsample.ui.compose.activity.ComposeActivity;
import com.staygrateful.mbkmsample.ui.view.activity.ViewActivity;

public class JavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String data = getIntent().getStringExtra("KEY_DATA");


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.view.setOnClickListener(v -> {
            openActivity(ViewActivity.class);
        });

        binding.compose.setOnClickListener(v -> {
            openActivity(ComposeActivity.class);
        });


    }

    private void openActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}