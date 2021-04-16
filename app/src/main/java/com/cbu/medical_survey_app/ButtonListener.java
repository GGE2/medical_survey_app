package com.cbu.medical_survey_app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.fragment.app.FragmentActivity;

public class ButtonListener implements Button.OnClickListener {

    final private ScrollView scrollView;
    final private ButtonController btc;

    public ButtonListener(Context context) {
        scrollView = ((FragmentActivity)context).findViewById(R.id.main_scroll);
        btc = new ButtonController(context);
    }

    // 버튼 리스너들 각 버튼에 controller를 연결시킴
    @Override
    public void onClick(View view) {

        scrollView.fullScroll(ScrollView.FOCUS_UP);

        switch (view.getId()) {
            case R.id.normal1_next_btn_1 :
                btc.normalComplete();
                break;
            case R.id.bt_normal2_prev:
                btc.normal2_pre();
                break;
            case R.id.bt_normal2_next:
                btc.normal2_next();
                break;
            case R.id.bt_normal3_prev:
                btc.normal3_pre();
                break;
            case R.id.bt_normal3_next:
                btc.normal3_next();
                break;
            case R.id.bt_normal4_prev:
                btc.normal4_pre();
                break;
            case R.id.bt_job_next:
                btc.jobComplete();
                break;
            case R.id.bt_job_prev:

                break;

            default:
                break;
        }
    }
}
