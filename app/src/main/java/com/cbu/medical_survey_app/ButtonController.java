package com.cbu.medical_survey_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cbu.medical_survey_app.activities.StartActivity;
import com.cbu.medical_survey_app.activities.PopupActivity;
import com.cbu.medical_survey_app.fragments.JobFragment;
import com.cbu.medical_survey_app.fragments.LastFragment;
import com.cbu.medical_survey_app.fragments.NormalFragment_1;
import com.cbu.medical_survey_app.fragments.NormalFragment_2;
import com.cbu.medical_survey_app.fragments.NormalFragment_3;
import com.cbu.medical_survey_app.fragments.NormalFragment_4;
import com.cbu.medical_survey_app.fragments.SleepFragment;
import com.cbu.medical_survey_app.fragments.SmokeFragment;

public class ButtonController {

    // ButtonController가 만들어진 Context
    final private Context nowContext;
    private TextView title;
    private ImageView title_img;

    public ButtonController(Context context) {
        nowContext = context;
        title = (TextView)((Activity)context).findViewById(R.id.top_title);
        title_img = (ImageView)((Activity)context).findViewById(R.id.title_img);
    }

    // 버튼이 눌렸을 때 동작들(datas에 저장하거나, 제출)
    public void surveyComplete () {

        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 데이터 엑셀에 저장
            StartActivity.dtc.saveExcel(nowContext);

            // 설문 완료 시 앱 재시작
            Intent intent = new Intent(nowContext, StartActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void jobComplete() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            title.setText(R.string.last_title);
            title_img.setImageResource(0);

            Fragment fragment = new JobFragment(nowContext);
            FragmentManager fm = ((FragmentActivity)nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void normalComplete () {
        // 현재 뷰의 데이터들을 저장
        if(StartActivity.dtc.saveData(nowContext)) {
            StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_2(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else{
            openPopup();
        }

    }
    public void normal2_pre () {
        // 현재 뷰의 데이터들을 저장
            StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_1(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }

    public void normal2_next () {
        // 현재 뷰의 데이터들을 저장

        if(StartActivity.dtc.saveData(nowContext)) {
            Fragment fragment = new NormalFragment_3(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else
            openPopup();

    }
    public void normal3_pre () {
        // 현재 뷰의 데이터들을 저장
             StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_2(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();


//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }
    public void normal3_next () {
        // 현재 뷰의 데이터들을 저장

        if(StartActivity.dtc.saveData(nowContext)) {
            Fragment fragment = new NormalFragment_4(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.commit();
        }
        else
            openPopup();


//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }
    public void normal4_pre () {
        // 현재 뷰의 데이터들을 저장
        StartActivity.dtc.saveData(nowContext);
            Fragment fragment = new NormalFragment_3(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }
    public void normal4_next () {
        // 현재 뷰의 데이터들을 저장
        if(StartActivity.dtc.saveData(nowContext)) {
            title.setText(R.string.smoke_title);
            title_img.setImageResource(R.drawable.img_smoke_top);
            Fragment fragment = new SmokeFragment(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else
            openPopup();

//        ((FragmentActivity)nowContext).startActivity(intent);
        // 데이터 엑셀에 저장
        //MainActivity.dtc.saveExcel(nowContext);

        // 설문 완료 시 앱 재시작
            /*
            Intent intent = new Intent(nowContext, MainActivity.class);
            ((Activity)nowContext).finishAffinity();
            ((Activity)nowContext).startActivity(intent);
            System.exit(0);*/
    }
    public void smokePrev() {

            title.setText(R.string.normal_title);
            title_img.setImageResource(R.drawable.normal_top);
            Fragment fragment = new NormalFragment_4(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }


    public void smokeNext() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 흡연 -> 수면
            title.setText(R.string.sleep_title);
            title_img.setImageResource(R.drawable.img_sleep_top);
            Fragment fragment = new SleepFragment(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }
    public void sleepPrev() {

            // 수면 -> 흡연
            title.setText(R.string.smoke_title);
            title_img.setImageResource(R.drawable.img_smoke_top);
        Fragment fragment = new SmokeFragment(nowContext);
        FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.survey_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }
    public void sleepNext() {
        if(StartActivity.dtc.saveData(nowContext)){
            // 유효성 검사 통과

            // 흡연 -> 수면
            title.setText(R.string.job_title);
            title_img.setImageResource(R.drawable.img_sleep_top);   ////???
            Fragment fragment = new JobFragment(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }
    }

    public void jobPrev() {

        // 수면 -> 흡연
        title.setText(R.string.sleep_title);
        title_img.setImageResource(R.drawable.img_food_top);
        Fragment fragment = new SleepFragment(nowContext);
        FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.survey_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }
    public void jobNext(){
        if(StartActivity.dtc.saveData(nowContext)){

            title.setText(R.string.last_title);
            Fragment fragment = new LastFragment(nowContext);
            FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.survey_content, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        }
        else{
            // 유효성 검사 실패 -> 경고창
            openPopup();
        }


    }
    public void lastprev(){
        title.setText(R.string.job_title);
        title_img.setImageResource(R.drawable.img_sleep_top);
        Fragment fragment = new SmokeFragment(nowContext);
        FragmentManager fm = ((FragmentActivity) nowContext).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.survey_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }





    private void openPopup() {
        Intent intent = new Intent(nowContext, PopupActivity.class);
        ((Activity)nowContext).startActivityForResult(intent, 1);
    }
}
