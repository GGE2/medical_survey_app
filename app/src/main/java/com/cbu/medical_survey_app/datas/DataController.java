package com.cbu.medical_survey_app.datas;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.JobFragment;
import com.cbu.medical_survey_app.fragments.LastFragment;
import com.cbu.medical_survey_app.fragments.NormalFragment_1;
import com.cbu.medical_survey_app.fragments.NormalFragment_2;
import com.cbu.medical_survey_app.fragments.NormalFragment_3;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class DataController {

    // 설문 시작 시 이름, 주소
    final private String origin_name;
    final private String origin_address;

    final private LastData last_data;
    final private JobData job_data;
    final private NormalData_1 normal_data1;
    final private NormalData_2 normal_data2;
    final private NormalData_3 normal_data3;
    final private NormalData_4 normal_data4;

    public DataController(String name, String address) {
        origin_name = name;
        origin_address = address;
        last_data = new LastData();
        job_data = new JobData();
        normal_data1 = new NormalData_1();
        normal_data2 = new NormalData_2();
        normal_data3 = new NormalData_3();
        normal_data4 = new NormalData_4();
    }

//    // survey_content에 연결된 프래그먼트에 따라 저장할 데이터 분기
    public boolean saveData(Context context) {
        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);
        if(nowFragment instanceof NormalFragment_1){
            System.out.println("일반 사항1 Frag");
            normal_data1.saveData(context);
            //return normal_data1.check();
        }
        else if(nowFragment instanceof NormalFragment_2){
            System.out.println("일반 사항2 Frag");
            normal_data2.saveData(context);
            //return normal_data2.check();
        }
        else if(nowFragment instanceof NormalFragment_3){
            System.out.println("일반 사항3 Frag");
            normal_data3.saveData(context);
            //return normal_data3.check();
        }

        else if(nowFragment instanceof LastFragment){
            System.out.println("설문 완료 Frag");
            last_data.saveData(context);
            //return vc.lastChecker(last_data.getData());
        }

        else if(nowFragment instanceof JobFragment){
            System.out.println("직업사항 Frag");
            job_data.saveData(context);

        }
        else {
            System.out.println("아님");
        }

//        if(openAlert) {
//            System.out.println("경고창 띄우는 로직");
//        }
//        else{
//            System.out.println("다음 페이지 가는 로직");
//        }

        return true;
    }

//    public HashMap<String, String> getData(Context context) {
//        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);
//
//        if(nowFragment instanceof Last_Fragment){
//            System.out.println("맞음");
//            return last_data.getData();
//        }
//        else {
//            System.out.println("아님");
//            return null;
//        }
//    }

    public void setDataToView(ViewGroup vg) {
        switch (vg.getId()) {

            case R.id.normal_frag_1:{
                normal_data1.setDataToView(vg);
                break;
            }
            case R.id.normalfrag_2:{
                normal_data2.setDataToView(vg);
                break;
            }
            case R.id.normalfrag_3:{
                normal_data3.setDataToView(vg);
                break;
            }
//            case R.id.normalfrag_4:{
//                normal_data3.setDataToView(vg);
//                break;
//            }

            case R.id.last_frag: {
                last_data.setDataToView(vg);
                break;
            }
            case R.id.job_frag: {
                job_data.setDataToView(vg);
                break;
            }
        }

    }

    public void saveExcel(Context context) {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);
        Cell cell;

        int idx = 0;

        for (Map.Entry<String, String> entry: job_data.getData().entrySet()) {
            cell = row.createCell(idx++);
            cell.setCellValue(entry.getKey());
            System.out.println(entry.getKey());
        }

        File xlsFile = new File(context.getExternalFilesDir(null), "text.xls");

        try{
            FileOutputStream os = new FileOutputStream(xlsFile);
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(xlsFile.getAbsolutePath() + "에 저장됨");
    }
}
