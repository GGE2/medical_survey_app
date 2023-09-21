# CBU_MEDICAL_SURVEY_APP
-----------------------------------------------------------------
### 프로젝트 계획
+ [병원]
> 병원의 경우 환자의 진료 전 체크사항으로 다양하게 검진할 내용이 많지만 대부분 수기로 작성하기 때문에 수십장이 넘는 설문 문항에 대한 데이터를취합하기 힘들 뿐더러 특정 환자에 대한 정보 검색 및 수정사항에 있어 관리하기 어려움이 많다  
따라서 설문지 앱을 따로 만들어 환자에 대한 정보와 설문 내용을 저장하고 불러올수 있게 만든다면 환자 전체에 대한 데이터를 취합하는데 있어 훨씬 수월할 뿐만 아니라 특정 환자의 특정 검진 내용 부분 검색에 있어서도 편리하게 할 수 있으므로 앱을 만들기로 기획
+ [환자]
> 수십장이 넘는 설문 문항을 한번에 하기에는 환자에게 부담이되고 지루함을 유발하여 정확환 답변을 하지 않는 경우가 있음  
> 또한 그림 사진의 경우 노약자의 경우 잘 안보이는 경우가 있어 부담이됨
> 앱을 만들어 사용할 경우 태블릿을 들고다니며 환자가 여유가 될때 언제든지 설문지를 작성할 수 있고 지루할 경우 잠깐 쉬었다가 설문지를 다시 불러와 언제든지 설문할 수 있음  
> 또한 앱은 글씨 , 또는 사진이 잘 안보이는 경우 확대하여 볼 수 있기 때문에 환자에게 편리함 
### 기능
----------------------------------------------------------------
+ #### [검색]
1.설문이 종료되면 설문 내용은 Excel 파일로 변환되어 저장 (JSON Object)  
2.환자의 고유번호로 저장된 Excel 파일로 들어가 특정 column 검색
```
public void saveExcel(Context context) {
        Workbook workbook = new HSSFWorkbook();

        ArrayList<LinkedHashMap<String, String>> array = new ArrayList<>();
      
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
        Sheet sheet = workbook.createSheet(shName);
        sheet.setColumnWidth(0, 50 * 512);
        sheet.setColumnWidth(1, 20 * 512);

        Row row;
        Cell cell;

        int idx = 0;

      
        for (LinkedHashMap<String, String> data : datas) {
            for (Map.Entry<String, String> entry: data.entrySet()) {
                row = sheet.createRow(idx++);

                cell = row.createCell(0);
                cell.setCellValue(entry.getKey());

                cell = row.createCell(1);
                cell.setCellValue(entry.getValue());
            }
        }
    }


```

-----------------------------------------------------------------
+ #### [수정]
1.앱 초기화면 파일 불러오기를 통해 저장된 엑셀파일을 다시 JAVA OBJECT로 변환(JSON -> JAVA OBJECT)
2.수정하고자 하는 부분 수정  
3.기존 엑셀파일은 삭제하고 새로운 파일 저장  
```
 private void loadFile(String fileName) {
        
        copyFile(Environment.getExternalStoragePublicDirectory("Objects").getAbsolutePath(), "/data/data/com.cbu.medical_survey_app/shared_prefs/", "datas.xml");

        SharedPreferences sp = getSharedPreferences("datas", MODE_PRIVATE);

        Gson gson = new GsonBuilder().addDeserializationExclusionStrategy(new GsonDeserializeExclusion()).create();
    }
```

-----------------------------------------------------------------
+ #### [유효성 검사]
1. 체크항목을 하지 않고 넘어가거나 설문하지 않은 페이지의 경우 유효성 검사를 통해 알림
