package artem.belskii;

public class Calc {
	public String add(String rawValue1, String rawValue2){
		String result="";
		
		Convert value = new Convert();
		int intResult = value.convert(rawValue1)+value.convert(rawValue2);
		//System.out.println("int result: "+intResult);
		
		result=value.reverseConvert(intResult, value.getType(rawValue1));

		result=result+"("+value.getType(rawValue1)+")";
		System.out.println(rawValue1+"+"+rawValue2+"="+result);
		
		
		
		return result;
	}

}
