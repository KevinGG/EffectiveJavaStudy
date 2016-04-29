package item23.dontuserawtypeinnewcode;

import java.util.ArrayList;
import java.util.List;
import utility.ObjectOutputUtility;

public class LegitimateRawTypeUse {
	
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("str1");
		strList.add("str2");
		if(strList instanceof List){//The instanceof could only utilize raw type List and wildcard type List<?>
			List rawStrList = strList; //Raw type warning
			rawStrList.add(new Integer(1));//uncheck warning, can insert Integer into String List
			List<?> wildStrList = (List<?>)strList;
			//wildStrList.add("str3");// This line doesn't compile even when inserting String
		}
		ObjectOutputUtility.console(List.class);
		//ObjectOutputUtility.console(List<?>.class);//This line doesn't compile, only raw type could be used for literals
	}
}
