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

public class JobFragment extends Fragment {

    private int radio_checked;

    private ButtonListener btl;
    private Context nowContext;
    private position[] positions;
    private production[] productions;
//    private RadioButton radio_mainjob_no;
//    private RadioButton radio_mainjob_yes;

    public JobFragment() {
//        check_productions = new CheckBox[24];
//        radio_mainjob_no = null;
//        radio_mainjob_yes = null;
    }

    public JobFragment(Context context) {
        btl = new ButtonListener(context);
        nowContext = context;
        positions = new position[11];
        productions = new production[24];
        radio_checked = -1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.job_frag, container, false);

        Button bt_job_next = (Button) vg.findViewById(R.id.bt_job_next);
        bt_job_next.setOnClickListener(btl);

        initViews(vg);
//
//        // 프래그먼트에 데이터 세팅
//        MainActivity.dtc.setDataToView(vg);

        return vg;
    }

    private void initViews(ViewGroup vg) {
        for (int posID = 0; posID < 11; posID++) {
            RadioButton radio_position = vg.findViewById(getResId(vg, "radio_position_" + (posID + 1)));
            EditText input_position = vg.findViewById(getResId(vg, "input_position_" + (posID + 1)));
            EditText input_position_year = vg.findViewById(getResId(vg, "input_position_year_" + (posID + 1)));



            positions[posID] = new position(radio_position, input_position, input_position_year, posID);
        }

        for (int proID = 0; proID < 24; proID++) {
            CheckBox check_production = vg.findViewById(getResId(vg, "check_production_" + (proID + 1)));
            EditText input_production_year = vg.findViewById(getResId(vg, "input_production_year_" + (proID + 1)));



            productions[proID] = new production(check_production, input_production_year, proID);
        }


    }

    // 문자열 값으로 id를 얻어옴
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private class position {

        protected RadioButton radio_bt;
        protected EditText input;
        protected EditText input_year;
        protected int index;

        public position(RadioButton rb, EditText ipt, EditText ipt_y, int idx) {
            radio_bt = rb;
            input = ipt;
            input_year = ipt_y;
            index = idx;

            disableInputs();

            radio_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(radio_checked != index){
                        if(radio_checked != -1){
                            positions[radio_checked].disableInputs();
                        }
                        radio_checked = index;
                        enableInputs();
                        System.out.println("여기");
                    }
                }
            });
        }

        private void disableInputs() {
            input.setFocusable(false);
            input.setClickable(false);
            input.setTextColor(getResources().getColor(R.color.text_gray));

            input_year.setFocusable(false);
            input_year.setClickable(false);
            input_year.setTextColor(getResources().getColor(R.color.text_gray));

            radio_bt.setChecked(false);
        }

        private void enableInputs() {
            input.setFocusableInTouchMode(true);
            input.setFocusable(true);
            input.setTextColor(getResources().getColor(R.color.text_black));

            input_year.setFocusableInTouchMode(true);
            input_year.setFocusable(true);
            input_year.setTextColor(getResources().getColor(R.color.text_black));

            radio_bt.setChecked(true);
        }
    }

    private class production {

        protected CheckBox check_bt;
        protected EditText input_year;
        protected int index;

        public production(CheckBox rb, EditText ipt_y, int idx) {
            check_bt = rb;
            input_year = ipt_y;
            index = idx;
        }
    }

}

