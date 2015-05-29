package artem.belskii;

public class Main {

	public static void main(String[] args) {
		Input input  = new Input();
		input.setMethod("console");
		String value1=input.setInput();
		String value2=input.setInput();
		Calc calc = new Calc();
		calc.add(value1, value2);
	}

}
