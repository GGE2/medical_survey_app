package com.cbu.medical_survey_app.datas;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import com.cbu.medical_survey_app.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class NormalData_2 {
    final private LinkedHashMap<String, String> mapped_data;
    //10번
    String user_commute="";
    String user_commute_hour="";
    String user_commute_minute="";
    int user_commute_id=-1;

    //11번
    private int[] check_radio_id = new int[21];
    private String[] input_year_result = new String[21];
    private String[] input_age_result = new String [21];


    private String[] radio_result = {"없다","있다 지금은 나았다","있다 지금도 앓고 있다","모르겠다"};


    public NormalData_2() {
        mapped_data = new LinkedHashMap<String, String>();
        for(int i=0;i<21;i++){

            check_radio_id[i]= -1;
            input_year_result[i] = "";
            input_age_result[i] = "";

        }
    }


    private String getString(EditText view) {
        return view.getText().toString();
    }

    private String getString(TextView view) {
        return view.getText().toString();
    }

    public LinkedHashMap<String, String> getData() {

        return mapped_data;
    }
    public void saveData(Context nowContext){
        int ColID=0,RowID=0;
        user_commute_id = ((RadioGroup) ((Activity) nowContext).findViewById(R.id.pro10)).getCheckedRadioButtonId();

        if(user_commute_id!=-1) {
            user_commute = getString((RadioButton) ((Activity) nowContext).findViewById(user_commute_id));
            user_commute_hour = getString((EditText) ((Activity) nowContext).findViewById(R.id.pro10_hour));
            user_commute_minute = getString((EditText) ((Activity) nowContext).findViewById(R.id.pro10_minute));
            mapped_data.put("출퇴근 수단:",user_commute);
            mapped_data.put("출퇴근 시간",user_commute_hour+"시간"+user_commute_minute+"분");
        }

        for(RowID=0;RowID<21;RowID++){

            TextView disease_name = ((Activity)nowContext).findViewById(getResId(nowContext,"normal_text_position_"+(RowID+1)));

            for(ColID=0;ColID<4;ColID++){
                RadioButton disease_check=((Activity)nowContext).findViewById(getResId(nowContext,"normal_radio_position_"+(RowID+1)+"_"+(ColID+1)));

                if(disease_check.isChecked())
                    check_radio_id[RowID] = ColID;
            }
            if(ColID!=0||ColID!=3) {
                EditText input_year = ((Activity) nowContext).findViewById(getResId(nowContext, "normal_input_position_" + (RowID+1) + "_1"));
                EditText input_age = ((Activity) nowContext).findViewById(getResId(nowContext, "normal_input_position_" + (RowID+1) + "_2"));
                input_year_result[RowID] = getString(input_year);
                input_age_result[RowID] = getString(input_age);
            }
            else {
                EditText input_year = ((Activity) nowContext).findViewById(getResId(nowContext, "normal_input_position_" + (RowID+1) + "_1"));
                EditText input_age = ((Activity) nowContext).findViewById(getResId(nowContext, "normal_input_position_" + (RowID+1) + "_2"));
                input_year_result[RowID] = "";
                input_age_result[RowID] = "";
            }
            mapped_data.put(getString(disease_name),check_radio_id[RowID]==-1?"":radio_result[check_radio_id[RowID]]);
            if(check_radio_id[RowID]==1||check_radio_id[RowID]==2) {
                mapped_data.put(getString(disease_name)+" 처음진단받은 년도", input_year_result[RowID] + "년");
                mapped_data.put(getString(disease_name)+" 처음진단받은 나이", input_age_result[RowID] + "세");
            }

        }



    }
    public void setDataToView(ViewGroup vg){
        if(user_commute_id!=-1)
        ((RadioButton)vg.findViewById(user_commute_id)).setChecked(true);
        ((EditText)vg.findViewById(R.id.pro10_hour)).setText(user_commute_hour);
        ((EditText)vg.findViewById(R.id.pro10_minute)).setText(user_commute_minute);

        for(int RowId=0;RowId<21;RowId++){
            if(check_radio_id[RowId]!=-1){
                ((RadioButton)vg.findViewById(getResId(vg,"normal_radio_position_"+(RowId+1)+"_"+(check_radio_id[RowId]+1)))).setChecked(true);

            }
            ((EditText)vg.findViewById(getResId(vg,"normal_input_position_"+(RowId+1)+"_1"))).setText(input_year_result[RowId]);
            ((EditText)vg.findViewById(getResId(vg,"normal_input_position_"+(RowId+1)+"_2"))).setText(input_age_result[RowId]);

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

    public boolean check(){
        int check=0;

        if(user_commute_id==-1||(user_commute_hour.equals("")&&user_commute_minute.equals(""))) {
            return false;
        }
        for(int i=0;i<21;i++){
            if (check_radio_id[i]==-1){
                continue;
            }
            else if(check_radio_id[i]==0||check_radio_id[i]==3){
                check++;
            }
            else{
                if(input_year_result[i].equals("")&&input_age_result[i].equals("")){
                    continue;
                }
                else
                    check++;

            }
        }
        if(check==21)
            return true;
        if(check!=21)
            return false;


        return true;
    }


}
