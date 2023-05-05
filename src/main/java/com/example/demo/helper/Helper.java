package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.entity.Category;

public class Helper {
	public static String []HEADER= { "id","title","decription","coverImage"};
	public static String SHEET_NAME="category_data";
	
	public  static ByteArrayInputStream DatabaseToExcel(List<Category> list) throws IOException {
		//create workbook
		Workbook workbook=new XSSFWorkbook();
		 ByteArrayOutputStream out=new ByteArrayOutputStream();
		try { 
			 //create workbook sheet
			 Sheet sheet=workbook.createSheet(SHEET_NAME);
			  
			 //Header add 
			 Row row=sheet.createRow(0);
			 try {
				for(int i=0;i<HEADER.length;i++) {
					Cell cell= row.createCell(i);
					 try {
						cell.setCellValue(HEADER[i]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //value of rows
			 int rowIndex=1;
			 for(Category c:list) {
				 Row dataRow=sheet.createRow(rowIndex);
				 rowIndex++;
				 dataRow.createCell(0).setCellValue(c.getCategoryId());
				 dataRow.createCell(1).setCellValue(c.getTitle());
				 dataRow.createCell(2).setCellValue(c.getDescription());
				 dataRow.createCell(3).setCellValue(c.getCoverImage());
			 }
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to IMPORT data excel");
			return null;
		}finally {
			 workbook.close();
			 out.close();
			 
		}
		
	}

}
