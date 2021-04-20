package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cbu.medical_survey_app.R;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FoodData_2 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] flour_checked = new int[6];
    private int[] radio_flour_checked = new int[6];

    private String[] flour_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_2() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(flour_checked, -1);
        Arrays.fill(radio_flour_checked, -1);
    }

    private String getString(EditText view) {
        return view.getText().toString();
    }

    private String getString(TextView view) {
        return view.getText().toString();
    }

    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }

    public void saveData(Context nowContext) {

        for (int flourID = 0; flourID < flour_checked.length; flourID++) {

            TextView flour_name = ((Activity)nowContext).findViewById(getResId(nowContext, "flour_name" + (flourID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox flour_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_flour" + (flourID + 1) + "_ans" + (ansID + 1)));

                if(flour_ans.isChecked()){
                    flour_checked[flourID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_flour_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_flour" + (flourID + 1) + "_ans" + (ansID + 1)));

                if(radio_flour_ans.isChecked()){
                    radio_flour_checked[flourID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(flour_name) + ")", flour_checked[flourID] == -1 ? "" : flour_str[flour_checked[flourID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(flour_name) + ")", radio_flour_checked[flourID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_flour" + (flourID + 1) + "_ans" + (radio_flour_checked[flourID] + 1) + "_text"))));
        }
    }

    public void setDataToView(ViewGroup vg) {

        for (int flourID = 0; flourID < flour_checked.length; flourID++) {
            if(flour_checked[flourID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_flour" + (flourID + 1) + "_ans" + (flour_checked[flourID] + 1)))).setChecked(true);
            }
        }

        for (int flourID = 0; flourID < radio_flour_checked.length; flourID++) {
            if(radio_flour_checked[flourID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_flour" + (flourID + 1) + "_ans" + (radio_flour_checked[flourID] + 1)))).setChecked(true);
            }
        }
    }

    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", vg.getContext().getPackageName());
        return getID;
    }

    public boolean check() {

        for (int flourID = 0; flourID < flour_checked.length; flourID++) {
            if(flour_checked[flourID] == -1){
                return false;
            }
        }

        for (int flourID = 0; flourID < radio_flour_checked.length; flourID++) {
            if(radio_flour_checked[flourID] == -1){
                return false;
            }
        }

        return true;
    }
}
