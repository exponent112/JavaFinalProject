package src.main.java.edu.handong.cess.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {
	public void run(String name,String outpath) {
		//String path = args[0];
		readFileInZip(name,outpath);
	}

	public void readFileInZip(String path,String outpath) {
		String str = path.replaceAll("[^0-9]","");
		// TODO Auto-generated method stub
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        for(String value:myReader.getData(stream,path,outpath)) {
		        	System.out.println(value);
		        	System.out.println(1);
		        }
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			errorOutput er = new errorOutput("000"+str);
			e.printStackTrace();
		}
	}
		
}

