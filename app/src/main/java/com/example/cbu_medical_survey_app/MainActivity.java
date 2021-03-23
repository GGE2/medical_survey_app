package com.example.cbu_medical_survey_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cbu_medical_survey_app.fragments.normal_fragment_2;

public class MainActivity extends AppCompatActivity {

    Button btn_main_1;
    EditText main_input_name,main_input_address;



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
        main_input_name = (EditText)findViewById((R.id.main_input_name));
        main_input_address = (EditText)findViewById((R.id.main_input_address));

        btn_main_1.setClickable(false);


        btn_main_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);



            }
        });



    }

    private boolean checkText(){


        return main_input_name.equals(null) && main_input_address.equals(null);
    }

}