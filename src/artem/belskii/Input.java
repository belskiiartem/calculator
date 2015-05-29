package artem.belskii;

import java.io.Console;
import java.util.Scanner;

public class Input {
	private String method= "console";
	Input(String method){
		this.setMethod(method);
	}
	Input(){}
	public void setMethod(String method){
		method=this.method;
	}
	public String getMethod(){
		return method;
	}
	public String setInput(){
		String input="";
		if (this.getMethod().equals("console")){
			input=this.getConsoleInput();
		}
		return input;
	}
	private String getConsoleInput(){
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("¬ведите значение:");
		String input = consoleIn.nextLine();
		return input.toUpperCase();
		
	}
}
