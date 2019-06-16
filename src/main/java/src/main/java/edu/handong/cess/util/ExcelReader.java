package src.main.java.edu.handong.cess.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.main.java.edu.handong.cess.JavaFinalProject;



public class ExcelReader {
	//private HashMap<Integer,String[]> resultForWrite;
	public static int num =0;
	public int rows;
	public int cells;
	public ArrayList<String> getData(int number, InputStream is,String path,String outpath,String fName) {
		ArrayList<String> values = new ArrayList<String>();
		try (InputStream inp = is) {
		    //InputStream inp = new FileInputStream("통일한국개론자료수집양식(요약문).xlsx");
			
			//Workbook wb = new XSSFWorkbook(inp);
			XSSFWorkbook wb = new XSSFWorkbook(inp);

			//출처: https://javaslave.tistory.com/78 [전산쟁이 블로그]
			XSSFSheet sheet = wb.getSheetAt(0);
	        rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
	        for(int rowIndex =1; rowIndex < rows; rowIndex++) {
	        	if(rowIndex ==1) {
	        		num++;
	        	}
	        	XSSFRow row = sheet.getRow(rowIndex);
	        	int cells = row.getPhysicalNumberOfCells();
	        	for(int cellIndex =0; cellIndex < cells; cellIndex++) {
	        		XSSFCell cell=row.getCell(cellIndex);
	        		if(cell==null) {
	        			values.add(" ");
	        		}else {
                         // cell 스타일이 다르더라도 String으로 반환 받음
                         switch (cell.getCellType()){
                         case XSSFCell.CELL_TYPE_FORMULA:
                             values.add(cell.getCellFormula()+"");
                             break;
                         case XSSFCell.CELL_TYPE_NUMERIC:
                        	 values.add(cell.getNumericCellValue()+"");
                           
                             break;
                         case XSSFCell.CELL_TYPE_STRING:
                        	 values.add(cell.getStringCellValue()+"");
                            
                             break;
                         case XSSFCell.CELL_TYPE_BLANK:
                        	 values.add(" ");
                             break;
//                         case HSSFCell.CELL_TYPE_ERROR:
//                             value = curCell.getErrorCellValue()+"";
//                             break;
                         default:
                            // value = new String();
                             break;
                         }
	        		}
	        	}
	        }
	        //몇개 있는지랑 몇번째 파일인지랑 그리고 zip이름넘겨서 만들어 주자
	        if(number ==1&&num==1) {
	        	return values;
	        }
	        //ExcelWriter aWriter = new ExcelWriter(rows,num,path,outpath,values);
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return values;
	}
}
