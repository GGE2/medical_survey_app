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

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SmokeData {

    final private LinkedHashMap<String, String> mapped_data;

    // 16 ~ 20번 (본인 흡연)
    private int radio_20smoke_checked = -1;
    private String input_first_smoke = "";
    private int radio_smoke_now_year_checked = -1;
    private String input_smoke_now_year = "";
    private int radio_smoke_now_amount_checked = -1;
    private String input_smoke_now_amount = "";
    private String input_smoke_stop1 = "";
    private String input_smoke_stop2 = "";
    private String input_smoke_stop3 = "";

    // 21번 (주변 흡연)

    private int radio_other_20smoke_checked = -1;
    private String[] input_smoke_families = new String[4];
    private String[] input_smoke_family_years = new String[4];

    // 22 ~ 24번 (음주)

    private int radio_drink_checked = -1;
    private String input_drink_yes_before = "";
    private String input_drink_all_year = "";
    private int[] drink_checked = new int[5];               // 음주 횟수
    private String[] drink_amount = new String[5];          // 음주 평균 양

    // 맥주
    private String drink_amount_sub = "";

    private String[] drink_count_str = {"없다", "월 1회", "월 2~3회", "주 1회", "주 2~3회", "주 4~6회", "매일 1회", "매일 2회 이상"};
    private String[] drink_amount_str = {"되", "홉", "홉", "깡통", "잔"};
//    private String[] radio_20smoke_str = {"", "아니오", "예", "예, 지금도 피웁니다"};
//    private String[] radio_drink = {"", "아니오", "예, 지금은 안 마신다", "예, 지금도 마신다"};

    public SmokeData() {
        mapped_data = new LinkedHashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            input_smoke_families[i] = "";
            input_smoke_family_years[i] = "";
        }
        for (int i = 0; i < 5; i++) {
            drink_checked[i] = -1;
            drink_amount[i] = "";
        }
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
        RadioGroup rg_20smoke = ((Activity)nowContext).findViewById(R.id.radiogroup_20smoke);
        radio_20smoke_checked = rg_20smoke.getCheckedRadioButtonId();

        input_first_smoke = getString(((Activity)nowContext).findViewById(R.id.input_first_smoke));

        RadioGroup rg_smoke_now = ((Activity)nowContext).findViewById(R.id.radiogroup_smoke_now);
        radio_smoke_now_year_checked = rg_smoke_now.getCheckedRadioButtonId();
        input_smoke_now_year = getString(((Activity)nowContext).findViewById(R.id.input_smoke_now_year));

        RadioGroup rg_smoke_now_amount = ((Activity)nowContext).findViewById(R.id.radiogroup_smoke_now_amount);
        radio_smoke_now_amount_checked = rg_smoke_now_amount.getCheckedRadioButtonId();
        input_smoke_now_amount = getString(((Activity)nowContext).findViewById(R.id.input_smoke_now_amount));

        input_smoke_stop1 = getString(((Activity)nowContext).findViewById(R.id.input_smoke_stop1));
        input_smoke_stop2 = getString(((Activity)nowContext).findViewById(R.id.input_smoke_stop2));
        input_smoke_stop3 = getString(((Activity)nowContext).findViewById(R.id.input_smoke_stop3));

        RadioGroup rg_other_20smoke = ((Activity)nowContext).findViewById(R.id.radiogroup_other_20smoke);
        radio_other_20smoke_checked = rg_other_20smoke.getCheckedRadioButtonId();

        for (int famID = 0; famID < 4; famID++) {
            input_smoke_families[famID] = getString(((Activity)nowContext).findViewById(getResId(nowContext, "input_smoke_family" + (famID + 1))));
            input_smoke_family_years[famID] = getString(((Activity)nowContext).findViewById(getResId(nowContext, "input_smoke_family" + (famID + 1) + "_year")));
        }

        RadioGroup rg_drink = ((Activity)nowContext).findViewById(R.id.radiogroup_drink);
        radio_drink_checked = rg_drink.getCheckedRadioButtonId();
        input_drink_yes_before = getString(((Activity)nowContext).findViewById(R.id.input_drink_yes_before));
        input_drink_all_year = getString(((Activity)nowContext).findViewById(R.id.input_drink_all_year));

        mapped_data.put("흡연 여부(20갑 이상)", radio_20smoke_checked == -1 ? "" : radio_20smoke_checked == R.id.radio_20smoke_no ? "아니오" : radio_20smoke_checked == R.id.radio_20smoke_yes ? "예" : "예, 지금도 피웁니다");
        mapped_data.put("첫 흡연 나이", "만 " + input_first_smoke + "세");
        mapped_data.put("흡연 기간", radio_smoke_now_year_checked == R.id.radio_smoke_now_no ? "모르겠다" : input_smoke_now_year + "년");
        mapped_data.put("하루 흡연량", radio_smoke_now_amount_checked == R.id.radio_smoke_now_amount_no ? "모르겠다" : input_smoke_now_amount + "개피");
        mapped_data.put("금연 기간", input_smoke_stop1 + "년전 또는 " + input_smoke_stop2 + "년도 또는 " + input_smoke_stop3 + "살 때");
        mapped_data.put("주변 흡연 여부(20갑 이상)", radio_other_20smoke_checked == -1 ? "" : radio_other_20smoke_checked == R.id.radio_other_20smoke_no ? "아니오" : radio_other_20smoke_checked == R.id.radio_other_20smoke_yes ? "예" : "모르겠다");
        for (int famID = 0; famID < 4; famID++) {
            mapped_data.put("가족(누구)_" + famID, input_smoke_families[famID] + "");
            mapped_data.put("기간(년)_" + famID, input_smoke_family_years[famID] + "년");
        }
        mapped_data.put("음주 여부", radio_drink_checked == -1 ? "" : radio_drink_checked == R.id.radio_drink_no ? "아니오" : radio_drink_checked == R.id.radio_drink_yes_before ? "예, 지금은 안 마신다.(" + input_drink_yes_before + "년에 끊음)" : "예, 지금도 마신다");
        mapped_data.put("총 음주 기간", input_drink_all_year + "년");

        for (int drinkID = 0; drinkID < 5; drinkID++) {

            TextView drink_name = ((Activity)nowContext).findViewById(getResId(nowContext, "drink_name" + (drinkID + 1)));

            for (int ansID = 0; ansID < 8; ansID++) {
                CheckBox drink_ans = ((Activity)nowContext).findViewById(getResId(nowContext, "check_drink" + (drinkID + 1) + "_ans" + (ansID + 1)));

                if(drink_ans.isChecked()){
                    drink_checked[drinkID] = ansID;
                }
            }
            EditText input_drink_ans1 = ((Activity)nowContext).findViewById(getResId(nowContext, "input_drink" + (drinkID + 1) + "_ans1"));
            drink_amount[drinkID] = getString(input_drink_ans1);

            if(drinkID == 3) {
                EditText input_drink_ans2 = ((Activity)nowContext).findViewById(getResId(nowContext, "input_drink" + (drinkID + 1) + "_ans2"));
                drink_amount_sub = getString(input_drink_ans2);
            }

            mapped_data.put("1년 음주 평균 횟수(" + getString(drink_name) + ")", drink_checked[drinkID] == -1 ? "" : drink_count_str[drink_checked[drinkID]]);
            mapped_data.put("1회 평균 음주량(" + getString(drink_name) + ")", drinkID == 3 ? drink_amount[drinkID] + drink_amount_str[drinkID] + ", " + drink_amount_sub + "(큰)병" : drink_amount[drinkID] + drink_amount_str[drinkID]);
        }
    }

    public void setDataToView(ViewGroup vg) {
        if(radio_20smoke_checked == R.id.radio_20smoke_no){
            ((RadioButton)vg.findViewById(R.id.radio_20smoke_no)).setChecked(true);
        }
        else if(radio_20smoke_checked == R.id.radio_20smoke_yes) {
            ((RadioButton)vg.findViewById(R.id.radio_20smoke_yes)).setChecked(true);
        }
        else if(radio_20smoke_checked == R.id.radio_20smoke_yes_still) {
            ((RadioButton)vg.findViewById(R.id.radio_20smoke_yes_still)).setChecked(true);
        }

        ((EditText)vg.findViewById(R.id.input_first_smoke)).setText(input_first_smoke);

        if(radio_smoke_now_year_checked == R.id.radio_smoke_now_year) {
            ((RadioButton)vg.findViewById(R.id.radio_smoke_now_year)).setChecked(true);
        }
        else if(radio_smoke_now_year_checked == R.id.radio_smoke_now_no) {
            ((RadioButton)vg.findViewById(R.id.radio_smoke_now_no)).setChecked(true);
        }

        ((EditText)vg.findViewById(R.id.input_smoke_now_year)).setText(input_smoke_now_year);

        if(radio_smoke_now_amount_checked == R.id.radio_smoke_now_amount) {
            ((RadioButton)vg.findViewById(R.id.radio_smoke_now_amount)).setChecked(true);
        }
        else if(radio_smoke_now_amount_checked == R.id.radio_smoke_now_amount_no) {
            ((RadioButton)vg.findViewById(R.id.radio_smoke_now_amount_no)).setChecked(true);
        }

        ((EditText)vg.findViewById(R.id.input_smoke_now_amount)).setText(input_smoke_now_amount);

        ((EditText)vg.findViewById(R.id.input_smoke_stop1)).setText(input_smoke_stop1);
        ((EditText)vg.findViewById(R.id.input_smoke_stop2)).setText(input_smoke_stop2);
        ((EditText)vg.findViewById(R.id.input_smoke_stop3)).setText(input_smoke_stop3);

        if(radio_other_20smoke_checked == R.id.radio_other_20smoke_no) {
            ((RadioButton)vg.findViewById(R.id.radio_other_20smoke_no)).setChecked(true);
        }
        else if(radio_other_20smoke_checked == R.id.radio_other_20smoke_yes) {
            ((RadioButton)vg.findViewById(R.id.radio_other_20smoke_yes)).setChecked(true);
        }
        else if(radio_other_20smoke_checked == R.id.radio_other_20smoke_dont) {
            ((RadioButton)vg.findViewById(R.id.radio_other_20smoke_dont)).setChecked(true);
        }

        for (int famID = 0; famID < 4; famID++) {
            ((EditText)vg.findViewById(getResId(vg, "input_smoke_family" + (famID + 1)))).setText(input_smoke_families[famID]);
            ((EditText)vg.findViewById(getResId(vg, "input_smoke_family" + (famID + 1) + "_year"))).setText(input_smoke_family_years[famID]);
        }

        if(radio_drink_checked == R.id.radio_drink_no) {
            ((RadioButton)vg.findViewById(R.id.radio_drink_no)).setChecked(true);
        }
        else if(radio_drink_checked == R.id.radio_drink_yes_before) {
            ((RadioButton)vg.findViewById(R.id.radio_drink_yes_before)).setChecked(true);

        }
        else if(radio_drink_checked == R.id.radio_drink_yes_now) {
            ((RadioButton)vg.findViewById(R.id.radio_drink_yes_now)).setChecked(true);
        }

        ((EditText)vg.findViewById(R.id.input_drink_yes_before)).setText(input_drink_yes_before);
        ((EditText)vg.findViewById(R.id.input_drink_all_year)).setText(input_drink_all_year);

        for (int drinkID = 0; drinkID < 5; drinkID++) {

            if(drink_checked[drinkID] != -1){
                ((CheckBox)vg.findViewById(getResId(vg, "check_drink" + (drinkID + 1) + "_ans" + (drink_checked[drinkID] + 1)))).setChecked(true);
            }

            ((EditText)vg.findViewById(getResId(vg, "input_drink" + (drinkID + 1) + "_ans1"))).setText(drink_amount[drinkID]);

            if(drinkID == 3) {
                ((EditText)vg.findViewById(getResId(vg, "input_drink" + (drinkID + 1) + "_ans2"))).setText(drink_amount_sub);
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

        if(radio_20smoke_checked == R.id.radio_20smoke_yes || radio_20smoke_checked == R.id.radio_20smoke_yes_still){
            // 흡연 여부 "예", "예, 지금도 피웁니다" -> 17 ~ 20번 유효성 검사

            if(input_first_smoke.equals("")){
                // 처음 흡연 미기입
                return false;
            }

            if(radio_smoke_now_year_checked == R.id.radio_smoke_now_year) {
                // 지금까지 피운 기간 "____년" -> 년도 유효성 검사

                if(input_smoke_now_year.equals("")){
                    // "____년" 미기입
                    return false;
                }
            }
            else if(radio_smoke_now_year_checked == -1){
                // 미체크
                return false;
            }

            if(radio_smoke_now_amount_checked == R.id.radio_smoke_now_amount) {
                // 하루 흡연량 "____개피" -> 흡연량 유효성 검사

                if(input_smoke_now_amount.equals("")){
                    // "____년" 미기입
                    return false;
                }
            }
            else if(radio_smoke_now_amount_checked == -1){
                // 미체크
                return false;
            }


        }
        else if(radio_20smoke_checked == -1){
            // 흡연 여부 미체크
            return false;
        }

        if(radio_other_20smoke_checked == R.id.radio_other_20smoke_yes) {
            // 주변 흡연 "예" -> 주변 흡연자 정보 검사

            int famCnt = 0;

            for (int famID = 0; famID < 4; famID++) {
                if(!input_smoke_families[famID].equals("") && !input_smoke_family_years[famID].equals("")){
                    famCnt++;
                }
            }

            if(famCnt == 0)
                return false;
        }

        if(radio_drink_checked == -1){
            // 음주 여부 미체크
            return false;
        }
        else if(radio_drink_checked == R.id.radio_drink_yes_before){
            // 음주 여부 "예, 지금은 안 마신다" -> 금주 년도 검사

            if(input_drink_yes_before.equals("")){
                return false;
            }
        }

        if(input_drink_all_year.equals("")){
            // 총 음주 년도 미기입
            return false;
        }

        for (int drinkID = 0; drinkID < 5; drinkID++) {

            if(drink_checked[drinkID] == -1){
                // 평균 음주 횟수 미체크
                return false;
            }
            else if(drink_checked[drinkID] != 0) {
                // 음주 횟수 있음으로 체크 -> 평균 음주량 검사

                if(drink_amount[drinkID].equals("")) {
                    // 평균 음주량 미기입
                    return false;
                }

                if(drinkID == 3 && drink_amount_sub.equals("")) {
                    // 맥주 평균 음주량 미기입
                    return false;
                }
            }
        }

        return true;
    }
}
