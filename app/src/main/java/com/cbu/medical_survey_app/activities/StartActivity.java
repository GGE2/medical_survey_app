package com.cbu.medical_survey_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.datas.DataController;

public class StartActivity extends AppCompatActivity {

    Button btn_main_1;
    public static DataController dtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_portrait);

        // oreintation 에 따라 layout.xml 동적으로 적용
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.main_page_portrait);
        }
        else
            setContentView(R.layout.main_page_landscape);

        btn_main_1 = (Button)findViewById(R.id.btn_main_1);
        EditText main_input_name = (EditText)findViewById((R.id.main_input_name));
        EditText main_input_address = (EditText)findViewById((R.id.main_input_address));

        dtc = new DataController(main_input_name.getText().toString(), main_input_address.getText().toString());


        btn_main_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StartActivity.this, SurveyActivity.class);
                startActivity(intent);



            }
        });



    }


        //화면 밖 클릭시 키보드 종료
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View v = getCurrentFocus();

        if(v != null && (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_MOVE) && v instanceof EditText && !v.getClass().getName().startsWith("android.webkit.")){
            int[] scrcoords = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + v.getLeft() - scrcoords[0];
            float y = event.getRawY() + v.getTop() - scrcoords[1];

            if(x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(event);
    }


//    //name과 address 입력값 확인
//    private boolean checkText(){
//
//
//        return main_input_name.equals(null) && main_input_address.equals(null);
//    }

}