package utils;

import com.itextpdf.text.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import usertypes.Person;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import static directories.Directories.OUTPUT_DATA_DIRECTORY;

public abstract class WriteFileUtil {

    /** Запись в exele
     * @return void
     */
    public static void createExeleFile(ArrayList<Person> dataList){

        String[] args;

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Лист с данными");

        int rowNum = 0;

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Имя");
        row.createCell(1).setCellValue("Фамилия");
        row.createCell(2).setCellValue("Отчество");
        row.createCell(3).setCellValue("Возраст");
        row.createCell(4).setCellValue("Пол");
        row.createCell(5).setCellValue("Дата рождения");
        row.createCell(6).setCellValue("Место рождения");
        row.createCell(7).setCellValue("Место жительства");

        // заполняем лист данными
        for (Person dataModel : dataList) {
            createSheetHeader(sheet, ++rowNum, dataModel);
        }

        Date today = Calendar.getInstance().getTime();
        Format formatter = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
        String reportDate = formatter.format(today);

        String fileDir = OUTPUT_DATA_DIRECTORY + "TestData "+ reportDate +".xls";
        try {
            FileOutputStream out = new FileOutputStream(new File(fileDir));
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл создан. Путь: " + fileDir);
    }

    private static void createSheetHeader(HSSFSheet sheet, int rowNum, Person dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getFirstName());
        row.createCell(1).setCellValue(dataModel.getSecondName());
        row.createCell(2).setCellValue(dataModel.getLastName());
        row.createCell(3).setCellValue(dataModel.getAge());
        row.createCell(4).setCellValue(dataModel.getSex());
        row.createCell(5).setCellValue(dataModel.getBirthDate());
        row.createCell(6).setCellValue(dataModel.getBirthCity());
        row.createCell(7).setCellValue(dataModel.getLocation());
    }

    /** Запись в pdf
     * @return void
     */
    public static void createPdfFile(ArrayList<Person> dataList){

        Document pdfDoc = new Document(PageSize.A4_LANDSCAPE, 20, 20, 20, 20);

    }



}
