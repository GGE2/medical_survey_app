package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class FoodData_8 {


    final private LinkedHashMap<String, String> mapped_data;

    private int[] pork_year = new int[7];
    private int[] pork_once = new int[7];
    private String[] avg_year={"거의 안먹음","월 1회","월 2~3회","주 1~2회","주 3~4회","주 5~6회","일 1회","일 2회","일 3회"};
    private String[][] avg_once={{"사진 13-1","사진 13-2","사진 13-3"},{"사진 13-1","사진 13-2","사진 13-3"},{"사진 13-1","사진 13-2","사진 13-3"}
            ,{"사진 13-1","사진 13-2","사진 13-3"},{"사진 14-1","사진 14-2","사진 14-3"},{"비엔나햄 3개, 햄 반장","비엔나햄 5개,햄 1장","비엔나햄 8개,햄 1장 반"}
            ,{"사진 14-1","사진 14-2","사진 14-3"}};

    public FoodData_8() {
        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i< pork_year.length;i++){
            pork_year[i] = -1;
            pork_once[i] = -1;
        }


    }


    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }
    public void saveData(Context nowcontext){

        for(int RowID=0;RowID<7;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food8_text_name_"+(RowID+1)));
            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food8_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    pork_year[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food8_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    pork_once[RowID] =ColID;
                }

            }
            if(pork_year[RowID]==0){
                mapped_data.put(getString(food_name),pork_year[RowID]==-1?"":avg_year[pork_year[RowID]]);
            }
            else {
                if(pork_year[RowID]!=-1) {
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", pork_year[RowID]==-1?"":avg_year[pork_year[RowID]]);

                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", pork_once[RowID]==-1?"":avg_once[RowID][pork_once[RowID]]);
                }
            }
        }


    }
    public void setDataToView(ViewGroup vg){
        for(int RowID=0;RowID<7;RowID++){
            if(pork_year[RowID]!=-1){
                if(pork_year[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food8_fir_radio"+(RowID+1)+"_"+(pork_year[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food8_fir_radio"+(RowID+1)+"_"+(pork_year[RowID]+1)))).setChecked(true);
                    if(pork_year[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food8_sec_radio_avg"+(RowID+1)+"_"+(pork_once[RowID]+1)))).setChecked(true);
                }


            }
        }

    }
    public boolean check(){
        for(int RowID=0;RowID<8;RowID++){
            if(pork_year[RowID]==-1){
                return false;
            }
            if(pork_year[RowID]!=0&&pork_year[RowID]!=-1){
                if(pork_once[RowID]==-1)
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
