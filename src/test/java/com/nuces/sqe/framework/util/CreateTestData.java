package com.nuces.sqe.framework.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestData {
    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("LoginData");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("username");
            header.createCell(1).setCellValue("password");

            // Data Row 1
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("test_user@example.com");
            row1.createCell(1).setCellValue("password123");

            // Data Row 2
            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("invalid_user@example.com");
            row2.createCell(1).setCellValue("wrongpassword");

            try (FileOutputStream fos = new FileOutputStream("src/test/resources/testdata/login-data.xlsx")) {
                workbook.write(fos);
            }
            System.out.println("Excel file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
