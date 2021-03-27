package com.cbu.medical_survey_app.datas;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cbu.medical_survey_app.R;

import java.util.LinkedHashMap;

public class JobData {

    final private LinkedHashMap<String, String> mapped_data;

    public JobData() {
        mapped_data = new LinkedHashMap<String, String>();
    }

    private String getString(EditText view) {
        return view.getText().toString();
    }

    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }

    public void saveData(Context nowContext) {

    }

    public void setDataToView(ViewGroup vg) {

    }
}
