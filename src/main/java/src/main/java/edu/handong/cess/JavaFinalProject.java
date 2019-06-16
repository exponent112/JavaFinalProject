package src.main.java.edu.handong.cess;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import src.main.java.edu.handong.cess.util.ZipReader;
import src.main.java.edu.handong.cess.util.errorOutput;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;

public class JavaFinalProject {
	String dataPath;
	String resultPath;
	boolean help;
	
	public void run(String[] args) throws IOException {
		Options options = createOptions();
		//Options options = createOptions();
		if(parseOptions(options, args)){
		}
		ZipReader zipR =new ZipReader();
		zipR.run(dataPath,resultPath);
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
