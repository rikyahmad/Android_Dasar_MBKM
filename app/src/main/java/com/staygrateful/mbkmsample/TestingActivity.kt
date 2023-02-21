package com.staygrateful.mbkmsample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.staygrateful.mbkmsample.databinding.ActivityTestingBinding
import com.staygrateful.mbkmsample.extension.showToast

class TestingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSum.setOnClickListener {
            val input1 = parseInt(binding.input1.text.toString())
            val input2 = parseInt(binding.input2.text.toString())
            if (input1 != null && input2 != null) {
                val result = Calculator.sum(input1, input2)
                binding.result.visibility = View.VISIBLE
                binding.result.text = getString(R.string.calculator_result, result.toString())
            } else {
                showToast("Invalid input type!")
            }
        }
    }

    private fun parseInt(value: String): Int? {
        try {
            return value.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}