package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;


public class NormalFragment_2 extends Fragment {

    private ButtonListener normal2_prebt,normal2_nextbt;
    private Context nowContext;
    private normal_position[] nor;
    private int check_radio;

    Button pre_btn1,next_btn2;
    public NormalFragment_2(){

    }
    public NormalFragment_2(Context context) {
        normal2_prebt = new ButtonListener(context);
        normal2_nextbt = new ButtonListener(context);
        nowContext = context;
        nor = new normal_position[21];
        check_radio = -1;
    }

    public static NormalFragment_2 newInstance(){
        return new NormalFragment_2();
    }


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.normal_frag_2, container, false);

        pre_btn1 = (Button)vg.findViewById(R.id.bt_normal2_prev);
        next_btn2 = (Button)vg.findViewById(R.id.bt_normal2_next);

        pre_btn1.setOnClickListener(normal2_prebt);
        next_btn2.setOnClickListener(normal2_nextbt);



        // 프래그먼트에 데이터 세팅
        StartActivity.dtc.setDataToView(vg);

        initViews(vg);



        return vg;
    }


    private void initViews(ViewGroup vg) {
        for (int posRowID = 0; posRowID <nor.length; posRowID++) {
            RadioButton[] radio = new RadioButton[4];

            for(int posColID=0;posColID<radio.length;posColID++) {
                radio[posColID] = vg.findViewById(getResId(vg,"normal_radio_position_"+(posRowID+1)+"_"+(posColID+1)));
            }
            EditText input_year = vg.findViewById(getResId(vg,"normal_input_position_"+(posRowID+1)+"_1"));
            EditText input_age = vg.findViewById(getResId(vg,"normal_input_position_"+(posRowID+1)+"_2"));
            input_year.setInputType(InputType.TYPE_CLASS_NUMBER);
            input_age.setInputType(InputType.TYPE_CLASS_NUMBER);
            nor[posRowID] = new normal_position(radio,input_year,input_age);

        }


    }


    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }


    private class normal_position {

        protected RadioButton[] radio_bt;
        protected EditText input_year;
        protected EditText input_age;
        protected int checked =-1;


        public normal_position(RadioButton[] radio, EditText iptY, EditText iptA) {
            radio_bt = radio;
            input_year = iptY;
            input_age = iptA;




            for (int i = 0; i < radio_bt.length; i++) {
                if (radio_bt[i].isChecked()) {
                    checked = i;
                    radio_bt[i].setChecked(true);
                } else {
                    radio_bt[i].setChecked(false);
                }
                setBtListener(radio_bt[i],i);

            }
            if(checked==-1||checked==0||checked==3){
                disableInputs(input_year);
                disableInputs(input_age);
            }
            else {
                enableInputs(input_year);
                enableInputs(input_age);
            }


        }

        // 현재 줄 비활성화
        private void disableInputs(EditText text) {
            text.setText("");
            text.setClickable(false);
            text.setFocusable(false);
            text.setTextColor(getResources().getColor(R.color.text_gray));
        }


        // 현재 줄 활성화
        private void enableInputs(EditText text) {
            text.setFocusableInTouchMode(true);
            text.setClickable(true);
            text.setEnabled(true);
            text.setFocusable(true);
            text.setTextColor(getResources().getColor(R.color.text_black));
        }
        private void setBtListener(RadioButton rb,int idx){

            rb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(idx!=check_radio){
                        rb.setChecked(true);
                        if(checked!=-1)
                            radio_bt[checked].setChecked(false);
                        checked=idx;
                    }
                    else{
                        rb.setChecked(true);
                    }

                    if(checked==0 || checked==3 || checked==-1){
                        disableInputs(input_year);
                        disableInputs(input_age);
                    }

                    else {
                        enableInputs(input_year);
                        enableInputs(input_age);
                    }

                }

            });

        }
    }


}







