package com.cbu.medical_survey_app;

import android.content.Context;
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
            case R.id.bt_submit :
                btc.surveyComplete();
                break;
            case R.id.bt_job_next:
                btc.jobNext();
                break;
            case R.id.bt_job_prev:
                btc.jobPrev();
                break;
            case R.id.bt_smoke_next:
                btc.smokeNext();
                break;
            case R.id.bt_smoke_prev:
                btc.smokePrev();
                break;
            case R.id.bt_sleep_next:
                btc.sleepNext();
                break;
            case R.id.bt_sleep_prev:
                btc.sleepPrev();
                break;
//            case R.id.bt_food1_next:
//                btc.food1_Next();
//                break;
//            case R.id.bt_food1_prev:
//                btc.food1_Prev();
//                break;

            default:
                break;
        }
    }
}
