package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FoodData_6 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] namul_checked = new int[10];
    private int[] radio_namul_checked = new int[10];

    private String[] namul_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_6() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(namul_checked, -1);
        Arrays.fill(radio_namul_checked, -1);
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

        for (int namulID = 0; namulID < namul_checked.length; namulID++) {

            TextView namul_name = ((Activity)nowContext).findViewById(getResId(nowContext, "namul_name" + (namulID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox namul_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_namul" + (namulID + 1) + "_ans" + (ansID + 1)));

                if(namul_ans.isChecked()){
                    namul_checked[namulID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_namul_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_namul" + (namulID + 1) + "_ans" + (ansID + 1)));

                if(radio_namul_ans.isChecked()){
                    radio_namul_checked[namulID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(namul_name) + ")", namul_checked[namulID] == -1 ? "" : namul_str[namul_checked[namulID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(namul_name) + ")", radio_namul_checked[namulID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_namul" + (namulID + 1) + "_ans" + (radio_namul_checked[namulID] + 1) + "_text"))));
        }
    }

    public void setDataToView(ViewGroup vg) {

        for (int namulID = 0; namulID < namul_checked.length; namulID++) {
            if(namul_checked[namulID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_namul" + (namulID + 1) + "_ans" + (namul_checked[namulID] + 1)))).setChecked(true);
            }
        }

        for (int namulID = 0; namulID < radio_namul_checked.length; namulID++) {
            if(radio_namul_checked[namulID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_namul" + (namulID + 1) + "_ans" + (radio_namul_checked[namulID] + 1)))).setChecked(true);
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

        for (int namulID = 0; namulID < namul_checked.length; namulID++) {
            if(namul_checked[namulID] == -1){
                return false;
            }
        }

        for (int namulID = 0; namulID < radio_namul_checked.length; namulID++) {
            if(radio_namul_checked[namulID] == -1){
                return false;
            }
        }

        return true;
    }
}
