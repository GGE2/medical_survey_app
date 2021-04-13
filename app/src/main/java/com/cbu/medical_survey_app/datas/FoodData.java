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

public class FoodData {

    final private LinkedHashMap<String, String> mapped_data;

//    private int radio_sleep_hour_checked = -1;
//    private int[] seat_checked = new int[5];
//    private int[] activity_checked = new int[3];
//    private int radio_activity_week_checked = -1;
//
//    private String[] seat_hour_str = {"없음", "하루 1시간 미만", "하루 1~2시간", "하루 3~4시간", "하루 5~6시간", "하루 7~10시간", "하루 11시간 이상"};
//    private String[] activity_hour_str = {"없음(30분 미만)", "주 1/2~1시간", "주 2~3시간", "주 4~6시간", "주 7~10시간", "주 21~30시간", "주 31시간 이상"};

    public FoodData() {
        mapped_data = new LinkedHashMap<String, String>();

//        Arrays.fill(seat_checked, -1);
//        Arrays.fill(activity_checked, -1);
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

//        RadioGroup rg_sleep_hour = ((Activity)nowContext).findViewById(R.id.radiogroup_sleep_hour);
//        radio_sleep_hour_checked = rg_sleep_hour.getCheckedRadioButtonId();
//
//        for (int seatID = 0; seatID < seat_checked.length; seatID++) {
//
//            TextView seat_name = ((Activity)nowContext).findViewById(getResId(nowContext, "seat_name" + (seatID + 1)));
//
//            for (int ansID = 0; ansID < 7; ansID++) {
//                CheckBox seat_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_seat" + (seatID + 1) + "_ans" + (ansID + 1)));
//
//                if(seat_ans.isChecked()){
//                    seat_checked[seatID] = ansID;
//                }
//            }
//
//            mapped_data.put("1년 동안 앉은 평균 시간 - " + getString(seat_name), seat_checked[seatID] == -1 ? "" : seat_hour_str[seat_checked[seatID]]);
//        }
//
//        for (int actID = 0; actID < activity_checked.length; actID++) {
//
//            TextView activity_name = ((Activity)nowContext).findViewById(getResId(nowContext, "activity_name" + (actID + 1)));
//
//            for (int ansID = 0; ansID < 7; ansID++) {
//                CheckBox activity_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_activity" + (actID + 1) + "_ans" + (ansID + 1)));
//
//                if(activity_ans.isChecked()){
//                    activity_checked[actID] = ansID;
//                }
//            }
//
//            mapped_data.put("1년 간 육체적 활동 주 평균 시간 - " + getString(activity_name), activity_checked[actID] == -1 ? "" : activity_hour_str[activity_checked[actID]]);
//        }
//
//        RadioGroup rg_activity_week = ((Activity)nowContext).findViewById(R.id.radiogroup_activity_week);
//        radio_activity_week_checked = rg_activity_week.getCheckedRadioButtonId();
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
//
//        for (int seatID = 0; seatID < seat_checked.length; seatID++) {
//            if(seat_checked[seatID] != -1){
//                ((CheckBox)vg.findViewById(getResId(vg, "check_seat" + (seatID + 1) + "_ans" + (seat_checked[seatID] + 1)))).setChecked(true);
//            }
//        }
//
//        for (int actID = 0; actID < activity_checked.length; actID++) {
//            if(activity_checked[actID] != -1){
//                ((CheckBox)vg.findViewById(getResId(vg, "check_activity" + (actID + 1) + "_ans" + (activity_checked[actID] + 1)))).setChecked(true);
//            }
//        }
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
