package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class FoodData_10 {

    final private LinkedHashMap<String, String> mapped_data;

    private int[] jg_year = new int[9];
    private int[] jg_once = new int[9];
    private String[] avg_year={"거의 안먹음","월 1회","월 2~3회","주 1~2회","주 3~4회","주 5~6회","일 1회","일 2회","일 3회"};
    private String[][] avg_once={{"사진 16-1","사진 16-2","사진 16-3"},{"사진 16-1","사진 16-2","사진 16-3"},{"사진 16-1","사진 16-2","사진 16-3"},
            {"사진 9-1(&#189;큰술)","사진 9-2(1큰술)","사진 9-3(1 &#189;큰술)"},{"작은캔 반개","작은캔 1개","작은캔 1개 반"},
            {"사진 17-1","사진 17-2","사진 17-3"},{"사진 17-1","사진 17-2","사진 17-3"},{"2개","4개","6개"}
            ,{"중 &#188;마리","중 &#189;마리","중 1마리"}};


    public FoodData_10() {
        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i< jg_year.length;i++){
            jg_year[i] = -1;
            jg_once[i] = -1;
        }


    }


    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }
    public void saveData(Context nowcontext){

        for(int RowID=0;RowID<9;RowID++){
            TextView food_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"food10_text_name_"+(RowID+1)));
            for(int ColID=0;ColID<9;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food10_fir_radio"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked()){
                    jg_year[RowID] =ColID;
                }
            }
            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb= ((Activity)nowcontext).findViewById(getResId(nowcontext,"food10_sec_radio_avg" + (RowID + 1) + "_"+(ColID+1)));
                if(rb.isChecked()){
                    jg_once[RowID] =ColID;
                }

            }
            if(jg_year[RowID]==0){
                mapped_data.put(getString(food_name),jg_year[RowID]==-1?"":avg_year[jg_year[RowID]]);
            }
            else {
                if(jg_year[RowID]!=-1) {
                    mapped_data.put(getString(food_name) + "지난 1년간 섭취한 평균 횟수 :", jg_year[RowID]==-1?"":avg_year[jg_year[RowID]]);

                    mapped_data.put(getString(food_name) + "평균 1회 섭취분량 :", jg_once[RowID]==-1?"":avg_once[RowID][jg_once[RowID]]);
                }
            }
        }


    }


    public void setDataToView(ViewGroup vg){
        for(int RowID=0;RowID<9;RowID++){
            if(jg_year[RowID]!=-1){
                if(jg_year[RowID]==0){
                    ((RadioButton)vg.findViewById(getResId(vg,"food10_fir_radio"+(RowID+1)+"_"+(jg_year[RowID]+1)))).setChecked(true);
                }
                else{
                    ((RadioButton)vg.findViewById(getResId(vg,"food10_fir_radio"+(RowID+1)+"_"+(jg_year[RowID]+1)))).setChecked(true);
                    if(jg_year[RowID]!=-1)
                        ((RadioButton)vg.findViewById(getResId(vg,"food10_sec_radio_avg"+(RowID+1)+"_"+(jg_once[RowID]+1)))).setChecked(true);
                }


            }
        }

    }
    public boolean check(){
        for(int RowID=0;RowID<9;RowID++){
            if(jg_year[RowID]==-1){
                return false;
            }
            if(jg_year[RowID]!=0&&jg_year[RowID]!=-1){
                if(jg_once[RowID]==-1)
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
