package com.cbu.medical_survey_app.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.cbu.medical_survey_app.GsonDeserializeExclusion;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.datas.DataController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StartActivity extends AppCompatActivity {

    Button btn_main_1;
    public static DataController dtc;
    EditText main_input_address,main_input_name;
    ViewGroup viewGroup;
    Toolbar toolbar;






    //화면전환시 xml 변경
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.main_page_portrait);

        }
        else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.main_page_landscape);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //oreintation 에 따라 layout.xml 동적으로 적용
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.main_page_portrait);
        }
        else{
            setContentView(R.layout.main_page_landscape);
        }
        //메뉴 toolbar 생성
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        // 외부 저장소 읽기/쓰기 권한 요청
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btn_main_1 = (Button)findViewById(R.id.btn_main_1);
        main_input_name = (EditText)findViewById((R.id.main_input_name));
        main_input_address = (EditText)findViewById((R.id.main_input_address));

        //화면 전환시 데이터유지
        if(savedInstanceState!=null){

            String nData = savedInstanceState.getString("name_Data");
            String aData = savedInstanceState.getString("address_Data");

            main_input_name.setText(nData);
            main_input_address.setText(aData);

        }

        btn_main_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StartActivity.this, SubActivity.class);
                if(checkText()) {
                    dtc = new DataController(main_input_name.getText().toString(), main_input_address.getText().toString());
                    startActivity(intent);
                }
                else{
                    openPopup();
                }
            }
        });



    }


    //menu insert
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    //menu action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(StartActivity.this, MenuPopupActivity.class);
                ((Activity)StartActivity.this).startActivityForResult(intent, 1);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }


    //onDestory() 함수 호출시 데이터 저장
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String saveName = main_input_name.getText().toString();
        String saveAddress = main_input_address.getText().toString();

        outState.putString("name_Data",saveName);
        outState.putString("address_Data",saveAddress);
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

//    private void loadFile(String fileName) {
//        // 공유 폴더에 있는 객체 파일을 SharedPreferences 폴더로 이동
//        copyFile(Environment.getExternalStoragePublicDirectory("Objects").getAbsolutePath(), "/data/data/com.cbu.medical_survey_app/shared_prefs/", "datas.xml");
//
//        SharedPreferences sp = getSharedPreferences("datas", MODE_PRIVATE);
//
//        Gson gson = new GsonBuilder().addDeserializationExclusionStrategy(new GsonDeserializeExclusion()).create();
//
//
//        dtc = gson.fromJson(sp.getString(fileName, ""), DataController.class);
//    }

    //name과 address 입력값 확인
    private boolean checkText(){
        String address_check="";
        String name_check="";

        address_check = main_input_address.getText().toString();
        name_check = main_input_address.getText().toString();

        if(name_check.equals("") || address_check.equals("")) {
            return false;
        }
        else
            return true;

    }
    private void openPopup() {
        Intent intent = new Intent(StartActivity.this, StartPopupActivity.class);
        ((Activity)StartActivity.this).startActivityForResult(intent, 1);
    }


}