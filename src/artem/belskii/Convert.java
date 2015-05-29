package artem.belskii;

import java.util.ArrayList;

public class Convert {
	
public String getType(String rawValue){
		String answer="";
		String [] value=rawValue.split("\\(");
		if (value.length>1){
		String dirtyType=value[1];
		String [] dirtyArrType=dirtyType.split("\\)");
		answer = dirtyArrType[0].toString();
		} else {
			answer = "dec";
		}
		return answer;
	}
	
public int convert(String rawValue){
	String [] value=rawValue.split("\\(");
	int answer=0;

	if (this.getType(rawValue).equals("dec")){
		answer = this.strToInt(value[0]);
	}
	else if (this.getType(rawValue).equals("16")){
		answer=this.hexToInt(value[0]);
	}else if(this.getType(rawValue).toLowerCase().equals("r")){
		answer=this.romeToInt(value[0]);
	} else if(this.getType(rawValue).equals("2")){
		answer=this.binToInt(value[0]);
	} else{ System.out.println("undefinded number type");}

	return answer;

}

public String reverseConvert(int value, String type){
	String answer="";
	if (type.equals("dec")){
		answer = this.intToStr(value);
	}
	else if (type.equals("16")){
		answer=this.intToHex(value);
	}else if (type.equals("2")){
		answer=this.intToBin(value);
	}else if (type.toLowerCase().equals("r")){
		answer=this.intToRome(value);
	}else{ System.out.println("undefinded number type");}
	
	return answer;
}

private int strToInt(String value){
	return Integer.parseInt(value);
}

private String intToStr(int value){
	return Integer.toString(value);
}

private int hexToInt(String hexValue){
	ArrayList hexList = new ArrayList();
	hexList.add(0, "0");
	hexList.add(1, "1");
	hexList.add(2, "2");
	hexList.add(3, "3");
	hexList.add(4, "4");
	hexList.add(5, "5");
	hexList.add(6, "6");
	hexList.add(7, "7");
	hexList.add(8, "8");
	hexList.add(9, "9");
	hexList.add(10, "A");
	hexList.add(11, "B");
	hexList.add(12, "C");
	hexList.add(13, "D");
	hexList.add(14, "E");
	hexList.add(15, "F");
	Double decValue=0.0;

	for (int i = hexValue.length(), i1=0;i>0;i--,i1++){
		String category = hexValue.substring(i-1,i);
		decValue+= hexList.indexOf(category)*Math.pow(16,i1);
	}
	
	return decValue.intValue();
}


private String intToHex(int value){
	
	return Integer.toHexString(value);
} 

private int binToInt(String binValue){
	int intValue = 0;
	ArrayList binList = new ArrayList();
	binList.add(0,"0");
	binList.add(1,"1");
	for (int i=0; i<binValue.length();i++){
		int number=binList.indexOf(binValue.substring(i,i+1));
		intValue=intValue*2+number;
	}
		return intValue;
}

private String intToBin(int value){
	ArrayList answer = new ArrayList();
	String answerStr="";
	
	while(value>0){
		answer.add(value%2);
		value=value/2;
	}
	for (int i=0;i<answer.size();i++){
		answerStr=answerStr+answer.get(i);
	}
	
	return answerStr;
}

private int romeToInt(String romeValue){
	int intValue=0;
	int last =0;
	ArrayList romeList = new ArrayList();
	for (int i =0; i<=1000;i++){
		romeList.add(i,"0");
	}
	romeList.set(1, "I");
	romeList.set(10, "X");
	romeList.set(100, "C");
	romeList.set(1000, "M");
	romeList.set(5, "V");
	romeList.set(50, "L");
	romeList.set(500, "D");

	for (int i = romeValue.length();i>0;i--){
		String category = romeValue.substring(i-1,i);
		int lastValue=romeList.indexOf(category);
		
		if (lastValue>=last){
			intValue+=lastValue;
		} else{
			intValue-=lastValue;
		}
		last = lastValue;
	}
	
	return intValue;
}

private String intToRome(int value){
	String result="";
	while (value>0){
		if ((value/1000)>=1){
			result=result+"M";
			value=value-1000;
		}
		else if  ((value/500)>=1){
			result=result+"D";
			value=value-500;
		}
		else if ((value/100)>=1){
			result=result+"C";
			value=value-100;
		}
		else if ((value/50)>=1){
			result=result+"L";
			value=value-50;
		}
		else if ((value/10)>=1){
			result=result+"X";
			value=value-10;
		}
		else if ((value/1)>=1){
			switch ((value/1)) {
			case 9:
				result=result+"IX";
				value=value-9;
				break;
			case 8:
				result=result+"VIII";
				value=value-8;
				break;
			case 7:
				result=result+"VII";
				value=value-7;
				break;
			case 6:
				result=result+"VI";
				value=value-6;
				break;
			case 5:
				result=result+"V";
				value=value-5;
				break;
			case 4:
				result=result+"IV";
				value=value-4;
				break;
			case 3:
				result=result+"III";
				value=value-3;
				break;
			case 2:
				result=result+"II";
				value=value-2;
				break;
			case 1:
				result=result+"I";
				value=value-1;
				break;
			}
		}
	}
	return result;
}

}
