package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FoodData_3 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] peanut_checked = new int[8];
    private int[] radio_peanut_checked = new int[8];

    private String[] peanut_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_3() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(peanut_checked, -1);
        Arrays.fill(radio_peanut_checked, -1);
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

        for (int peanutID = 0; peanutID < peanut_checked.length; peanutID++) {

            TextView peanut_name = ((Activity)nowContext).findViewById(getResId(nowContext, "peanut_name" + (peanutID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox peanut_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_peanut" + (peanutID + 1) + "_ans" + (ansID + 1)));

                if(peanut_ans.isChecked()){
                    peanut_checked[peanutID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_peanut_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_peanut" + (peanutID + 1) + "_ans" + (ansID + 1)));

                if(radio_peanut_ans.isChecked()){
                    radio_peanut_checked[peanutID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(peanut_name) + ")", peanut_checked[peanutID] == -1 ? "" : peanut_str[peanut_checked[peanutID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(peanut_name) + ")", radio_peanut_checked[peanutID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_peanut" + (peanutID + 1) + "_ans" + (radio_peanut_checked[peanutID] + 1) + "_text"))));
        }
    }

    public void setDataToView(ViewGroup vg) {

        for (int peanutID = 0; peanutID < peanut_checked.length; peanutID++) {
            if(peanut_checked[peanutID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_peanut" + (peanutID + 1) + "_ans" + (peanut_checked[peanutID] + 1)))).setChecked(true);
            }
        }

        for (int peanutID = 0; peanutID < radio_peanut_checked.length; peanutID++) {
            if(radio_peanut_checked[peanutID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_peanut" + (peanutID + 1) + "_ans" + (radio_peanut_checked[peanutID] + 1)))).setChecked(true);
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

        for (int peanutID = 0; peanutID < peanut_checked.length; peanutID++) {
            if(peanut_checked[peanutID] == -1){
                return false;
            }
        }

        for (int peanutID = 0; peanutID < radio_peanut_checked.length; peanutID++) {
            if(radio_peanut_checked[peanutID] == -1){
                return false;
            }
        }

        return true;
    }
}
