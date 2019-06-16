package src.main.java.edu.handong.cess;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import src.main.java.edu.handong.cess.util.ExcelWriter;
import src.main.java.edu.handong.cess.util.ZipReader;
import src.main.java.edu.handong.cess.util.errorOutput;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;

public class JavaFinalProject {
	String dataPath;
	String resultPath;
	boolean help;

	public void InFile() {
		String path = this.dataPath;
		File dir = new File(path);
		File [] fileList = dir.listFiles();
		
		HashMap <String,HashMap<String, ForArrayList>> nm =new HashMap <String,HashMap<String, ForArrayList>>();
		for(File file : fileList) {
			if(file.isFile()) {
				String fileName = file.getName();
				System.out.println(fileName);
				if(fileName.equals(".DS_Store")) continue;
				ChatThread chatthread = new ChatThread(fileName);
				chatthread.start();
				try {
					chatthread.join();
					nm.put(chatthread.getfName(),chatthread.getForW());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(chatthread.forW.get(chatthread.fName).getnForWa().get(1));
			}	
		}
		Map <String,HashMap<String, ForArrayList>> sortedM = new TreeMap <String,HashMap<String, ForArrayList>>(nm); 
		ExcelWriter op = new ExcelWriter(2,sortedM,resultPath);
		
		
	}
	
	class ChatThread1 extends Thread{
		private String fName;
		private int number =1;
		private ArrayList<String> nForWrite;
		public HashMap <String,ForArrayList> forW = new HashMap <String,ForArrayList>() ;
		
		public HashMap<String, ForArrayList> getForW() {
			return forW;
		}

		public ArrayList<String> getnForWrite() {
			return nForWrite;
		}
		
		public void addnForWrite(String a) {
			nForWrite.add(a);
		}
		
		public ChatThread1(String name){
			fName = name;
		}
		
		public void run() {
			ZipReader zipR =new ZipReader();
			nForWrite = zipR.run(number,dataPath+"/"+fName,resultPath,fName);
			ForArrayList a = new ForArrayList();
			System.out.println(nForWrite.get(1));
			a.setnForWa(nForWrite);
			forW.put(fName, a);
			//ExcelWriter(int rows, int num, String path,String outpath, ArrayList<String> values)
		}
	}
	
	
	class ChatThread extends Thread{
		private String fName;
		public String getfName() {
			return fName;
		}

		private int number=2;
		
		private ArrayList<String> nForWrite;
		public HashMap <String,ForArrayList> forW = new HashMap <String,ForArrayList>() ;

		public HashMap<String, ForArrayList> getForW() {
			return forW;
		}
		
		public ArrayList<String> getnForWrite() {
			return nForWrite;
		}
		
		public void addnForWrite(String a) {
			nForWrite.add(a);
		}
		
		public ChatThread(String name){
			fName = name;
		}
		
		public void run() {
			ZipReader zipR =new ZipReader();
			nForWrite = zipR.run(number,dataPath+"/"+fName,resultPath,fName);
			ForArrayList a = new ForArrayList();
			System.out.println(nForWrite.get(1));
			a.setnForWa(nForWrite);
			System.out.println(a.getnForWa().get(1));
			forW.put(fName, a);
			
		}
	}
	
	public void run(String[] args) throws IOException {
		Options options = createOptions();
		if(parseOptions(options, args)){
		}
		InFile();
		
		
	}
	
	private Options createOptions() {
		Options options = new Options();
		options.addOption(Option.builder("i").longOpt("input")
			     .desc("Set an input file path")
			     .hasArg()
			     .argName("input path")
			     .required()
			     .build());
		
		options.addOption(Option.builder("o").longOpt("output")
	     .desc("Set an output file path")
	     .hasArg()
	     .argName("output path")
	     .required()
	     .build());
		
		return options;
	}
	
	//파일명들을 받아온다.
	//thread로 처리 
	//Array

	
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {

			CommandLine cmd = parser.parse(options, args);
			
			this.dataPath = cmd.getOptionValue("i");
			this.resultPath = cmd.getOptionValue("o");

		} catch (Exception e) {
			NotEnoughArgumentException a = new NotEnoughArgumentException("You did not give the necessary parameters.");
			return false;
		}

		return true;
	}//parseOptions
	
}
