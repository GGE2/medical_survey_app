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

public class FoodData_1 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] rice_checked = new int[7];

    private int[] radio_rice_checked = new int[7];

    private int radio_rice_sub1_checked = -1;
    private int radio_rice_sub2_checked = -1;

    private String[] rice_str = {"거의 안먹음", "월 1회", "월 2~3회", "주 1~2회", "주 3~4회", "주 5~6회", "일 1회", "일 2회", "일 3회"};

    public FoodData_1() {
        mapped_data = new LinkedHashMap<String, String>();

        Arrays.fill(rice_checked, -1);
        Arrays.fill(radio_rice_checked, -1);
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

        RadioGroup rg_rice_sub1 = ((Activity)nowContext).findViewById(R.id.radiogroup_rice_sub1);
        RadioGroup rg_rice_sub2 = ((Activity)nowContext).findViewById(R.id.radiogroup_rice_sub2);
        radio_rice_sub1_checked = rg_rice_sub1.getCheckedRadioButtonId();
        radio_rice_sub2_checked = rg_rice_sub2.getCheckedRadioButtonId();

        for (int riceID = 0; riceID < rice_checked.length; riceID++) {

            TextView rice_name = ((Activity)nowContext).findViewById(getResId(nowContext, "rice_name" + (riceID + 1)));

            for (int ansID = 0; ansID < 9; ansID++) {
                CheckBox rice_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_rice" + (riceID + 1) + "_ans" + (ansID + 1)));

                if(rice_ans.isChecked()){
                    rice_checked[riceID] = ansID;
                }
            }

            for (int ansID = 0; ansID < 3; ansID++) {
                CheckBox radio_rice_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_rice" + (riceID + 1) + "_ans" + (ansID + 1)));

                if(radio_rice_ans.isChecked()){
                    radio_rice_checked[riceID] = ansID;
                }
            }

            mapped_data.put("지난 1년간 섭취 횟수(" + getString(rice_name) + ")", rice_checked[riceID] == -1 ? "" : rice_str[rice_checked[riceID]]);
            mapped_data.put("평균 1회 섭취분량(" + getString(rice_name) + ")", radio_rice_checked[riceID] == -1 ? "" : getString((TextView) ((Activity)nowContext).findViewById(getResId(nowContext, "radio_rice" + (riceID + 1) + "_ans" + (radio_rice_checked[riceID] + 1) + "_text"))));

            if(riceID == 0) {
                mapped_data.put("주로 먹는 밥 종류", radio_rice_sub1_checked == -1 ? "" : ((RadioButton)((Activity)nowContext).findViewById(radio_rice_sub1_checked)).getText().toString());
                mapped_data.put("잡곡밥 종류", radio_rice_sub2_checked == -1 ? "" : ((RadioButton)((Activity)nowContext).findViewById(radio_rice_sub2_checked)).getText().toString());
            }

            System.out.println(mapped_data.get("평균 1회 섭취분량(" + getString(rice_name) + ")"));
        }
    }

    public void setDataToView(ViewGroup vg) {

//        if(radio_sleep_hour_checked == R.id.radio_sleep_hour_1){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_1)).setChecked(true);
//        }
//        else if(radio_sleep_hour_checked == R.id.radio_sleep_hour_2){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_2)).setChecked(true);
//        }
//        else if(radio_sleep_hour_checked == R.id.radio_sleep_hour_3){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_3)).setChecked(true);
//        }
//        else if(radio_sleep_hour_checked == R.id.radio_sleep_hour_4){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_4)).setChecked(true);
//        }
//        else if(radio_sleep_hour_checked == R.id.radio_sleep_hour_5){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_5)).setChecked(true);
//        }
//        else if(radio_sleep_hour_checked == R.id.radio_sleep_hour_6){
//            ((RadioButton)vg.findViewById(R.id.radio_sleep_hour_6)).setChecked(true);
//        }

        if(radio_rice_sub1_checked == R.id.radio_rice_sub1_ans1){
            ((RadioButton)vg.findViewById(R.id.radio_rice_sub1_ans1)).setChecked(true);
        }
        else if(radio_rice_sub1_checked == R.id.radio_rice_sub1_ans2){
            ((RadioButton)vg.findViewById(R.id.radio_rice_sub1_ans2)).setChecked(true);
        }
        else if(radio_rice_sub1_checked == R.id.radio_rice_sub1_ans3){
            ((RadioButton)vg.findViewById(R.id.radio_rice_sub1_ans3)).setChecked(true);
        }

        if(radio_rice_sub2_checked == R.id.radio_rice_sub2_ans1){
            ((RadioButton)vg.findViewById(R.id.radio_rice_sub2_ans1)).setChecked(true);
        }
        else if(radio_rice_sub2_checked == R.id.radio_rice_sub2_ans2){
            ((RadioButton)vg.findViewById(R.id.radio_rice_sub2_ans2)).setChecked(true);
        }
//
        for (int riceID = 0; riceID < rice_checked.length; riceID++) {
            if(rice_checked[riceID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_rice" + (riceID + 1) + "_ans" + (rice_checked[riceID] + 1)))).setChecked(true);
            }
        }

        for (int riceID = 0; riceID < radio_rice_checked.length; riceID++) {
            if(radio_rice_checked[riceID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "radio_rice" + (riceID + 1) + "_ans" + (radio_rice_checked[riceID] + 1)))).setChecked(true);
            }
        }


//
//
//        if(radio_activity_week_checked == R.id.radio_activity_week_1){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_1)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_2){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_2)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_3){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_3)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_4){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_4)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_5){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_5)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_6){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_6)).setChecked(true);
//        }
//        else if(radio_activity_week_checked == R.id.radio_activity_week_7){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_7)).setChecked(true);
//        }else if(radio_activity_week_checked == R.id.radio_activity_week_8){
//            ((RadioButton)vg.findViewById(R.id.radio_activity_week_8)).setChecked(true);
//        }
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

//        if(radio_sleep_hour_checked == -1)  return false;
//
//        for (int seatID = 0; seatID < seat_checked.length; seatID++) {
//            if(seat_checked[seatID] == -1){
//                return false;
//            }
//        }
//
//        for (int actID = 0; actID < activity_checked.length; actID++) {
//            if(activity_checked[actID] == -1){
//                return false;
//            }
//        }
//
//        if(radio_activity_week_checked == -1) return false;

        return true;
    }
}
