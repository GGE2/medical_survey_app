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

public class FoodFragment_5 extends Fragment {

    private ButtonListener btl;

    private table[] kimchis;
    private table[] kimchis_radio;

    public FoodFragment_5() {
    }

    public FoodFragment_5(Context context) {
        btl = new ButtonListener(context);
        kimchis = new table[7];
        kimchis_radio = new table[7];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_5, container, false);

        Button bt_food_5_prev = (Button) vg.findViewById(R.id.bt_food_5_prev);
        Button bt_food_5_next = (Button) vg.findViewById(R.id.bt_food_5_next);
        bt_food_5_prev.setOnClickListener(btl);
        bt_food_5_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
        StartActivity.dtc.setDataToView(vg);

        initViews(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {

        for (int kimchiID = 0; kimchiID < kimchis.length; kimchiID++) {
            CheckBox[] cbs = new CheckBox[9];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "check_kimchi" + (kimchiID + 1) + "_ans" + (ansID + 1)));
            }
            kimchis[kimchiID] = new table(cbs);
        }

        for (int kimchiID = 0; kimchiID < kimchis_radio.length; kimchiID++) {
            CheckBox[] cbs = new CheckBox[3];

            for (int ansID = 0; ansID < cbs.length; ansID++) {
                cbs[ansID] = vg.findViewById(getResId(vg, "radio_kimchi" + (kimchiID + 1) + "_ans" + (ansID + 1)));
            }
            kimchis_radio[kimchiID] = new table(cbs);
        }
    }

    // 문자열 값으로 id를 얻어옴
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }

    private class table {

        protected CheckBox[] check_bts;
        protected int checked = -1;

        public table(CheckBox[] cbs) {
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
