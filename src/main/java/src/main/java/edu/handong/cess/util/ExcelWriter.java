package src.main.java.edu.handong.cess.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import src.main.java.edu.handong.cess.ForArrayList;
import src.main.java.edu.handong.cess.ListNode;

public class ExcelWriter {
	public String rename;
	public ExcelWriter(int number,ListNode s,String outpath) {
		FileOutputStream outputStream = null;
		
		if(number==1){
			rename = outpath.replace(".", "1.");
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
				Set key = s.getData().keySet();
				for (Iterator iterator = key.iterator(); iterator.hasNext();) {
		            String keyName = (String) iterator.next();
	            	writer.write(keyName.replace(".zip", ""));
					writer.write(",");
					int t=5;
					while(t<s.getData().get(keyName).getnForWb().size()) {
						writer.write(s.getData().get(keyName).getnForWb().get(t));
						if(t%7==0) {
		            		writer.write("\n");
		            		writer.write(keyName.replace(".zip", ""));
							writer.write(",");
		            	}
		            	else writer.write(",");
		            	t++;
					}
				}
		
				writer.flush();
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			//catch
		}//if(a = 1)
		}
	
		else {
			int n=5;
			try {
				rename = outpath.replace(".", "2.");
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
				Set key = s.getData().keySet();
				for (Iterator iterator = key.iterator(); iterator.hasNext();) {
		            String keyName = (String) iterator.next();
	            	writer.write(keyName.replace(".zip", ""));
					writer.write(",");
					int t=5;
					while(t<s.getData().get(keyName).getnForWa().size()) {
						writer.write(s.getData().get(keyName).getnForWa().get(t));
						if(t%7==0) {
		            		writer.write("\n");
		            		writer.write(keyName.replace(".zip", ""));
							writer.write(",");
		            	}
		            	else writer.write(",");
		            	t++;
					}
				}
				writer.flush();
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}//catch
		}

	}
// 
}

	
