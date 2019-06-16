package src.main.java.edu.handong.cess.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader {
	//private HashMap<Integer,String[]> resultForWrite;
	public static int num =0;
	
	public ArrayList<String> getData(String path,String outpath) {
		ArrayList<String> values = new ArrayList<String>();
		
		System.out.println(path);
		
		try (InputStream inp = new FileInputStream(path)) {
		    //InputStream inp = new FileInputStream("workbook.xlsx");
			Workbook wb = WorkbookFactory.create(inp);
	        Sheet sheet = wb.getSheetAt(0);
	        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
	        for(int rowIndex =1; rowIndex < rows; rowIndex++) {
	        	if(rowIndex ==1) {
	        		num++;
	        	}
	        	Row row = sheet.getRow(rowIndex);
	        	
	        	int cells = row.getPhysicalNumberOfCells();
	        	Iterator<Cell> c =row.cellIterator();
	        	int cellIndex =0;
	        	while(c.hasNext()) {
	        		Cell cell = c.next();
	        		cellIndex++;
	        		if (cell == null)
			            cell = row.createCell(cellIndex+1);
	        		
			        if(num==1) {
			        	String t = cell.getStringCellValue().replaceAll("(\r\n|\r|\n|\n\r)", " ").replaceAll(",", "");
			        	//t = t.replaceAll(",", " ");
			        	values.add(t);
			        }
			        else{
			        	String t = cell.getStringCellValue().replaceAll("(\r\n|\r|\n|\n\r)", " ").replaceAll(",", " ");
			        	//values.add(cell.getStringCellValue().replaceAll(",", " ")); 
			        	values.add(t);
			        }
	        		}
	        	}
	        //몇개 있는지랑 몇번째 파일인지랑 그리고 zip이름넘겨서 만들어 주자
	        ExcelWriter aWriter = new ExcelWriter(rows,num,path,outpath,values);
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return values;
	}
	//위에 복붙하는 거 잊지 말자ㅏ아아아아아
	//몇개 있는지랑 몇번째 파일인지랑 그리고 zip이름넘겨서 만들어 주자! thread는 어떻게 하지,,,,,

	public ArrayList<String> getData(InputStream is,String path,String outpath) {
		ArrayList<String> values = new ArrayList<String>();
		try (InputStream inp = is) {
		    //InputStream inp = new FileInputStream("통일한국개론자료수집양식(요약문).xlsx");
    
	        Workbook wb = WorkbookFactory.create(inp);
	        Sheet sheet = wb.getSheetAt(0);
	        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
	        for(int rowIndex =1; rowIndex < rows; rowIndex++) {
	        	if(rowIndex ==1) {
	        		num++;
	        	}
	        	Row row = sheet.getRow(rowIndex);
	        	
	        	int cells = row.getPhysicalNumberOfCells();
	        	for(int cellIndex =0; cellIndex < cells; cellIndex++) {
	        		Cell cell = row.getCell(cellIndex);
	        		if (cell == null)
			            cell = row.createCell(cellIndex+1);
	        		
			        if(num==1) {
			        	String t = cell.getStringCellValue().replaceAll("(\r\n|\r|\n|\n\r)", " ").replaceAll(",", "");
			        	t = t.replaceAll("\n", "");
			        	values.add(t);
			        }
			        else{
			        	values.add(cell.getStringCellValue().replaceAll(",", " ")); 
			        }
	        		}
	        	}
	        //몇개 있는지랑 몇번째 파일인지랑 그리고 zip이름넘겨서 만들어 주자
	        ExcelWriter aWriter = new ExcelWriter(rows,num,path,outpath,values);
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
