package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class SleepFragment extends Fragment {
    //
    private ButtonListener btl;
//    private RadioGroup radiogroup_20smoke;
//    private EditText input_first_smoke;
//    private RadioGroup radiogroup_smoke_now;
//    private EditText input_smoke_now_year;
//    private RadioGroup radiogroup_smoke_now_amount;
//    private EditText input_smoke_now_amount;
//    private EditText input_smoke_stop1;
//    private EditText input_smoke_stop2;
//    private EditText input_smoke_stop3;
//    private RadioGroup radiogroup_other_20smoke;
//    private EditText[] input_smoke_families;
//    private EditText[] input_smoke_family_years;
//    private RadioGroup radiogroup_drink;
//    private EditText input_drink_yes_before;
//    private drink[] drinks;

    public SleepFragment() {
    }

    public SleepFragment(Context context) {
        btl = new ButtonListener(context);
//        input_smoke_families = new EditText[4];
//        input_smoke_family_years = new EditText[4];
//        drinks = new drink[5];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.sleep_frag, container, false);

        Button bt_smoke_prev = (Button) vg.findViewById(R.id.bt_sleep_prev);
        Button bt_smoke_next = (Button) vg.findViewById(R.id.bt_sleep_next);
        bt_smoke_prev.setOnClickListener(btl);
        bt_smoke_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
//        StartActivity.dtc.setDataToView(vg);

//        initViews(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {
//        // 16 ~ 20번
//        radiogroup_20smoke = vg.findViewById(R.id.radiogroup_20smoke);
//        input_first_smoke = vg.findViewById(R.id.input_first_smoke);
//        radiogroup_smoke_now = vg.findViewById(R.id.radiogroup_smoke_now);
//        input_smoke_now_year = vg.findViewById(R.id.input_smoke_now_year);
//        radiogroup_smoke_now_amount = vg.findViewById(R.id.radiogroup_smoke_now_amount);
//        input_smoke_now_amount = vg.findViewById(R.id.input_smoke_now_amount);
//        input_smoke_stop1 = vg.findViewById(R.id.input_smoke_stop1);
//        input_smoke_stop2 = vg.findViewById(R.id.input_smoke_stop2);
//        input_smoke_stop3 = vg.findViewById(R.id.input_smoke_stop3);
//
//        if(radiogroup_smoke_now.getCheckedRadioButtonId() == R.id.radio_smoke_now_year){
//            enableEditText(input_smoke_now_year);
//        }
//        else{
//            disableEditText(input_smoke_now_year);
//        }
//
//        radiogroup_smoke_now.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.radio_smoke_now_year){
//                    enableEditText(input_smoke_now_year);
//                }
//                else{
//                    disableEditText(input_smoke_now_year);
//                }
//            }
//        });
//
//
//
//        if(radiogroup_smoke_now_amount.getCheckedRadioButtonId() == R.id.radio_smoke_now_amount){
//            enableEditText(input_smoke_now_amount);
//        }
//        else{
//            disableEditText(input_smoke_now_amount);
//        }
//
//        radiogroup_smoke_now_amount.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.radio_smoke_now_amount){
//                    enableEditText(input_smoke_now_amount);
//                }
//                else{
//                    disableEditText(input_smoke_now_amount);
//                }
//            }
//        });
//
//        smoke20Handler(radiogroup_20smoke, radiogroup_20smoke.getCheckedRadioButtonId());
//
//        radiogroup_20smoke.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                smoke20Handler(group, checkedId);
//            }
//        });
//
//        // 21번
//        radiogroup_other_20smoke = vg.findViewById(R.id.radiogroup_other_20smoke);
//
//        for (int famID = 0; famID < 4; famID++) {
//            input_smoke_families[famID] = vg.findViewById(getResId(vg, "input_smoke_family" + (famID + 1)));
//            input_smoke_family_years[famID] = vg.findViewById(getResId(vg, "input_smoke_family" + (famID + 1) + "_year"));
//        }
//
//        if(radiogroup_other_20smoke.getCheckedRadioButtonId() == R.id.radio_other_20smoke_yes) {
//            enableFamily();
//        }
//        else {
//            disableFamily();
//        }
//
//        radiogroup_other_20smoke.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.radio_other_20smoke_yes) {
//                    enableFamily();
//                }
//                else {
//                    disableFamily();
//                }
//            }
//        });
//
//        radiogroup_drink = vg.findViewById(R.id.radiogroup_drink);
//        input_drink_yes_before = vg.findViewById(R.id.input_drink_yes_before);
//
//        if(radiogroup_drink.getCheckedRadioButtonId() == R.id.radio_drink_yes_before) {
//            enableEditText(input_drink_yes_before);
//        }
//        else{
//            disableEditText(input_drink_yes_before);
//        }
//
//        radiogroup_drink.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.radio_drink_yes_before) {
//                    enableEditText(input_drink_yes_before);
//                }
//                else{
//                    disableEditText(input_drink_yes_before);
//                }
//            }
//        });
//
//        for (int drinkID = 0; drinkID < 5; drinkID++) {
//            CheckBox[] cbs = new CheckBox[8];
//
//            for (int ansID = 0; ansID < 8; ansID++) {
//                cbs[ansID] = vg.findViewById(getResId(vg, "check_drink" + (drinkID + 1) + "_ans" + (ansID + 1)));
//            }
//
//            if(drinkID == 3) {
//                EditText input_drink_ans1 = vg.findViewById(getResId(vg, "input_drink" + (drinkID + 1) + "_ans1"));
//                EditText input_drink_ans2 = vg.findViewById(getResId(vg, "input_drink" + (drinkID + 1) + "_ans2"));
//
//                drinks[drinkID] = new drink(cbs, input_drink_ans1, input_drink_ans2);
//            }
//            else{
//                EditText input_drink_ans1 = vg.findViewById(getResId(vg, "input_drink" + (drinkID + 1) + "_ans1"));
//
//                drinks[drinkID] = new drink(cbs, input_drink_ans1);
//            }
//        }
    }

//    private void disableEditText(EditText edt) {
//        edt.setFocusable(false);
//        edt.setClickable(false);
//        edt.setTextColor(getResources().getColor(R.color.text_gray));
//    }
//
//    private void enableEditText(EditText edt) {
//        edt.setFocusableInTouchMode(true);
//        edt.setFocusable(true);
//        edt.setTextColor(getResources().getColor(R.color.text_black));
//    }
//
//    private void disableRadioGroup(RadioGroup rg) {
//        for (int i = 0; i < rg.getChildCount(); i++) {
//            rg.getChildAt(i).setEnabled(false);
//        }
//    }
//
//    private void enableRadioGroup(RadioGroup rg) {
//        for (int i = 0; i < rg.getChildCount(); i++) {
//            rg.getChildAt(i).setEnabled(true);
//        }
//    }
//
//    private void disableSmokes() {
//        disableEditText(input_first_smoke);
//        disableEditText(input_smoke_now_year);
//        disableEditText(input_smoke_now_amount);
//        disableEditText(input_smoke_stop1);
//        disableEditText(input_smoke_stop2);
//        disableEditText(input_smoke_stop3);
//        disableRadioGroup(radiogroup_smoke_now);
//        disableRadioGroup(radiogroup_smoke_now_amount);
//    }
//
//    private void enableSmokes() {
//        enableEditText(input_first_smoke);
//        if(radiogroup_smoke_now_amount.getCheckedRadioButtonId() == R.id.radio_smoke_now_amount){
//            enableEditText(input_smoke_now_amount);
//        }
//        if(radiogroup_smoke_now.getCheckedRadioButtonId() == R.id.radio_smoke_now_year){
//            enableEditText(input_smoke_now_year);
//        }
//        enableEditText(input_smoke_stop1);
//        enableEditText(input_smoke_stop2);
//        enableEditText(input_smoke_stop3);
//        enableRadioGroup(radiogroup_smoke_now);
//        enableRadioGroup(radiogroup_smoke_now_amount);
//    }
//
//    private void disableFamily() {
//        for (int famID = 0; famID < 4; famID++) {
//            disableEditText(input_smoke_families[famID]);
//            disableEditText(input_smoke_family_years[famID]);
//        }
//    }
//
//    private void enableFamily() {
//        for (int famID = 0; famID < 4; famID++) {
//            enableEditText(input_smoke_families[famID]);
//            enableEditText(input_smoke_family_years[famID]);
//        }
//    }
//
//    private void smoke20Handler(RadioGroup rg, int checked) {
//        switch (checked){
//            case -1:
//                disableSmokes();
//                break;
//            case R.id.radio_20smoke_no:
//                rg.check(checked);
//                disableSmokes();
//                break;
//            case R.id.radio_20smoke_yes:
//            case R.id.radio_20smoke_yes_still:
//                rg.check(checked);
//                enableSmokes();
//                break;
//            default:
//                break;
//        }
//    }

    // 문자열 값으로 id를 얻어옴
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }

//    private class seated {

//        protected CheckBox[] check_bts;
//        protected EditText input_drink_ans1;
//        protected EditText input_drink_ans2;
//        protected int checked = -1;
//
//        public seated(CheckBox[] cbs, EditText ipt1) {
//            check_bts = cbs;
//            input_drink_ans1 = ipt1;
//            input_drink_ans2 = null;
//
//            for (int i = 0; i < check_bts.length; i++) {
//                if(check_bts[i].isChecked()){
//                    checked = i;
//                    check_bts[i].setChecked(true);
//                }
//                else{
//                    check_bts[i].setChecked(false);
//                }
//                setBtListener(check_bts[i], i);
//            }
//
//            //없다, 미선택 시
//            if(checked == 0 || checked == -1) {
//                disableEditText(input_drink_ans1);
//            }
//            else{
//                enableEditText(input_drink_ans1);
//            }
//        }
//
//        public seated(CheckBox[] cbs, EditText ipt1, EditText ipt2) {
//            check_bts = cbs;
//            input_drink_ans1 = ipt1;
//            input_drink_ans2 = ipt2;
//
//            for (int i = 0; i < check_bts.length; i++) {
//                if(check_bts[i].isChecked()){
//                    checked = i;
//                    check_bts[i].setChecked(true);
//                }
//                else{
//                    check_bts[i].setChecked(false);
//                }
//                setBtListener(check_bts[i], i);
//            }
//
//            //없다, 미선택 시
//            if(checked == 0 || checked == -1) {
//                disableEditText(input_drink_ans1);
//                disableEditText(input_drink_ans2);
//            }
//            else{
//                enableEditText(input_drink_ans1);
//                enableEditText(input_drink_ans2);
//            }
//        }
//
//        private void setBtListener(CheckBox cb, int idx) {
//            cb.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(idx != checked) {
//                        cb.setChecked(true);
//                        if(checked != -1)
//                            check_bts[checked].setChecked(false);
//                        checked = idx;
//                    }
//                    else{
//                        cb.setChecked(true);
//                    }
//
//                    //없다, 미선택 시
//                    if(checked == 0 || checked == -1) {
//                        disableEditText(input_drink_ans1);
//                        if(input_drink_ans2 != null)
//                            disableEditText(input_drink_ans2);
//                    }
//                    else{
//                        enableEditText(input_drink_ans1);
//                        if(input_drink_ans2 != null)
//                            enableEditText(input_drink_ans2);
//                    }
//                }
//            });
//        }
//    }
}

