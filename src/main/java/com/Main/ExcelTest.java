package com.Main;

import java.io.IOException;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class ExcelTest extends BaseClass{
  @Test
  public void ExcelTest1() throws IOException {
	  String[][] data = fn_Get2dArrayfromExcel("src\\test\\resources\\JetstarAutomationMatrix_v0.1.xlsx", "testdata");
	  
	  System.out.println("The number of rows in array are: "+data.length);
	  System.out.println("The data in row 5 and col 10 is "+data[1][0]);
	  
	  for(int i = 0; i < data.length; i++)
	  {
	      for(int j = 0; j < data[i].length; j++)
	      {
	          System.out.print(data[i][j]);
	          if(j < data[i].length - 1) System.out.print(" ");
	      }
	      System.out.println();
	  }
	  
  }
}
