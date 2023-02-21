package com.staygrateful.mbkmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.databinding.ActivityListBinding
import com.staygrateful.mbkmsample.room.viewmodel.MhsViewModel
import com.staygrateful.mbkmsample.ui.view.adapter.DeleteListener
import com.staygrateful.mbkmsample.ui.view.adapter.MhsListAdapter

class ListRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: MhsViewModel
    private lateinit var adapter: MhsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MhsViewModel(application)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = "List + Room Sample"

        viewModel.dataLiveData.observe(this) { items ->
            adapter.submitList(items)
        }

        adapter = MhsListAdapter(object : DeleteListener {
            override fun onClickDelete(adapter: MhsListAdapter, index: Int) {
                val currentItem = adapter.currentList.getOrNull(index)
                if (currentItem != null) {
                    viewModel.delete(currentItem)
                }
            }
        })

        binding.btnAdd.setOnClickListener {
            addToList()
        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }

    private fun addToList() {
        val count = adapter.currentList.size
        val newData = MhsRoomModel(0, "Mhs $count", "Universitas $count")
        viewModel.insert(newData)
    }
}