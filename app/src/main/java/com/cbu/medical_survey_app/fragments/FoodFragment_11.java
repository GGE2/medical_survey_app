package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;

public class FoodFragment_11 extends Fragment {
    private Context nowContext;
    ButtonListener bt1,bt2;


    public FoodFragment_11(Context context){

        nowContext = context;
        bt1 = new ButtonListener(context);
        bt2 = new ButtonListener(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.food_frag_11, container, false);

        return vg;
    }


}
