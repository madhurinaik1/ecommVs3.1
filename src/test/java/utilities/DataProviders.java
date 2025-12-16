package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
@DataProvider(name="LoginTestData")
public String[][] getData() throws IOException{
	
	String path=".\\testData\\OpenCartTestData.xlsx";
	ExelUtils exelUtil=new ExelUtils(path);
	
	int totalRows=exelUtil.getRowCount("Sheet1");
	int totalCols=exelUtil.getCellCount("Sheet1", 1);
	
	String loginData[][]=new String[totalRows][totalCols];
	
	for(int i=1;i<=totalRows;i++) {
		
		for(int j=0;j<totalCols;j++) {
			
			loginData[i-1][j]=exelUtil.getCellData("Sheet1", i, j);
			
		 }
	}
	return loginData;
	
	
	
}

}
