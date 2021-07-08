package com.cbu.medical_survey_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.cbu.medical_survey_app.GsonDeserializeExclusion;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.datas.DataController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuPopupActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private File file;
    private File get_File;
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.aler_menu);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();

        text = (EditText)findViewById(R.id.editSearch);

        text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i == keyEvent.KEYCODE_ENTER)
                    return true;

                return false;
            }
        });

        settingList();

        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        adapter = new SearchAdapter(list, this);
        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });


        get_File = new File("/sdcard/Excels");
        File file_list[] = get_File.listFiles();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String fileName = file_list[i].getName();
                int cIndex = fileName.indexOf(".");
                String fN = fileName.substring(0,cIndex);

                Intent intent = new Intent(MenuPopupActivity.this, SubActivity.class);
                loadFile(fN);
                startActivity(intent);

            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    private void settingList() {

        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Excels");

        File f_list[] = file.listFiles();

        for(int i=0;i<f_list.length;i++){
            list.add(f_list[i].getName());
        }





    }
    public void popupClose(View v) {
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        return;
    }

    private void loadFile(String fileName) {
        // 공유 폴더에 있는 객체 파일을 SharedPreferences 폴더로 이동
        copyFile(Environment.getExternalStoragePublicDirectory("Objects").getAbsolutePath(), "/data/data/com.cbu.medical_survey_app/shared_prefs/", "datas.xml");

        SharedPreferences sp = getSharedPreferences("datas", MODE_PRIVATE);

        Gson gson = new GsonBuilder().addDeserializationExclusionStrategy(new GsonDeserializeExclusion()).create();


        StartActivity.dtc = gson.fromJson(sp.getString(fileName, ""), DataController.class);
    }

    private void copyFile(String filePath_from, String filePath_to, String file){
        InputStream from = null;
        OutputStream to = null;

        try{

            from = new FileInputStream(filePath_from + "/" + file);
            to = new FileOutputStream(filePath_to + "/" + file);

            byte[] buffer = new byte[1024];
            int read;
            while((read = from.read(buffer)) != -1) {
                to.write(buffer, 0, read);
            }
            from.close();
            from = null;

            to.flush();
            to.close();
            to = null;
        } catch(FileNotFoundException e){
            Log.e("File Not Found", e.getMessage());
        } catch (Exception e) {
            Log.e("File Error", e.getMessage());
        }
    }
}
