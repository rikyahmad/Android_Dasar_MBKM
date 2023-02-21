package com.staygrateful.mbkmsample.ui.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.staygrateful.mbkmsample.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFrame.setOnClickListener {
            binding.frame.root.visibility = View.VISIBLE
            binding.linear.root.visibility = View.GONE
            binding.relative.root.visibility = View.GONE
            binding.constraint.root.visibility = View.GONE
        }

        binding.btnLinear.setOnClickListener {
            binding.frame.root.visibility = View.GONE
            binding.linear.root.visibility = View.VISIBLE
            binding.relative.root.visibility = View.GONE
            binding.constraint.root.visibility = View.GONE
        }

        binding.btnRelative.setOnClickListener {
            binding.frame.root.visibility = View.GONE
            binding.linear.root.visibility = View.GONE
            binding.relative.root.visibility = View.VISIBLE
            binding.constraint.root.visibility = View.GONE
        }

        binding.btnConstraint.setOnClickListener {
            binding.frame.root.visibility = View.GONE
            binding.linear.root.visibility = View.GONE
            binding.relative.root.visibility = View.GONE
            binding.constraint.root.visibility = View.VISIBLE
        }
    }
}