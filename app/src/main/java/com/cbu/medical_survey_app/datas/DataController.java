package com.cbu.medical_survey_app.datas;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.fragments.FoodFragment_1;
import com.cbu.medical_survey_app.fragments.FoodFragment_11;
import com.cbu.medical_survey_app.fragments.FoodFragment_12;
import com.cbu.medical_survey_app.fragments.FoodFragment_2;
import com.cbu.medical_survey_app.fragments.FoodFragment_3;
import com.cbu.medical_survey_app.fragments.FoodFragment_4;
import com.cbu.medical_survey_app.fragments.FoodFragment_5;
import com.cbu.medical_survey_app.fragments.FoodFragment_6;
import com.cbu.medical_survey_app.fragments.FoodFragment_7;
import com.cbu.medical_survey_app.fragments.FoodFragment_8;
import com.cbu.medical_survey_app.fragments.FoodFragment_9;
import com.cbu.medical_survey_app.fragments.FoodFragment_10;
import com.cbu.medical_survey_app.fragments.JobFragment;
import com.cbu.medical_survey_app.fragments.LastFragment;
import com.cbu.medical_survey_app.fragments.NormalFragment_1;
import com.cbu.medical_survey_app.fragments.NormalFragment_2;
import com.cbu.medical_survey_app.fragments.NormalFragment_3;
import com.cbu.medical_survey_app.fragments.NormalFragment_4;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataController {

    // 설문 시작 시 이름, 주소
    final private String origin_name;
    final private String origin_address;

    final private NormalData_1 normal_data1;
    final private NormalData_2 normal_data2;
    final private NormalData_3 normal_data3;
    final private NormalData_4 normal_data4;
    final private SmokeData smoke_data;
    final private SleepData sleep_data;
    final private FoodData_1 food_data1;
    final private FoodData_2 food_data2;
    final private FoodData_3 food_data3;
    final private FoodData_4 food_data4;
    final private FoodData_5 food_data5;
    final private FoodData_6 food_data6;
    final private FoodData_7 food_data7;
    final private FoodData_8 food_data8;
    final private FoodData_9 food_data9;
    final private FoodData_10 food_data10;
    final private FoodData_11 food_data11;
    final private FoodData_12 food_data12;
    final private JobData job_data;
    final private LastData last_data;

    public DataController(String name, String address) {
        origin_name = name;
        origin_address = address;
        normal_data1 = new NormalData_1();
        normal_data2 = new NormalData_2();
        normal_data3 = new NormalData_3();
        normal_data4 = new NormalData_4();
        smoke_data = new SmokeData();
        sleep_data = new SleepData();
        food_data1 = new FoodData_1();
        food_data2 = new FoodData_2();
        food_data3 = new FoodData_3();
        food_data4 = new FoodData_4();
        food_data5 = new FoodData_5();
        food_data6 = new FoodData_6();
        food_data7 = new FoodData_7();
        food_data8 = new FoodData_8();
        food_data9 = new FoodData_9();
        food_data10 = new FoodData_10();
        food_data11 = new FoodData_11();
        food_data12 = new FoodData_12();
        last_data = new LastData();
        job_data = new JobData();
    }

    // survey_content에 연결된 프래그먼트에 따라 저장할 데이터 분기
    public boolean saveData(Context context) {
        Fragment nowFragment = ((FragmentActivity)context).getSupportFragmentManager().findFragmentById(R.id.survey_content);
        if(nowFragment instanceof NormalFragment_1){
            System.out.println("일반 사항1 Frag");
            normal_data1.saveData(context);
            return normal_data1.check();
        }
        else if(nowFragment instanceof NormalFragment_2){
            System.out.println("일반 사항2 Frag");
            normal_data2.saveData(context);
            return normal_data2.check();
        }
        else if(nowFragment instanceof NormalFragment_3){
            System.out.println("일반 사항3 Frag");
            normal_data3.saveData(context);
            return normal_data3.check();
        }
        else if(nowFragment instanceof NormalFragment_4){
            System.out.println("일반 사항4 Frag");
            normal_data4.saveData(context);
            return normal_data4.check();
        }
        else if(nowFragment instanceof SmokeFragment){
            System.out.println("흡연 및 음주 Frag");
            smoke_data.saveData(context);
            return smoke_data.check();
        }
        else if(nowFragment instanceof SleepFragment){
            System.out.println("수면 육체 활동사항 Frag");
            sleep_data.saveData(context);
            return sleep_data.check();
        }

        else if(nowFragment instanceof FoodFragment_1){
            System.out.println("식품 사항1 Frag:");
            food_data1.saveData(context);
            return food_data1.check();
        }
        else if(nowFragment instanceof FoodFragment_2){
            System.out.println("식품 사항2 Frag:");
            food_data2.saveData(context);
            return food_data2.check();
        }
        else if(nowFragment instanceof FoodFragment_3){
            System.out.println("식품 사항3 Frag:");
            food_data3.saveData(context);
            return food_data3.check();
        }
        else if(nowFragment instanceof FoodFragment_4){
            System.out.println("식품 사항4 Frag:");
            food_data4.saveData(context);
            return food_data4.check();
        }
        else if(nowFragment instanceof FoodFragment_5){
            System.out.println("식품 사항5 Frag:");
            food_data5.saveData(context);
            return food_data5.check();
        }
        else if(nowFragment instanceof FoodFragment_6){
            System.out.println("식품 사항6 Frag:");
            food_data6.saveData(context);
            return food_data6.check();
        }
        else if(nowFragment instanceof FoodFragment_7){
            System.out.println("식품 사항7 Frag:");
            food_data7.saveData(context);
            return food_data7.check();
        }
        else if(nowFragment instanceof FoodFragment_8){
            System.out.println("식품 사항8 Frag:");
            food_data8.saveData(context);
            return food_data8.check();
        }
        else if(nowFragment instanceof FoodFragment_9){
            System.out.println("식품 사항9 Frag:");
            food_data9.saveData(context);
            return food_data9.check();
        }
        else if(nowFragment instanceof FoodFragment_10){
            System.out.println("식품 사항10 Frag:");
            food_data10.saveData(context);
            return food_data10.check();
        }
        else if(nowFragment instanceof FoodFragment_11){
            System.out.println("식품 사항11 Frag:");
            food_data11.saveData(context);
            return food_data11.check();
        }
        else if(nowFragment instanceof FoodFragment_12){
            System.out.println("식품 사항12 Frag:");
            food_data12.saveData(context);
            return food_data12.check();
        }
        else if(nowFragment instanceof JobFragment){
            System.out.println("직업사항 Frag");
            job_data.saveData(context);
            return job_data.check();
        }

        else if(nowFragment instanceof LastFragment){
            System.out.println("설문 완료 Frag");
            last_data.saveData(context);
            return last_data.check();
        }



        else {
            System.out.println("아님");
        }

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
            case R.id.normalfrag_4:{
                normal_data4.setDataToView(vg);
                break;
            }
            case R.id.smoke_frag: {
                smoke_data.setDataToView(vg);
                break;
            }
            case R.id.sleep_frag:{
                sleep_data.setDataToView(vg);
                break;
            }
            case R.id.food_frag_1: {
                food_data1.setDataToView(vg);
                break;
            }
            case R.id.food_frag_2: {
                food_data2.setDataToView(vg);
                break;
            }
            case R.id.food_frag_3: {
                food_data3.setDataToView(vg);
                break;
            }
            case R.id.food_frag_4: {
                food_data4.setDataToView(vg);
                break;
            }
            case R.id.food_frag_5: {
                food_data5.setDataToView(vg);
                break;
            }
            case R.id.food_frag_6: {
                food_data6.setDataToView(vg);
                break;
            }
            case R.id.food_frag_7: {
                food_data7.setDataToView(vg);
                break;
            }
            case R.id.food_frag_8:{
                food_data8.setDataToView(vg);
                break;

            }
            case R.id.food_frag_9:{
                food_data9.setDataToView(vg);
                break;

            }
            case R.id.food_frag_10:{
                food_data10.setDataToView(vg);
                break;
            }
            case R.id.food_frag_11:{
                food_data11.setDataToView(vg);
                break;
            }
            case R.id.food_frag_12:{
                food_data12.setDataToView(vg);
                break;
            }
            case R.id.job_frag: {
                job_data.setDataToView(vg);
                break;
            }
            case R.id.last_frag: {
                last_data.setDataToView(vg);
                break;
            }

        }

    }

    public void saveExcel(Context context) {
        Workbook workbook = new HSSFWorkbook();

        ArrayList<LinkedHashMap<String, String>> array = new ArrayList<>();
        array.add(normal_data1.getData());
        array.add(normal_data2.getData());
        array.add(normal_data3.getData());
        array.add(normal_data4.getData());
        makeSheet(workbook, array, "일반 사항");

        array.clear();
        array.add(smoke_data.getData());
        makeSheet(workbook, array, "흡연 및 음주 습관 사항");

        array.clear();
        array.add(sleep_data.getData());
        makeSheet(workbook, array, "수면_육체적 운동 및 활동 사항");

        array.clear();
        array.add(food_data1.getData());
        array.add(food_data2.getData());
        array.add(food_data3.getData());
        array.add(food_data4.getData());
        array.add(food_data5.getData());
        array.add(food_data6.getData());
        makeSheet(workbook, array, "식품 섭취 빈도 조사1");

        array.clear();
        array.add(food_data7.getData());
        array.add(food_data8.getData());
        array.add(food_data9.getData());
        array.add(food_data10.getData());
        array.add(food_data11.getData());
        array.add(food_data12.getData());
        makeSheet(workbook, array, "식품 섭취 빈도 조사2");


        array.clear();
        array.add(job_data.getData());
        makeSheet(workbook, array, "직업 사항");

        array.clear();
        last_data.getData().put("본인 주소2", origin_address);
        array.add(last_data.getData());
        makeSheet(workbook, array, "본인 정보");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String curDate = format.format(new Date());

        ContextWrapper cw = new ContextWrapper(context);
        File xlsFile = new File(cw.getExternalFilesDir(""), origin_name + "_" + curDate + ".xls");

        try{
            FileOutputStream os = new FileOutputStream(xlsFile);
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(xlsFile.getAbsolutePath() + "에 저장됨");
    }

    private void makeSheet(Workbook workbook, ArrayList<LinkedHashMap<String, String>> datas, String shName) {

        // 새로운 sheet 생성, 열 기본 너비 지정
        Sheet sheet = workbook.createSheet(shName);
        sheet.setColumnWidth(0, 50 * 512);
        sheet.setColumnWidth(1, 20 * 512);

        Row row;
        Cell cell;

        int idx = 0;

        // 해시맵 배열을 모두 돔
        for (LinkedHashMap<String, String> data : datas) {

            // 데이터 삽입
            for (Map.Entry<String, String> entry: data.entrySet()) {
                row = sheet.createRow(idx++);

                cell = row.createCell(0);
                cell.setCellValue(entry.getKey());

                cell = row.createCell(1);
                cell.setCellValue(entry.getValue());
            }
        }
    }
}
