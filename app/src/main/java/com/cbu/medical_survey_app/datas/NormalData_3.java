package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.NormalFragment_3;

import java.util.LinkedHashMap;

public class NormalData_3 {


    final private LinkedHashMap<String, String>mapped_data;
    //12번(가족력)
    private int[][] disease_check = new int[6][4];
    private String[] disease_family = {"아버지","어머니","형제,자매","조부모,외조부모"};
    private String[] check_disease_reuslt_string={"없다","있다"};
    private String[] cancer = new String[4];
    private int[] cancer_check = new int[4];
    private int[] cancer_button_check = new int[4];
    private int [] cancer_text_check = new int[4];
    //13번
    private int radio_yes_check=-1;
    private int radio_no_check=-1;
    private String[] result = new String[4];
    //14번
    private int[] operation_check = new int[12];
    private int[] blood_operation = new int [6];
    private String[] operation_result_year = new String[12];
    private String[] operation_result_age = new String[12];
    private String[] operation_blood_re = new String[2];

    private String operation_etc="";
    private int checksum=-6;

    public NormalData_3(){

        mapped_data = new LinkedHashMap<String, String>();

        for(int i=0;i<disease_check.length;i++){
            for(int k=0;k<disease_check[0].length;k++){
                disease_check[i][k] = -1;
            }
        }
        for(int i=0;i<cancer.length;i++){
            cancer[i]="";
            cancer_button_check[i] = -1;
        }
        for(int i=0;i<cancer_check.length;i++){
            cancer_check[i]=-1;
        }
        for(int i=0;i<cancer_text_check.length;i++){
            cancer_text_check[i]=-1;
        }

        for(int i=0;i<result.length;i++){
            result[i] = "";
        }
        for(int i=0;i<operation_result_year.length;i++){
            operation_result_year[i]="";
            operation_result_age[i]="";
        }
        for(int i=0;i<operation_check.length;i++) {
            operation_check[i]=-1;
        }
        for(int i=0;i<blood_operation.length;i++)
            blood_operation[i]=-1;
    }


    public LinkedHashMap<String, String> getData() {
        return mapped_data;
    }


    public void saveData(Context nowcontext){

        //12번
        for(int i=0;i<disease_check.length;i++) {
            TextView disease_name = ((Activity) nowcontext).findViewById(getResId(nowcontext, "disease_text" + (i+1)));
            for (int k = 0; k < disease_check[0].length; k++) {
                for (int j = 0; j < 2; j++) {
                    RadioButton rg = ((Activity) nowcontext).findViewById(getResId(nowcontext, "normal3_radio_position_" + (i + 1) + "_" + (k + 1) + "_" + (j + 1)));
                    if (rg.isChecked()) {
                        disease_check[i][k] = j;
                    }
                    EditText cancer_text = ((Activity) nowcontext).findViewById(getResId(nowcontext, "cancer_input_1_" + (k + 1)));
                    RadioButton cancer_button = ((Activity) nowcontext).findViewById(getResId(nowcontext, "normal3_radio_position_6_" + (k + 1) + "_3"));
                    if (cancer_button.isChecked())
                        cancer_button_check[k] = 1;
                    cancer[k] = getString(cancer_text);
                }
                //12번 암
                if (i == 5) {
                    if (disease_check[i][k] == 0 || disease_check[i][k] != -1) {
                        if(disease_check[i][k] == 0)
                            cancer_check[k] = 1;
                        mapped_data.put(disease_family[k] + " " + getString(disease_name) + " 병력 : ", disease_check[i][k] == -1 ? " " : check_disease_reuslt_string[disease_check[i][k]]);
                    } else {
                        if (cancer_button_check[k] == 1) {
                            cancer_check[k] = 1;
                            mapped_data.put(disease_family[k] + " " + getString(disease_name) + " 병력 : ", check_disease_reuslt_string[disease_check[i][k]] + "부위불명");
                        }
                        else {
                            if(!(cancer[k].equals("")))
                            cancer_text_check[k] = 1;
                            mapped_data.put(disease_family[k] + " " + getString(disease_name) + " 병력 : ", cancer[k] + "암");
                        }
                    }

                } else
                    mapped_data.put(disease_family[k] + " " +  getString(disease_name) + " 병력 : ", disease_check[i][k] == -1 ? " " : check_disease_reuslt_string[disease_check[i][k]]);

            }


        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //13번
        RadioButton radioYes = ((Activity)nowcontext).findViewById(R.id.pro13_radioYes);
        RadioButton radioNo = ((Activity)nowcontext).findViewById(R.id.pro13_radioNo);

        if(radioYes.isChecked()){
            radio_yes_check = R.id.pro13_radioYes;
            EditText m_name = ((Activity)nowcontext).findViewById(R.id.eatingPill_name);
            result[0] = m_name.getText().toString();
            EditText m_year = ((Activity)nowcontext).findViewById(R.id.eatingPill_year);
            result[1] = m_year.getText().toString();
            EditText m_month = ((Activity)nowcontext).findViewById(R.id.eatingPill_month);
            result[2] = m_month.getText().toString();
            EditText m_day = ((Activity)nowcontext).findViewById(R.id.eatingPill_day);
            result[3] = m_day.getText().toString();
            mapped_data.put("현재 치료를 위해 복용중인 약 :",m_name.getText().toString());
            mapped_data.put("복용 기간 : ",m_year.getText().toString()+"년"+m_month.getText().toString()+"월"+m_day.getText().toString()+"일");
        }
        else{
            if(radioNo.isChecked()){
                radio_no_check = R.id.pro13_radioNo;
                mapped_data.put("현재 치료를 위해 복용중인 약 : ","없음");
            }
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //14번 ~ 기타 수술

        for(int RowID=0;RowID<operation_check.length;RowID++){
            TextView operation_name = ((Activity)nowcontext).findViewById(getResId(nowcontext,"pro14_disease_text"+(RowID+1)));
            EditText inputY = ((Activity)nowcontext).findViewById(getResId(nowcontext,"normal3_pro_14input_position_"+(RowID+1)+"_1"));
            EditText inputA = ((Activity)nowcontext).findViewById(getResId(nowcontext,"normal3_pro_14input_position_"+(RowID+1)+"_2"));

            for(int ColID=0;ColID<3;ColID++){
                RadioButton rb = ((Activity)nowcontext).findViewById(getResId(nowcontext,"normal3_pro14_radio_position_"+(RowID+1)+"_"+(ColID+1)));
                if(rb.isChecked())
                    operation_check[RowID] = ColID;
            }
            if(RowID==11){
                EditText input_ope_ect = ((Activity)nowcontext).findViewById(getResId(nowcontext,"pro14_input"));
                operation_etc = getString(input_ope_ect);
            }
            operation_result_year[RowID] = getString(inputY);
            operation_result_age[RowID] = getString(inputA);

            if (operation_check[RowID] == 1) {
                mapped_data.put(RowID==11?getString(operation_name)+operation_etc+"수술":getString(operation_name)+ "경험유:", getString(inputY) + "년 " + getString(inputA) + "세");
            } else if (operation_check[RowID] == 2) {
                mapped_data.put(RowID==11?getString(operation_name)+operation_etc+"수술":getString(operation_name) + "경험 유:", "언제받았는지 모르겠다");
            } else {
                mapped_data.put(RowID==11?"기타"+operation_etc+"수술":getString(operation_name) + "경험 :", operation_check[RowID] != -1 ? "미기입" : "없다");
            }


        }

        //14번 수혈

        for(int i=0;i<blood_operation.length;i++){
            RadioButton rb = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_radio_"+(i+1)));
            if(rb.isChecked()){
                blood_operation[i] = i;
                checksum+=blood_operation[i]+1;
            }
        }

        if(checksum==-6){
            mapped_data.put("수혈","");
        }
        if(blood_operation[0]!=-1){
            mapped_data.put("수혈 경험: ","없다");
        }
        else if(blood_operation[2]==-1&&blood_operation[3]==-1&&blood_operation[4]==-1&&blood_operation[5]==-1){// off off off off
            mapped_data.put("수혈 경험 ","미기입");
        }
        else if(blood_operation[2]!=-1&&blood_operation[3]==-1&&blood_operation[4]==-1&&blood_operation[5]==-1){// on off off off
            EditText edit11 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_1"));
            operation_blood_re[0] = getString(edit11);
            mapped_data.put("수혈 경험 11년 이전 ",getString(edit11));
        }
        else if(blood_operation[2]!=-1&&blood_operation[3]==-1&&blood_operation[4]!=-1&&blood_operation[5]==-1){// on off on off
            EditText edit11 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_1"));
            EditText edit5 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_2"));
            operation_blood_re[0] = getString(edit11);
            operation_blood_re[1] = getString(edit5);
            mapped_data.put("수혈 경험 11년 이전 ",getString(edit11));
            mapped_data.put("수혈 경험 5년~10년 이전 ",getString(edit5));
        }

        else if(blood_operation[2]!=-1&&blood_operation[3]!=-1&&blood_operation[4]==-1&&blood_operation[5]==-1){// on on off off
            EditText edit11 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_1"));
            mapped_data.put("수혈 경험 11년 이전 ","몇 병인지 모르겠다");
        }
        else if(blood_operation[2]!=-1&&blood_operation[3]!=-1&&blood_operation[4]!=-1&&blood_operation[5]==-1){ // on on on off
            EditText edit5 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_2"));
            operation_blood_re[1] = getString(edit5);
            mapped_data.put("수혈 경험 11년 이전 ","몇 병인지 모르겠다");
            mapped_data.put("수혈 경험 5~10년 이전 ",getString(edit5));
        }
        else if(blood_operation[2]!=-1&&blood_operation[3]!=-1&&blood_operation[4]!=-1&&blood_operation[5]!=-1) { // on on on on
            mapped_data.put("수혈 경험 11년 이전 ","몇 병인지 모르겠다");
            mapped_data.put("수혈 경험 5~10년 이전 ","몇 병인지 모르겠다");
        }
        else if(blood_operation[2]==-1&&blood_operation[3]==-1&&blood_operation[4]!=-1&&blood_operation[5]==-1) {// off off on off
            EditText edit5 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_2"));
            operation_blood_re[1] = getString(edit5);
            mapped_data.put("수혈 경험 5~10년 이전 ",getString(edit5));
        }
        else if(blood_operation[2]==-1&&blood_operation[3]==-1&&blood_operation[4]!=-1&&blood_operation[5]!=-1) {// off off on on
            EditText edit5 = ((Activity)nowcontext).findViewById(getResId(nowcontext,"blood_input_2"));
            operation_blood_re[1] = getString(edit5);
            mapped_data.put("수혈 경험 5~10년 이전 ","몇 병인지 모르겠다");
        }


    }


    public void setDataToView(ViewGroup vg){
        //12번
        for(int i=0; i<disease_check.length;i++) {
            for (int k = 0; k < disease_family.length; k++) {
                if (i == 5) {
                    if (disease_check[i][k] != -1) {
                        if (disease_check[i][k] == 0) {
                            ((RadioButton) vg.findViewById(getResId(vg, "normal3_radio_position_" + (i + 1) + "_" + (k + 1) + "_" + (disease_check[i][k] + 1)))).setChecked(true);
                        } else {
                            if (cancer_button_check[k] == 1) {
                                ((RadioButton) vg.findViewById(getResId(vg, "normal3_radio_position_" + (i + 1) + "_" + (k + 1) + "_" + (disease_check[i][k] + 1)))).setChecked(true);

                                ((RadioButton) vg.findViewById(getResId(vg, "normal3_radio_position_6_" + (k + 1) + "_3"))).setChecked(true);
                            } else {
                                ((RadioButton) vg.findViewById(getResId(vg, "normal3_radio_position_" + (i + 1) + "_" + (k + 1) + "_" + (disease_check[i][k] + 1)))).setChecked(true);
                                ((EditText) vg.findViewById(getResId(vg, "cancer_input_1_" + (k + 1)))).setText(cancer[k]);
                            }

                        }
                    }

                } else {
                    if (disease_check[i][k] != -1)
                        ((RadioButton) vg.findViewById(getResId(vg, "normal3_radio_position_" + (i + 1) + "_" + (k + 1) + "_" + (disease_check[i][k] + 1)))).setChecked(true);
                }
            }
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //13번
        if(radio_yes_check!=-1){
            ((RadioButton)vg.findViewById(radio_yes_check)).setChecked(true);
            ((EditText)vg.findViewById(R.id.eatingPill_name)).setText(result[0]);
            ((EditText)vg.findViewById(R.id.eatingPill_year)).setText(result[1]);
            ((EditText)vg.findViewById(R.id.eatingPill_month)).setText(result[2]);
            ((EditText)vg.findViewById(R.id.eatingPill_day)).setText(result[3]);
        }
        if(radio_no_check!=-1){
            ((RadioButton)vg.findViewById(radio_no_check)).setChecked(true);
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //14번

        for(int RowID=0;RowID<operation_check.length;RowID++){
                if(RowID==11) {
                    if(!operation_etc.equals(""))
                    ((EditText)vg.findViewById(getResId(vg,"pro14_input"))).setText(operation_etc);
                }
                if(operation_check[RowID]!=-1){
                    if(operation_check[RowID]==0)
                    ((RadioButton)vg.findViewById(getResId(vg,"normal3_pro14_radio_position_"+(RowID+1)+"_1"))).setChecked(true);
                    else if(operation_check[RowID]==2){
                        ((RadioButton)vg.findViewById(getResId(vg,"normal3_pro14_radio_position_"+(RowID+1)+"_2"))).setChecked(true);
                        ((RadioButton)vg.findViewById(getResId(vg,"normal3_pro14_radio_position_"+(RowID+1)+"_3"))).setChecked(true);
                    }
                    else{
                        ((RadioButton)vg.findViewById(getResId(vg,"normal3_pro14_radio_position_"+(RowID+1)+"_2"))).setChecked(true);
                        ((EditText)vg.findViewById(getResId(vg,"normal3_pro_14input_position_"+(RowID+1)+"_1"))).setText(operation_result_year[RowID]);
                        ((EditText)vg.findViewById(getResId(vg,"normal3_pro_14input_position_"+(RowID+1)+"_2"))).setText(operation_result_age[RowID]);

                    }
                }

            }
        //14번 수혈

        if(checksum!=-6&&blood_operation[0]!=-1){
            Log.e("ee","ee");
            ((RadioButton)vg.findViewById(getResId(vg,"blood_radio_1"))).setChecked(true);
        }
        if(checksum!=-6&&blood_operation[0]==-1) {
            for (int i = 1; i < blood_operation.length; i++) {
                if(blood_operation[i]!=-1)
                ((RadioButton)vg.findViewById(getResId(vg,"blood_radio_"+(i+1)))).setChecked(true);

            }
            ((EditText)vg.findViewById(getResId(vg,"blood_input_1"))).setText(operation_blood_re[0]);
            ((EditText)vg.findViewById(getResId(vg,"blood_input_2"))).setText(operation_blood_re[1]);
        }

        }



    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", vg.getContext().getPackageName());
        return getID;
    }
    private String getString(EditText view) {
        return view.getText().toString();
    }

    private String getString(TextView view) {
        return view.getText().toString();
    }
    public boolean check(){
    //12번
        for(int RowID=0;RowID<disease_check.length;RowID++){

            for(int ColID=0;ColID<disease_check[0].length;ColID++){

                if(RowID==5){
                    if(disease_check[RowID][ColID]==1) {
                        if (cancer_text_check[ColID] == -1 && cancer_check[ColID] == -1) {
                            Log.e("ifno", "ifno");
                            return false;
                        }
                    }
                }
                else {
                    if(disease_check[RowID][ColID] == -1) {
                        Log.e("elseno","elseno");
                        return false;
                    }
                }
            }

        }
     //13번
        if(radio_yes_check==-1&&radio_no_check==-1)
            return false;
        if(radio_yes_check!=-1){
            if(result[0].equals("")&&result[1].equals("")&&result[2].equals("")&&result[3].equals(""))
                return false;
        }

     //14번
        for(int i=0;i<operation_check.length;i++){
            if(operation_check[i]==-1){
                return false;
            }
            if(operation_check[i]==1){
                    if(operation_result_year[i].equals("")&&operation_result_age[i].equals(""))
                        return false;
            }
        }

        //14번 수혈
        if(checksum==-6)
            return false;


        return true;
    }



}
