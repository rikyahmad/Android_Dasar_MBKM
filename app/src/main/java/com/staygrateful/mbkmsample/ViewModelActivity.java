package com.staygrateful.mbkmsample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.staygrateful.mbkmsample.databinding.ActivityTestingBinding;
import com.staygrateful.mbkmsample.mvvm.CalculatorViewModel;
import com.staygrateful.mbkmsample.mvvm.model.CalculatorModel;

public class ViewModelActivity extends AppCompatActivity {

    private ActivityTestingBinding binding;

    private CalculatorViewModel calculatorViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        calculatorViewModel.getCalcLiveData().observe(this, new Observer<CalculatorModel>() {
            @Override
            public void onChanged(CalculatorModel calculatorModel) {
                if (calculatorModel.errorMessage != null) {
                    binding.errorResult.setText(calculatorModel.errorMessage);
                    binding.errorResult.setVisibility(View.VISIBLE);
                    binding.result.setVisibility(View.GONE);
                    return;
                }
                binding.result.setText(String.format("Hasil : %s", calculatorModel.result));
                binding.errorResult.setVisibility(View.GONE);
                binding.result.setVisibility(View.VISIBLE);
            }
        });

        binding.input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorViewModel.setInput1(s.toString());
            }
        });

        binding.input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorViewModel.setInput2(s.toString());
            }
        });

        binding.btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorViewModel.sum();
            }
        });
    }
}
