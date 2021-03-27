package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;

public class normal_fragment_2 extends Fragment {

    private ButtonListener bt2;
    private Context nowContext;
    Button pre_btn1,next_btn2;
    public normal_fragment_2(){
    }
    public normal_fragment_2(Context context) {
        bt2 = new ButtonListener(context);
        nowContext = context;
    }

    public static normal_fragment_2 newInstance(){

        return new normal_fragment_2();
    }


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.normal_frag_2, container, false);

        pre_btn1 = (Button)vg.findViewById(R.id.pre_btn_1);
        next_btn2 = (Button)vg.findViewById(R.id.next_btn_2);






        // 프래그먼트에 데이터 세팅
        //MainActivity.dtc.setDataToView(vg);

        return vg;
    }






}
