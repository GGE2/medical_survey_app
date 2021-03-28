package com.cbu.medical_survey_app.datas;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.JobFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class JobData {

    final private LinkedHashMap<String, String> mapped_data;

    // 직업
    private int radio_checked = -1;
    private String[] input_positions = new String[11];
    private String[] input_position_years = new String[11];
    private String text_position = "";

    // 생산직 종사
    private ArrayList<Integer> checkedList = new ArrayList<>();     // 생산직 종사 체크 인덱스의 리스트
    private String[] input_production_years = new String[24];       // 생산직 종사 모든 년도들의 리스트
    private String input_production_other = "";                     // 생산직 종사 기타 데이터

    // 오래 종사 여부
    private int mainjob_checked = -1;
    private String input_mainjob = "";
    private String input_mainjob_year = "";

    public JobData() {
        mapped_data = new LinkedHashMap<String, String>();
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

    public void saveData(Context nowContext) {
        for (int posID = 0; posID < 11; posID++) {
            RadioButton radio_position = ((Activity)nowContext).findViewById(getResId(nowContext, "radio_position_" + (posID + 1)));

            // 라디오 버튼이 체크되어 있으면
            if(radio_position.isChecked()){
                radio_checked = posID;
                text_position = getString(((Activity)nowContext).findViewById(getResId(nowContext, "text_position_" + (posID + 1))));
            }

            input_positions[posID] = getString(((Activity)nowContext).findViewById(getResId(nowContext, "input_position_" + (posID + 1))));
            input_position_years[posID] = getString(((Activity)nowContext).findViewById(getResId(nowContext, "input_position_year_" + (posID + 1))));
        }

        ArrayList<String> productionList = new ArrayList<>();

        for (int proID = 0; proID < 24; proID++) {
            CheckBox check_production = ((Activity)nowContext).findViewById(getResId(nowContext, "check_production_" + (proID + 1)));

            if(check_production.isChecked()){
                if(proID < 23){
                    productionList.add(getString((TextView)((Activity)nowContext).findViewById(getResId(nowContext, "text_production_" + (proID + 1)))));
                }
            else {
                    input_production_other = getString(((Activity)nowContext).findViewById(R.id.input_production_other));
                    productionList.add("기타(" + input_production_other + ")");
                }
            checkedList.add(proID);
            }

            input_production_years[proID] = getString(((Activity)nowContext).findViewById(getResId(nowContext, "input_production_year_" + (proID + 1))));
        }

        RadioButton mainjob_no = ((Activity)nowContext).findViewById(R.id.radio_mainjob_no);
        RadioButton mainjob_yes = ((Activity)nowContext).findViewById(R.id.radio_mainjob_yes);

        if(mainjob_no.isChecked()){
            mainjob_checked = 0;
            input_mainjob = getString(((Activity)nowContext).findViewById(R.id.input_mainjob));
            input_mainjob_year = getString(((Activity)nowContext).findViewById(R.id.input_mainjob_year));
        }
        else if(mainjob_yes.isChecked()){
            mainjob_checked = 1;
        }

        mapped_data.put("종사하는 직종", text_position);
        mapped_data.put("직무", radio_checked == -1 ? "" : input_positions[radio_checked]);
        mapped_data.put("종사 기간", radio_checked == -1 ? "" : input_position_years[radio_checked]);
        for(int i = 0; i < checkedList.size(); i++) {
            mapped_data.put("생산직 종사" + (i + 1), productionList.get(i) + " " + input_production_years[checkedList.get(i)] + "년부터");
        }
        mapped_data.put("가장 오래 종사 여부", mainjob_checked == -1 ? "" : mainjob_checked == 1 ? "예" : "아니오");
        mapped_data.put("가장 오래 종사 직업", input_mainjob);
        mapped_data.put("가장 오래 종사 기간", input_mainjob_year);
    }

    public void setDataToView(ViewGroup vg) {

    }

    private int getResId(Context nowContext, String id) {
        int getID = ((Activity)nowContext).getResources().getIdentifier(id, "id", nowContext.getPackageName());
        return getID;
    }
}
