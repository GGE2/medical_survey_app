package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class FoodFragment_3 extends Fragment {

    private ButtonListener btl;

    private table1[] peanuts;
    private table2[] peanuts_radio;

    public FoodFragment_3() {
    }

    public FoodFragment_3(Context context) {
        btl = new ButtonListener(context);
        peanuts = new table1[8];
        peanuts_radio = new table2[8];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_3, container, false);

        Button bt_food_3_prev = (Button) vg.findViewById(R.id.bt_food_3_prev);
        Button bt_food_3_next = (Button) vg.findViewById(R.id.bt_food_3_next);
        bt_food_3_prev.setOnClickListener(btl);
        bt_food_3_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
        StartActivity.dtc.setDataToView(vg);

        initViews(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {

        for (int peanutID = 0; peanutID < peanuts_radio.length; peanutID++) {
            CheckBox[] cbs = new CheckBox[3];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "radio_peanut" + (peanutID + 1) + "_ans" + (ansID + 1)));
            }
            peanuts_radio[peanutID] = new table2(cbs);
        }

        for (int peanutID = 0; peanutID < peanuts.length; peanutID++) {
            CheckBox[] cbs = new CheckBox[9];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "check_peanut" + (peanutID + 1) + "_ans" + (ansID + 1)));
            }
            peanuts[peanutID] = new table1(cbs, peanutID);
        }
    }

    private void disabledChecked(CheckBox cb){
        cb.setChecked(false);
        cb.setEnabled(false);
    }

    private void enabledChecked(CheckBox cb){
        cb.setEnabled(true);
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
                for (CheckBox cb : peanuts_radio[index].check_bts){
                    disabledChecked(cb);
                }
            }
            else{
                for (CheckBox cb : peanuts_radio[index].check_bts){
                    enabledChecked(cb);
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
                        for (CheckBox cb : peanuts_radio[index].check_bts){
                            disabledChecked(cb);
                        }
                    }
                    else{
                        for (CheckBox cb : peanuts_radio[index].check_bts){
                            enabledChecked(cb);
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
    }
}
