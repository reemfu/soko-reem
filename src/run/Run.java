package run;

import java.io.IOException;

import cli.CLI;

public class Run {
	
	public static void main(String args[]) {
	
		CLI cli = new CLI();
		
		while (!cli.isExit()) {
			try 
			{
				cli.run();	
			} 
			catch (IOException e) {e.printStackTrace();}
		}
	}
}
