package com.example.cbu_medical_survey_app.datas;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class NormalData_1 {
    final private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    private String uesr_sex="";
    private String uesr_marred_status="";
    private String user_brith="";
    private String user_czs="";
    private String user_mom_age="";
    private String user_id="";
    private String user_height="";
    private String user_weight="";
    private String user_period_address="";
    private String user_weight_20th="";
    private String user_weight_30th="";
    private String user_weight_best="";
    private String user_final_education="";
    private String user_houserhold_member="";
    private String user_salary = "";


        final private LinkedHashMap<String, String> mapped_data;

        public NormalData_1() {
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

