package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class FoodFragment_1 extends Fragment {

    private ButtonListener btl;
//
//    private table[] seats;
//    private table[] activities;

    public FoodFragment_1() {
    }

    public FoodFragment_1(Context context) {
        btl = new ButtonListener(context);
//        seats = new table[5];
//        activities = new table[3];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_1, container, false);

//        ConstraintLayout content = vg.findViewById(R.id.survey_content);
//        ConstraintLayout warning = vg.findViewById(R.id.survey_warning);
//
//        System.out.println(content);
//        System.out.println(warning);
//
//        ConstraintSet cs = new ConstraintSet();
//        cs.clone(content);
//
//        cs.connect(content.getId(), ConstraintSet.TOP, warning.getId(), ConstraintSet.BOTTOM, 0);
//        cs.applyTo(content);


//        Button bt_smoke_prev = (Button) vg.findViewById(R.id.bt_sleep_prev);
//        Button bt_smoke_next = (Button) vg.findViewById(R.id.bt_sleep_next);
//        bt_smoke_prev.setOnClickListener(btl);
//        bt_smoke_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
//        StartActivity.dtc.setDataToView(vg);

//        initViews(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {

//        for (int seatID = 0; seatID < seats.length; seatID++) {
//            CheckBox[] cbs = new CheckBox[7];
//
//            for (int ansID = 0; ansID < cbs.length; ansID++) {
//                cbs[ansID] = vg.findViewById(getResId(vg, "check_seat" + (seatID + 1) + "_ans" + (ansID + 1)));
//            }
//            seats[seatID] = new table(cbs);
//        }
//
//        for (int actID = 0; actID < activities.length; actID++) {
//            CheckBox[] cbs = new CheckBox[7];
//
//            for (int ansID = 0; ansID < cbs.length; ansID++) {
//                cbs[ansID] = vg.findViewById(getResId(vg, "check_activity" + (actID + 1) + "_ans" + (ansID + 1)));
//            }
//            activities[actID] = new table(cbs);
//        }
    }

    // 문자열 값으로 id를 얻어옴
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }

//    private class table {
//
//        protected CheckBox[] check_bts;
//        protected int checked = -1;
//
//        public table(CheckBox[] cbs) {
//            check_bts = cbs;
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
//                }
//            });
//        }
//    }
}
