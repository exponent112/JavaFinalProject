package src.main.java.edu.handong.cess.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ExcelWriter {

	
	
	public ExcelWriter(int rows, int num, String path,String outpath, ArrayList<String> values) {
		String str = path.replaceAll("[^0-9]","");
		FileOutputStream outputStream = null;
		
		if(num==1){
			String rename = outpath.replace(".", "1.");
			int n=0;
			try {
				
				outputStream = new FileOutputStream(rename);
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(outputStream));
				String[] out;
				for(int i=0;i<rows;i++) {
					
					writer.write("000"+str);
					writer.write(",");
					for(int j=0;j<7;j++) {
						while(values.get(n).equals("\n")) n++;
						writer.write(values.get(n));
						writer.write(",");
						n++;
					}
					writer.write("\n");
				}
				writer.flush();
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//if(a = 1)
		else {
			int n=4;
			try {
				String rename = outpath.replace(".", "2.");
				outputStream = new FileOutputStream(rename);
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(outputStream));
				String[] out;
				for(int i=0;i<rows;i++) {
					writer.write("000"+str);
					writer.write(",");
					
					for(int j=0;j<5;j++) {
						writer.write(values.get(n));
						writer.write(",");
						n++;
						//if(n==1) break;
						if(n>=128) break;
					}
					writer.write("\n");
				}
				writer.flush();
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}//catch
		}

	}


//이제 처음에 학번 넣고 돌리기만 하면 된다...
// 
}
	
