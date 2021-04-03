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

import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class SmokeFragment extends Fragment {

//    private int radio_checked;
//    private boolean[] production_checked;
//
    private ButtonListener btl;
//    private position[] positions;
//    private production[] productions;
//    private RadioButton radio_mainjob_no;
//    private RadioButton radio_mainjob_yes;
//    private EditText input_mainjob;
//    private EditText input_mainjob_year;

    public SmokeFragment() {
    }

    public SmokeFragment(Context context) {
        btl = new ButtonListener(context);
//        positions = new position[11];
//        productions = new production[24];
//        radio_checked = -1;
//        production_checked = new boolean[24];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.smoke_frag, container, false);

        Button bt_smoke_prev = (Button) vg.findViewById(R.id.bt_smoke_prev);
        Button bt_smoke_next = (Button) vg.findViewById(R.id.bt_smoke_next);
        bt_smoke_prev.setOnClickListener(btl);
        bt_smoke_next.setOnClickListener(btl);

        // 프래그먼트에 데이터 세팅
//        StartActivity.dtc.setDataToView(vg);

//        initViews(vg);

        return vg;
    }

//    private void initViews(ViewGroup vg) {
//        for (int posID = 0; posID < 11; posID++) {
//            RadioButton radio_position = vg.findViewById(getResId(vg, "radio_position_" + (posID + 1)));
//            EditText input_position = vg.findViewById(getResId(vg, "input_position_" + (posID + 1)));
//            EditText input_position_year = vg.findViewById(getResId(vg, "input_position_year_" + (posID + 1)));
//
//            positions[posID] = new position(radio_position, input_position, input_position_year, posID);
//        }
//
//        for (int proID = 0; proID < 24; proID++) {
//            CheckBox check_production = vg.findViewById(getResId(vg, "check_production_" + (proID + 1)));
//            EditText input_production_year = vg.findViewById(getResId(vg, "input_production_year_" + (proID + 1)));
//
//            if(proID < 23)
//                productions[proID] = new production(check_production, input_production_year, proID);
//            else {
//                EditText input_production_other = vg.findViewById(R.id.input_production_other);
//                productions[proID] = new production(check_production, input_production_other, input_production_year, proID);
//            }
//        }
//
//        radio_mainjob_no = vg.findViewById(R.id.radio_mainjob_no);
//        radio_mainjob_yes = vg.findViewById(R.id.radio_mainjob_yes);
//
//        input_mainjob = vg.findViewById(R.id.input_mainjob);
//        input_mainjob_year = vg.findViewById(R.id.input_mainjob_year);
//
//        if(!radio_mainjob_no.isChecked()){
//            // 아니오에 체크되어 있지 않다면 -> 비활성화
//            input_mainjob.setFocusable(false);
//            input_mainjob.setClickable(false);
//            input_mainjob.setTextColor(getResources().getColor(R.color.text_gray));
//
//            input_mainjob_year.setFocusable(false);
//            input_mainjob_year.setClickable(false);
//            input_mainjob_year.setTextColor(getResources().getColor(R.color.text_gray));
//        }
//
//        radio_mainjob_no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                input_mainjob.setFocusable(true);
//                input_mainjob.setFocusableInTouchMode(true);
//                input_mainjob.setTextColor(getResources().getColor(R.color.text_black));
//
//                input_mainjob_year.setFocusable(true);
//                input_mainjob_year.setFocusableInTouchMode(true);
//                input_mainjob_year.setTextColor(getResources().getColor(R.color.text_black));
//            }
//        });
//
//        radio_mainjob_yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                input_mainjob.setFocusable(false);
//                input_mainjob.setClickable(false);
//                input_mainjob.setTextColor(getResources().getColor(R.color.text_gray));
//
//                input_mainjob_year.setFocusable(false);
//                input_mainjob_year.setClickable(false);
//                input_mainjob_year.setTextColor(getResources().getColor(R.color.text_gray));
//            }
//        });
//
//    }
//
//    // 문자열 값으로 id를 얻어옴
//    private int getResId(ViewGroup vg, String id) {
//        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
//        return getID;
//    }
//
//    private class position {
//
//        protected RadioButton radio_bt;
//        protected EditText input;
//        protected EditText input_year;
//        protected int index;
//
//        public position(RadioButton rb, EditText ipt, EditText ipt_y, int idx) {
//            radio_bt = rb;
//            input = ipt;
//            input_year = ipt_y;
//            index = idx;
//
//            if(!rb.isChecked())
//                disableInputs();
//            else{
//                // 라디오 버튼이 이미 눌려 있다면
//                radio_checked = index;
//            }
//
//            radio_bt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(radio_checked != index){
//                        if(radio_checked != -1){
//                            positions[radio_checked].disableInputs();
//                        }
//                        radio_checked = index;
//                        enableInputs();
//                    }
//                }
//            });
//        }
//
//        // 현재 줄 비활성화
//        private void disableInputs() {
//            input.setFocusable(false);
//            input.setClickable(false);
//            input.setTextColor(getResources().getColor(R.color.text_gray));
//
//            input_year.setFocusable(false);
//            input_year.setClickable(false);
//            input_year.setTextColor(getResources().getColor(R.color.text_gray));
//
//            radio_bt.setChecked(false);
//        }
//
//        // 현재 줄 활성화
//        private void enableInputs() {
//            input.setFocusableInTouchMode(true);
//            input.setFocusable(true);
//            input.setTextColor(getResources().getColor(R.color.text_black));
//
//            input_year.setFocusableInTouchMode(true);
//            input_year.setFocusable(true);
//            input_year.setTextColor(getResources().getColor(R.color.text_black));
//
//            radio_bt.setChecked(true);
//        }
//    }
//
//    private class production {
//
//        protected CheckBox check_bt;
//        protected EditText input_other;
//        protected EditText input_year;
//        protected int index;
//
//        public production(CheckBox cb, EditText ipt_y, int idx) {
//            check_bt = cb;
//            input_other = null;
//            input_year = ipt_y;
//            index = idx;
//
//            if(!cb.isChecked())
//                disableInputs();
//            setBtListener();
//        }
//
//        public production(CheckBox cb, EditText ipt_other, EditText ipt_y, int idx) {
//            check_bt = cb;
//            input_other = ipt_other;
//            input_year = ipt_y;
//            index = idx;
//
//            if(!cb.isChecked())
//                disableInputs();
//            setBtListener();
//        }
//
//        private void setBtListener() {
//            check_bt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(production_checked[index]){
//                        disableInputs();
//                    }
//                    else{
//                        enableInputs();
//                    }
//                    production_checked[index] = !production_checked[index];
//                }
//            });
//        }
//
//        // 현재 줄 비활성화
//        private void disableInputs() {
//            if(index == 23) {
//                input_other.setFocusable(false);
//                input_other.setClickable(false);
//                input_other.setTextColor(getResources().getColor(R.color.text_gray));
//            }
//
//            input_year.setFocusable(false);
//            input_year.setClickable(false);
//            input_year.setTextColor(getResources().getColor(R.color.text_gray));
//        }
//
//        // 현재 줄 활성화
//        private void enableInputs() {
//            if(index == 23) {
//                input_other.setFocusableInTouchMode(true);
//                input_other.setFocusable(true);
//                input_other.setTextColor(getResources().getColor(R.color.text_black));
//            }
//
//            input_year.setFocusableInTouchMode(true);
//            input_year.setFocusable(true);
//            input_year.setTextColor(getResources().getColor(R.color.text_black));
//        }
//    }

}

