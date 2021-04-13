package com.cbu.medical_survey_app.datas;

import android.content.Context;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.JobFragment;
import com.cbu.medical_survey_app.fragments.LastFragment;
import com.cbu.medical_survey_app.fragments.SleepFragment;
import com.cbu.medical_survey_app.fragments.SmokeFragment;

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
    final private SmokeData smoke_data;
    final private SleepData sleep_data;

    public DataController(String name, String address) {
        origin_name = name;
        origin_address = address;
        smoke_data = new SmokeData();
        sleep_data = new SleepData();
        job_data = new JobData();
        last_data = new LastData();
    }

    // survey_content에 연결된 프래그먼트에 따라 저장할 데이터 분기
    public boolean saveData(Context context) {
        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);

        if(nowFragment instanceof LastFragment){
            last_data.saveData(context);
            return last_data.check();
        }
        else if(nowFragment instanceof JobFragment){
            job_data.saveData(context);
//            return job_data.check();
            return true;
        }
        else if(nowFragment instanceof SmokeFragment){
            smoke_data.saveData(context);
//            return smoke_data.check();
            return true;
        }
        else if(nowFragment instanceof SleepFragment){
            sleep_data.saveData(context);
//            return sleep_data.check();
            return true;
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

        return false;
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
            case R.id.last_frag: {
                last_data.setDataToView(vg);
                break;
            }
            case R.id.job_frag: {
                job_data.setDataToView(vg);
                break;
            }
            case R.id.smoke_frag: {
                smoke_data.setDataToView(vg);
                break;
            }
            case R.id.sleep_frag: {
                sleep_data.setDataToView(vg);
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
