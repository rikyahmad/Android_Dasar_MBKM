package com.staygrateful.mbkmsample.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.staygrateful.mbkmsample.R;
import com.staygrateful.mbkmsample.data.Data;
import com.staygrateful.mbkmsample.databinding.ActivityListBinding;
import com.staygrateful.mbkmsample.databinding.ActivityMainBinding;
import com.staygrateful.mbkmsample.ui.view.adapter.SampleListAdapter;

public class SampleActivity extends AppCompatActivity {

    ActivityListBinding binding;
    SampleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new SampleListAdapter();
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
        adapter.submitList(Data.INSTANCE.getMHS_ROOM_DATA());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}