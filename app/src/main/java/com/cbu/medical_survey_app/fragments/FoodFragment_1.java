package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class FoodFragment_1 extends Fragment {

    private ButtonListener btl;

    private table1[] rices;
    private table2[] rices_radio;
    private RadioGroup radiogroup_rice_sub1;
    private RadioGroup radiogroup_rice_sub2;

    public FoodFragment_1() {
    }

    public FoodFragment_1(Context context) {
        btl = new ButtonListener(context);
        rices = new table1[7];
        rices_radio = new table2[7];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_1, container, false);

        Button bt_food_1_prev = (Button) vg.findViewById(R.id.bt_food_1_prev);
        Button bt_food_1_next = (Button) vg.findViewById(R.id.bt_food_1_next);
        bt_food_1_prev.setOnClickListener(btl);
        bt_food_1_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
        StartActivity.dtc.setDataToView(vg);

        initViews(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {

        radiogroup_rice_sub1 = vg.findViewById(R.id.radiogroup_rice_sub1);
        radiogroup_rice_sub2 = vg.findViewById(R.id.radiogroup_rice_sub2);

        riceHandler(radiogroup_rice_sub1, radiogroup_rice_sub1.getCheckedRadioButtonId());

        radiogroup_rice_sub1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                riceHandler(group, checkedId);
            }
        });

        for (int riceID = 0; riceID < rices_radio.length; riceID++) {
            CheckBox[] cbs = new CheckBox[3];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "radio_rice" + (riceID + 1) + "_ans" + (ansID + 1)));
            }
            rices_radio[riceID] = new table2(cbs);
        }

        for (int riceID = 0; riceID < rices.length; riceID++) {
            CheckBox[] cbs = new CheckBox[9];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "check_rice" + (riceID + 1) + "_ans" + (ansID + 1)));
            }
            rices[riceID] = new table1(cbs, riceID);
        }
    }

    public void riceHandler(RadioGroup rg, int checked) {
        switch (checked){
            case -1:
            case R.id.radio_rice_sub1_ans1:
                disableRadioGroup(radiogroup_rice_sub2);
                break;
            default:
                rg.check(checked);
                enableRadioGroup(radiogroup_rice_sub2);
                break;
        }
    }

    private void disabledChecked(CheckBox cb){
        cb.setChecked(false);
        cb.setEnabled(false);
    }

    private void enabledChecked(CheckBox cb){
        cb.setEnabled(true);
    }

    private void disableRadioGroup(RadioGroup rg) {
        for (int i = 0; i < rg.getChildCount(); i++) {
            rg.getChildAt(i).setEnabled(false);
            rg.check(-1);
        }
    }

    private void enableRadioGroup(RadioGroup rg) {
        for (int i = 0; i < rg.getChildCount(); i++) {
            rg.getChildAt(i).setEnabled(true);
        }
    }

    // 문자열 값으로 id를 얻어옴
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }

    private class table1 {

        protected CheckBox[] check_bts;
        protected int checked = -1;
        protected int index;

        public table1(CheckBox[] cbs, int index) {
            check_bts = cbs;
            this.index = index;

            for (int i = 0; i < check_bts.length; i++) {
                if(check_bts[i].isChecked()){
                    checked = i;
                    check_bts[i].setChecked(true);
                }
                else{
                    check_bts[i].setChecked(false);
                }
                setBtListener(check_bts[i], i);
            }

            if(checked == 0 || checked == -1) {
                for (CheckBox cb : rices_radio[index].check_bts){
                    disabledChecked(cb);
                }
                if(index == 0) {
                    disableRadioGroup(radiogroup_rice_sub1);
                    disableRadioGroup(radiogroup_rice_sub2);
                }
            }
            else{
                for (CheckBox cb : rices_radio[index].check_bts){
                    enabledChecked(cb);
                }
                if(index == 0) {
                    enableRadioGroup(radiogroup_rice_sub1);
                    enableRadioGroup(radiogroup_rice_sub2);
                }
            }
        }

        private void setBtListener(CheckBox cb, int idx) {
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(idx != checked) {
                        cb.setChecked(true);
                        if(checked != -1)
                            check_bts[checked].setChecked(false);
                        checked = idx;
                    }
                    else{
                        cb.setChecked(true);
                    }

                    if(checked == 0 || checked == -1) {
                        for (CheckBox cb : rices_radio[index].check_bts){
                            disabledChecked(cb);
                        }
                        if(index == 0) {
                            disableRadioGroup(radiogroup_rice_sub1);
                            disableRadioGroup(radiogroup_rice_sub2);
                        }
                    }
                    else{
                        for (CheckBox cb : rices_radio[index].check_bts){
                            enabledChecked(cb);
                        }
                        if(index == 0) {
                            enableRadioGroup(radiogroup_rice_sub1);
                            enableRadioGroup(radiogroup_rice_sub2);
                        }
                    }
                }
            });
        }
    }

    private class table2 {

        protected CheckBox[] check_bts;
        protected int checked = -1;

        public table2(CheckBox[] cbs) {
            check_bts = cbs;

            for (int i = 0; i < check_bts.length; i++) {
                if(check_bts[i].isChecked()){
                    checked = i;
                    check_bts[i].setChecked(true);
                }
                else{
                    check_bts[i].setChecked(false);
                }
                setBtListener(check_bts[i], i);
            }
        }

        private void setBtListener(CheckBox cb, int idx) {
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(idx != checked) {
                        cb.setChecked(true);
                        if(checked != -1)
                            check_bts[checked].setChecked(false);
                        checked = idx;
                    }
                    else{
                        cb.setChecked(true);
                    }

                }
            });
        }

        public void setEnable() {
            for (int i = 0; i < check_bts.length; i++) {
                if(!check_bts[i].isChecked())
                    check_bts[i].setEnabled(true);
            }
        }

        public void setDisable(){
            for (int i = 0; i < check_bts.length; i++) {
                    check_bts[i].setEnabled(false);
            }
        }
    }
}
