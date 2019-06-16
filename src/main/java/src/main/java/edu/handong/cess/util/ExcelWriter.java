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
				writer.write("Student number");
				writer.write(",");
				writer.write("제목");
				writer.write(",");
				writer.write("요약문 (300자 내외)");
				writer.write(",");
				writer.write("\"핵심어\n" + 
						"(keyword,쉽표로 구분)\"");
				writer.write(",");
				writer.write("조회날짜");
				writer.write(",");
				writer.write("\"실제자료조회\n" + 
						"출처 (웹자료링크)\"");
				writer.write(",");
				writer.write("원출처 (기관명 등)");
				writer.write(",");
				writer.write("\"제작자\n" + 
						"(Copyright 소유처)\"");
				writer.write("\n");
				System.out.println("");
				for(int i=1;i<rows;i++) {
					
					writer.write("000"+str);
					writer.write(",");
					for(int j=0;j<7;j++) {
						//while(values.get(n).equals("\n")) n++;
						writer.write(values.get(n));
						writer.write(",");
						n++;
						if(n>=35) break;
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
			int n=5;
			try {
				String rename = outpath.replace(".", "2.");
				outputStream = new FileOutputStream(rename);
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(outputStream));
				String[] out;
				writer.write("Student number");
				writer.write(",");
				writer.write("제목(반드시 요약문 양식에 입력한 제목과 같아야 함.)");
				writer.write(",");
				writer.write("표/그림 일련번호");
				writer.write(",");
				writer.write("\"자료유형(표,"+"그림"+","+"…)\"");
				writer.write(",");
				writer.write("자료에 나온 표나 그림 설명(캡션)");
				writer.write(",");
				writer.write("자료가 나온 쪽번호");
				writer.write("\n");
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
	
