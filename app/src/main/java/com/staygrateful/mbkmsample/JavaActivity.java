package com.staygrateful.mbkmsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.staygrateful.mbkmsample.ui.compose.activity.ComposeActivity;
import com.staygrateful.mbkmsample.ui.view.activity.ViewActivity;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.view).setOnClickListener(v -> {
            openActivity(ViewActivity.class);
        });

        findViewById(R.id.compose).setOnClickListener(v -> {
            openActivity(ComposeActivity.class);
        });

        findViewById(R.id.raw_assets).setOnClickListener(v -> {
            openActivity(RawAssetsActivity.class);
        });

        findViewById(R.id.list).setOnClickListener(v -> {
            openActivity(ListActivity.class);
        });

        findViewById(R.id.grid).setOnClickListener(v -> {
            openActivity(GridListActivity.class);
        });

        findViewById(R.id.list_room).setOnClickListener(v -> {
            openActivity(ListRoomActivity.class);
        });

        findViewById(R.id.retrofit).setOnClickListener(v -> {
            openActivity(RetrofitActivity.class);
        });

        findViewById(R.id.testing).setOnClickListener(v -> {
            openActivity(TestingActivity.class);
        });
    }

    private void openActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }
}