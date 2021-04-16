package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.apache.poi.ss.usermodel.Row;

import java.util.LinkedHashMap;

public class NormalData_4 {

        final private LinkedHashMap<String, String> mapped_data;

        //14번

        private int[] ray = new int[4];
        private String[] ray_str={"없다","있다","1회","2회~5회","6회 10회","11회~15회","16~20회","21회","횟수는 모르겠다","모르겠다"};

        //15번

        private int[] medi_eat = new int[9];
        private int[] medi_year = new int[9];
        private String[] medi_eat_str={"없다","주1~3알","주4~6알","매일 1알","매일 2알","매일 3알"};
        private String[] medi_year_str={"1년이하","2~4년","5년이상"};


        public NormalData_4() {
            mapped_data = new LinkedHashMap<String, String>();

            for(int i=0;i<ray.length;i++){
                ray[i]=-1;
            }
            for(int i=0;i<medi_eat.length;i++){
                medi_eat[i]=-1;
            }
            for(int i=0;i<medi_year.length;i++){
                medi_year[i]=-1;

            }

        }
         public LinkedHashMap<String, String> getData() {
            return mapped_data;
        }


        public void saveData(Context nowcontext) {
            //14번
                for(int RowID=0;RowID<4;RowID++){
                    TextView ray_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"normal4_text_position_"+(RowID+1)));
                    for(int ColID=0;ColID<10;ColID++){
                        RadioButton rb = ((Activity)nowcontext).findViewById(getResId(nowcontext,"normal4_radio_position_"+(RowID+1)+"_"+(ColID+1)));
                        if(rb.isChecked()){
                            ray[RowID] = ColID;
                        }
                    }
                    mapped_data.put(getString(ray_name),ray[RowID]==-1?"":ray_str[ray[RowID]]);
                }
                //15번
                for(int RowID=0;RowID<9;RowID++){
                    TextView medi_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"medi_name_"+(RowID+1)));
                    for(int ColID=0;ColID<6;ColID++){
                        RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"medi_eat_radio"+(RowID+1)+"_"+(ColID+1)));
                        if(rb.isChecked()){
                            medi_eat[RowID] =ColID;
                        }
                    }
                    for(int ColID=0;ColID<3;ColID++){
                        RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"medi_year_radio" + (RowID + 1) + "_"+(ColID+1)));
                        if(rb.isChecked()){
                            medi_year[RowID] =ColID;
                        }

                    }
                    if(medi_eat[RowID]==0){
                        mapped_data.put(getString(medi_name),medi_eat[RowID]==-1?"":medi_eat_str[medi_eat[RowID]]);
                    }
                    else {
                        if(medi_eat[RowID]!=-1) {
                            mapped_data.put(getString(medi_name) + "총 복용량 :", medi_eat[RowID]==-1?"":medi_eat_str[medi_eat[RowID]]);
                            mapped_data.put(getString(medi_name) + "총 복용기간 :", medi_year[RowID]==-1?"":medi_year_str[medi_year[RowID]]);
                        }
                    }
                }


        }

        public void setDataToView(ViewGroup vg){
            //14번
            for(int RowID=0;RowID<4;RowID++){
                if(ray[RowID]!=-1){
                    ((RadioButton)vg.findViewById(getResId(vg,"normal4_radio_position_"+(RowID+1)+"_"+(ray[RowID]+1)))).setChecked(true);
                }
            }
            //15번
            for(int RowID=0;RowID<9;RowID++){
                if(medi_eat[RowID]!=-1){
                    if(medi_eat[RowID]==0){
                        ((RadioButton)vg.findViewById(getResId(vg,"medi_eat_radio"+(RowID+1)+"_"+(medi_eat[RowID]+1)))).setChecked(true);
                    }
                    else{
                        ((RadioButton)vg.findViewById(getResId(vg,"medi_eat_radio"+(RowID+1)+"_"+(medi_eat[RowID]+1)))).setChecked(true);
                        ((RadioButton)vg.findViewById(getResId(vg,"medi_year_radio"+(RowID+1)+"_"+(medi_year[RowID]+1)))).setChecked(true);
                    }


                }
            }

        }
        public boolean check(){
            //14번 유효성 검사
            for(int RowID=0;RowID<4;RowID++){
                if(ray[RowID]==-1||ray[RowID]==1){
                    return false;
                }
            }

            //15번 유효성 검사
            for(int RowID=0;RowID<9;RowID++){
                if(medi_eat[RowID]==-1){
                    return false;
                }
                if(medi_eat[RowID]!=0&&medi_eat[RowID]!=-1){
                    if(medi_year[RowID]==-1)
                        return false;
                }

            }


            return true;
        }
        private String getString(EditText view) {

        return view.getText().toString();
    }


        private String getString(TextView view) {

        return view.getText().toString();
    }

    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", vg.getContext().getPackageName());
        return getID;
    }

    }

