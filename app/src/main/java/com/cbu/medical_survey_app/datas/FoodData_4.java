package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FoodData_4 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] dooboo_checked = new int[6];
    private int[] radio_dooboo_checked = new int[6];

    private String[] dooboo_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_4() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(dooboo_checked, -1);
        Arrays.fill(radio_dooboo_checked, -1);
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

        for (int doobooID = 0; doobooID < dooboo_checked.length; doobooID++) {

            TextView dooboo_name = ((Activity)nowContext).findViewById(getResId(nowContext, "dooboo_name" + (doobooID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox dooboo_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_dooboo" + (doobooID + 1) + "_ans" + (ansID + 1)));

                if(dooboo_ans.isChecked()){
                    dooboo_checked[doobooID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_dooboo_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_dooboo" + (doobooID + 1) + "_ans" + (ansID + 1)));

                if(radio_dooboo_ans.isChecked()){
                    radio_dooboo_checked[doobooID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(dooboo_name) + ")", dooboo_checked[doobooID] == -1 ? "" : dooboo_str[dooboo_checked[doobooID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(dooboo_name) + ")", radio_dooboo_checked[doobooID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_dooboo" + (doobooID + 1) + "_ans" + (radio_dooboo_checked[doobooID] + 1) + "_text"))));
        }
    }

    public void setDataToView(ViewGroup vg) {

        for (int doobooID = 0; doobooID < dooboo_checked.length; doobooID++) {
            if(dooboo_checked[doobooID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_dooboo" + (doobooID + 1) + "_ans" + (dooboo_checked[doobooID] + 1)))).setChecked(true);
            }
        }

        for (int doobooID = 0; doobooID < radio_dooboo_checked.length; doobooID++) {
            if(radio_dooboo_checked[doobooID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_dooboo" + (doobooID + 1) + "_ans" + (radio_dooboo_checked[doobooID] + 1)))).setChecked(true);
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

        for (int doobooID = 0; doobooID < dooboo_checked.length; doobooID++) {
            if(dooboo_checked[doobooID] != -1 && dooboo_checked[doobooID] != 0){
                if(radio_dooboo_checked[doobooID] == -1){
                    return false;
                }
            }
        }

        return true;
    }
}
