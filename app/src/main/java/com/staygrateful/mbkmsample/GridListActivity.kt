package com.staygrateful.mbkmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.staygrateful.mbkmsample.data.Data
import com.staygrateful.mbkmsample.databinding.ActivityGridListBinding
import com.staygrateful.mbkmsample.extension.dp
import com.staygrateful.mbkmsample.ui.view.adapter.GridAdapter
import com.staygrateful.mbkmsample.ui.view.decoration.GridSpacingItemDecoration

class GridListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridListBinding
    private val adapter = GridAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = "Grid List Sample (${Data.DUMMY_DATA.size})"

        binding.recycler.addItemDecoration(
            GridSpacingItemDecoration(
                spanCount = 4,
                spacing = 10.dp.toInt()
            )
        )
        binding.recycler.layoutManager = GridLayoutManager(this, 4)
        binding.recycler.adapter = adapter
        adapter.submitList(Data.DUMMY_DATA)
    }
}