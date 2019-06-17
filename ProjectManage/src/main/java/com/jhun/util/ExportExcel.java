package com.jhun.util;

import com.jhun.entity.Record;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExportExcel {

    public String batchExportCount(HttpServletResponse response, List<Record> list) {
        //Excel共有两种格式：xls（03版本）和xlsx（07及之后版本）。POI提供了两个对应接口类，分别为：HSSFWorkbook和XSSFWorkbook
        String excelVesion="07";
        response.setContentType("application/octet-stream");
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        try {
            String[] headers = { "序号","日志类型", "所属项目", "项目负责人", "创建人", "创建时间", "日志内容"};
            if(excelVesion.equals("03")) {

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("项目日志");//sheet栏
                String fileName = "项目日志"  + ".xls";//设置要导出的文件的名字
                //headers表示excel表中第一行的 表头
                HSSFRow row = sheet.createRow(0);
                //在excel表中添加  表头
                for(int i=0;i<headers.length;i++){
                    HSSFCell cell = row.createCell(i);//列
                    HSSFRichTextString text = new HSSFRichTextString(headers[i]);//内容
                    cell.setCellValue(text);//设置列内容
                }
                //在表中存放查询到的数据放入对应的列
                HSSFRow row1 =null;
                for (Record record : list) {
                    row1 = sheet.createRow(rowNum);
                    row1.createCell(0).setCellValue(record.getId());//第一列
                    row1.createCell(1).setCellValue(record.getRecordCategory());
                    row1.createCell(2).setCellValue(record.getProjectName());
                    row1.createCell(3).setCellValue(record.getProjectCharger());
                    row1.createCell(4).setCellValue(record.getFounder());
                    row1.createCell(5).setCellValue(record.getCreateTime());
                    row1.createCell(6).setCellValue(record.getContent());
                    rowNum++;
                }
                //java.net.URLEncoder.encode 防止中文乱码
                response.setHeader("Content-disposition", "attachment;filename="+ java.net.URLEncoder.encode(fileName, "UTF-8"));
                response.flushBuffer();
                workbook.write(response.getOutputStream());
            }if(excelVesion.equals("07")) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("项目日志");//sheet栏
                String fileName = "项目日志"  + ".xlsx";//设置要导出的文件的名字
                //headers表示excel表中第一行的 表头
                XSSFRow row = sheet.createRow(0);
                //在excel表中添加  表头
                for(int i=0;i<headers.length;i++){
                    XSSFCell cell = row.createCell(i);//列
                    XSSFRichTextString text = new XSSFRichTextString(headers[i]);//内容
                    cell.setCellValue(text);//设置列内容
                }
                //在表中存放查询到的数据放入对应的列
                XSSFRow row1 = null;
                for (Record record : list) {
                    row1 = sheet.createRow(rowNum);
                    row1.createCell(0).setCellValue(record.getId());//第一列
                    row1.createCell(1).setCellValue(record.getRecordCategory());
                    row1.createCell(2).setCellValue(record.getProjectName());
                    row1.createCell(3).setCellValue(record.getProjectCharger());
                    row1.createCell(4).setCellValue(record.getFounder());
                    row1.createCell(5).setCellValue(record.getCreateTime());
                    row1.createCell(6).setCellValue(record.getContent());
                    rowNum++;
                }
                response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
                response.flushBuffer();
                workbook.write(response.getOutputStream());
            }
        } catch (IOException e) {
            return "false";
        }
        return "success";
    }
}
