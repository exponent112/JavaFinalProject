package src.main.java.edu.handong.cess.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import src.main.java.edu.handong.cess.NotEnoughArgumentException;

public class errorOutput {
	public errorOutput(String path) {
		writeAFile(path);
	}

	public static void writeAFile(String name){
		FileOutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream("error.csv");
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(outputStream));
				String[] out;
				writer.write(name);
			}catch (IOException e) {
				NotEnoughArgumentException a = new NotEnoughArgumentException("Can't write");
				e.printStackTrace();
			}//catch
	}
}//csv파일 하나 만들어서 이상한 파일 번호 출
