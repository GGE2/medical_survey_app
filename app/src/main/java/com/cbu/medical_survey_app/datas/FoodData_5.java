package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FoodData_5 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] kimchi_checked = new int[7];
    private int[] radio_kimchi_checked = new int[7];

    private String[] kimchi_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_5() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(kimchi_checked, -1);
        Arrays.fill(radio_kimchi_checked, -1);
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

        for (int kimchiID = 0; kimchiID < kimchi_checked.length; kimchiID++) {

            TextView kimchi_name = ((Activity)nowContext).findViewById(getResId(nowContext, "kimchi_name" + (kimchiID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox kimchi_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_kimchi" + (kimchiID + 1) + "_ans" + (ansID + 1)));

                if(kimchi_ans.isChecked()){
                    kimchi_checked[kimchiID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_kimchi_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_kimchi" + (kimchiID + 1) + "_ans" + (ansID + 1)));

                if(radio_kimchi_ans.isChecked()){
                    radio_kimchi_checked[kimchiID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(kimchi_name) + ")", kimchi_checked[kimchiID] == -1 ? "" : kimchi_str[kimchi_checked[kimchiID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(kimchi_name) + ")", radio_kimchi_checked[kimchiID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_kimchi" + (kimchiID + 1) + "_ans" + (radio_kimchi_checked[kimchiID] + 1) + "_text"))));
        }
    }

    public void setDataToView(ViewGroup vg) {

        for (int kimchiID = 0; kimchiID < kimchi_checked.length; kimchiID++) {
            if(kimchi_checked[kimchiID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_kimchi" + (kimchiID + 1) + "_ans" + (kimchi_checked[kimchiID] + 1)))).setChecked(true);
            }
        }

        for (int kimchiID = 0; kimchiID < radio_kimchi_checked.length; kimchiID++) {
            if(radio_kimchi_checked[kimchiID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_kimchi" + (kimchiID + 1) + "_ans" + (radio_kimchi_checked[kimchiID] + 1)))).setChecked(true);
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

        for (int kimchiID = 0; kimchiID < kimchi_checked.length; kimchiID++) {
            if(kimchi_checked[kimchiID] == -1){
                return false;
            }
        }

        for (int kimchiID = 0; kimchiID < radio_kimchi_checked.length; kimchiID++) {
            if(radio_kimchi_checked[kimchiID] == -1){
                return false;
            }
        }

        return true;
    }
}
