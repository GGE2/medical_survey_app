package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

import org.apache.poi.ss.usermodel.Row;

public class NormalFragment_4 extends Fragment {
    private Context nowContext;
    private ray[] Ray;
    private eatMedi[] EM;
    ButtonListener bt1,bt2;
    Button normal4_pre_bt,normal4_next_bt;


    public NormalFragment_4(Context context) {

        nowContext = context;
        bt1 = new ButtonListener(context);
        bt2 = new ButtonListener(context);
        Ray  = new ray[4];
        EM = new eatMedi[9];

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.normal_frag_4, container, false);

        normal4_pre_bt = vg.findViewById(R.id.bt_normal4_prev);
        normal4_next_bt = vg.findViewById(R.id.bt_normal4_next);

        normal4_pre_bt.setOnClickListener(bt1);
        normal4_next_bt.setOnClickListener(bt2);




        StartActivity.dtc.setDataToView(vg);

        initView(vg);

        return vg;
    }

    private void initView(ViewGroup vg){

        //14번 치료 검사
        for(int RowID=0;RowID<4;RowID++){
            RadioButton[] rb = new RadioButton[10];
            for(int ColID=0;ColID<10;ColID++){
                rb[ColID] = vg.findViewById(getResId(vg,"normal4_radio_position_"+(RowID+1)+"_"+(ColID+1)));
            }

            Ray[RowID] = new ray(rb);
        }
        //15번
        for(int RowID=0;RowID<6;RowID++){
            RadioButton[] rb1 = new RadioButton[6];
            RadioButton[] rb2 = new RadioButton[3];
            for(int ColID=0;ColID<6;ColID++){
                rb1[ColID] = vg.findViewById(getResId(vg,"medi_eat_radio"+(RowID+1)+"_"+(ColID+1)));
            }
            for(int ColID=0;ColID<3;ColID++){
                rb2[ColID] = vg.findViewById(getResId(vg, "medi_year_radio" + (RowID + 1) + "_"+(ColID+1)));
            }

            EM[RowID] = new eatMedi(rb1,rb2);
        }




    }
    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }
    //라디오 버튼 비활성화
    private void disableRadio(RadioButton rb) {
        rb.setFocusable(false);
        rb.setChecked(false);
    }
    public void disableRadio_no_click(RadioButton rb) {
        rb.setFocusable(false);
        rb.setClickable(false);
        rb.setChecked(false);
        rb.setEnabled(false);
        rb.setTextColor(getResources().getColor(R.color.text_gray));
    }
    //라디오 버튼 활성화
    private void enableRadio(RadioButton rb) {
        rb.setFocusable(true);
        rb.setClickable(true);
        rb.setEnabled(true);
        rb.setTextColor(getResources().getColor(R.color.text_black));
    }

    private class eatMedi{
        protected RadioButton[] erb;
        protected RadioButton[] yrb;
        protected int checked=-1;
        protected int ck=-1;


        public eatMedi(RadioButton[] rb1,RadioButton[] rb2){
            erb = rb1;
            yrb = rb2;


            for(int i=0;i<erb.length;i++){
                if(erb[i].isChecked()){
                    erb[i].setChecked(true);
                    checked = i;
                }
                else
                    erb[i].setChecked(false);
                setBtListener(erb[i],i);

            }
            if(checked==-1||checked==0){
                for(int i=0;i<yrb.length;i++)
                    disableRadio_no_click(yrb[i]);
            }

            for (int i = 0; i < yrb.length; i++) {
                if (yrb[i].isChecked()) {
                    yrb[i].setChecked(true);
                    ck = i;
                } else
                    yrb[i].setChecked(false);

                setBtListener2(yrb[i], i);

            }


        }

        private void setBtListener(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(idx!=checked){
                        rb.setChecked(true);
                        if(checked!=-1){
                            erb[checked].setChecked(false);
                        }
                        checked=idx;
                    }
                    else
                        rb.setChecked(true);

                    if(checked==-1||checked==0){
                        for(int i=0;i<yrb.length;i++)
                            disableRadio_no_click(yrb[i]);
                    }
                    else{
                        for(int i=0;i<yrb.length;i++)
                            enableRadio(yrb[i]);
                    }

                }
            });


        }
        private void setBtListener2(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(idx!=ck){
                        rb.setChecked(true);
                        if(ck!=-1){
                            yrb[ck].setChecked(false);
                        }
                        ck=idx;
                    }
                    else
                        rb.setChecked(true);



                }
            });


        }



    }


    private class ray{

        protected RadioButton[] bt;
        protected int checked = -1;

        public ray(RadioButton[] rbt){

            bt = rbt;

            for(int i=0;i<bt.length;i++){
                if(bt[i].isChecked()){
                    bt[i].setChecked(true);
                    checked = i;
                }
                else
                    bt[i].setChecked(false);
                setBtListener(bt[i],i);

            }
            if(checked==-1||checked==0||checked==9) {
                for(int i=2;i<bt.length-1;i++)
                    disableRadio_no_click(bt[i]);
            }

        }


        private void setBtListener(RadioButton rb, int idx){

            rb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(idx!=checked){
                        rb.setChecked(true);
                        if(checked!=-1){
                            bt[checked].setChecked(false);
                        }
                        checked=idx;
                    }
                    else
                        rb.setChecked(true);

                    if(checked==-1||checked==0||checked==9){
                        for(int i=2;i<9;i++){
                            disableRadio_no_click(bt[i]);
                        }
                    }
                    else
                        for(int i=2;i<9;i++){
                            enableRadio(bt[i]);
                        }



                }
            });


        }



    }


}

