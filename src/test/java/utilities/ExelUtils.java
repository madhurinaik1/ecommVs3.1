package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtils {

	public static FileOutputStream fos;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	String path;
	public ExelUtils(String path) {
		this.path=path;
	}

	public  int getRowCount(String xlSheet ) throws IOException{

		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		int rowCount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;


	}

	public  int getCellCount(String xlSheet,int rowNum) throws IOException {

		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		row=sh.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;


	}

	public  String getCellData(String xlSheet,int rowNum, int cellNum) throws IOException {

		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		row=sh.getRow(rowNum);
		cell=row.getCell(cellNum);

		String data;

		try {

			//data=cell.toString();//returns String format of cell data
			DataFormatter df= new DataFormatter();
			data=df.formatCellValue(cell);  // also returns string format of cell data
           
		}catch(Exception e) {	
			data="";
		}

		wb.close();
		fis.close();
		return data;
		

	}
	
	public  void setCellData(String xlSheet,int rowNum, int cellNum, String data) throws IOException {
		
		File xlFile=new File(path);
		if(!xlFile.exists()) {
			wb=new XSSFWorkbook();
			fos=new FileOutputStream(path);
			wb.write(fos);
		}
		
		
		
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		
		if(wb.getSheetIndex(xlSheet)==-1) {
			wb.createSheet(xlSheet);
		}
	
		sh=wb.getSheet(xlSheet);
		
		if(sh.getRow(rowNum)==null) {
			sh.createRow(rowNum);
		}
		
		row=sh.getRow(rowNum);
		cell=row.getCell(cellNum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path) ;
		wb.write(fos);
	    wb.close();
		fis.close();
		fos.close();
		
		
	}


public  void fillGreenColour(String xlSheet,int rowNum, int cellNum) throws IOException {
	
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(xlSheet);
	row=sh.getRow(rowNum);
	cell=row.getCell(cellNum);
	
	style=cell.getCellStyle();
	
	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cell.setCellStyle(style);
	
	fos=new FileOutputStream(path);
	wb.write(fos);
		
	wb.close();
	fis.close();
	fos.close();
	
}

public static void fillRedColour(String xlFile, String xlSheet,int rowNum, int cellNum) throws IOException {

	fis=new FileInputStream(xlFile);
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(xlSheet);
	row=sh.getRow(rowNum);
	cell=row.getCell(cellNum);
	
	style=cell.getCellStyle();
	
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cell.setCellStyle(style);
	
	fos=new FileOutputStream(xlFile);
	wb.write(fos);
		
	wb.close();
	fis.close();
	fos.close();

}


public  void addColumn(String xlSheet, String nwColumnName) throws IOException {
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(xlSheet);
	row=sh.getRow(0);
	
	cell=row.createCell(4);
	
	fos=new FileOutputStream(path);
	wb.write(fos);
	
	
	
//	setCellData(path, xlSheet,0,4, nwColumnName);
	
//	wb.write(fos);
	wb.close();
	fos.close();
	fis.close();
}


}
