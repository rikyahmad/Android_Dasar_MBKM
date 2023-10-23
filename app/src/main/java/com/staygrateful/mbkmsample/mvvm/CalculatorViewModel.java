package com.staygrateful.mbkmsample.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.staygrateful.mbkmsample.mvvm.model.CalculatorModel;


public class CalculatorViewModel extends ViewModel {
    final CalculatorModel cm = new CalculatorModel();

    private final MutableLiveData<CalculatorModel> calcLiveData = new MutableLiveData<>();

    public void setInput1(String input1) {
        this.cm.input_1 = parseDouble(input1);
    }

    public void setInput2(String input2) {
        this.cm.input_2 = parseDouble(input2);
    }

    public void sum() {
        if (cm.input_1 == null && cm.input_2 == null) {
            this.cm.errorMessage = "Input 1 dan 2 tidak valid";
        } else if (cm.input_1 == null) {
            this.cm.errorMessage = "Input 1 tidak valid";
        } else if (cm.input_2 == null) {
            this.cm.errorMessage = "Input 2 tidak valid";
        } else {
            this.cm.errorMessage = null;
            this.cm.result = cm.input_1 + cm.input_2;
        }
        calcLiveData.setValue(cm);
    }

    public MutableLiveData<CalculatorModel> getCalcLiveData() {
        return calcLiveData;
    }

    private Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
