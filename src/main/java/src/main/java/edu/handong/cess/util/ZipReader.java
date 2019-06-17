package src.main.java.edu.handong.cess.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {
	public ArrayList<String> values2;
	public ArrayList<String> run(int number,String name,String outpath,String fName) {
		//String path = args[0];
		return readFileInZip(number,name,outpath,fName);
	}

	public ArrayList<String> readFileInZip(int number,String path,String outpath,String fName) {
		String str = fName.replaceAll("[^0-9]","");
		// TODO Auto-generated method stub
		ZipFile zipFile=null;
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		        ExcelReader myReader = new ExcelReader();
		        
		        
		        values2 =  myReader.getData(number,stream,path,outpath,fName);
		  
		        
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			errorOutput er = new errorOutput("000"+str);
			e.printStackTrace();
		}
		
		try {
			try {
				zipFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
		}
		
		return values2;
	}
}

