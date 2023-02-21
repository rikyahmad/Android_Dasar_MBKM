package com.staygrateful.mbkmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.staygrateful.mbkmsample.data.Data
import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.databinding.ActivityListBinding
import com.staygrateful.mbkmsample.ui.view.adapter.DeleteListener
import com.staygrateful.mbkmsample.ui.view.adapter.MhsListAdapter

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: MhsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = "List Sample"

        binding.btnAdd.setOnClickListener {
            addToList()
        }

        adapter = MhsListAdapter(object : DeleteListener {
            override fun onClickDelete(adapter: MhsListAdapter, index: Int) {
                val currentList = adapter.currentList.toMutableList()
                currentList.removeAt(index)
                adapter.submitList(currentList)
            }
        })

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        adapter.submitList(Data.MHS_ROOM_DATA)
    }

    private fun addToList() {
        val currentList = adapter.currentList.toMutableList()
        val count = currentList.size
        currentList.add(MhsRoomModel(0, "Mhs $count", "Universitas $count"))
        adapter.submitList(currentList)
    }
}