package com.staygrateful.mbkmsample;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.staygrateful.mbkmsample.data.Data;
import com.staygrateful.mbkmsample.databinding.ActivityListBinding;
import com.staygrateful.mbkmsample.ui.view.adapter.MhsJavaListAdapter;

import java.util.ArrayList;

public class ListJavaActivity extends AppCompatActivity {

    ActivityListBinding binding;
    MhsJavaListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MhsJavaListAdapter();
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
        adapter.submitList(Data.INSTANCE.getMHS_ROOM_DATA());
    }
}
