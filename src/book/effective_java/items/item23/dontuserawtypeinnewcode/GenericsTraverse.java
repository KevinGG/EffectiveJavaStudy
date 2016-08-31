package book.effective_java.items.item23.dontuserawtypeinnewcode;

import java.util.ArrayList;
import java.util.List;

import utility.ObjectOutputUtility;
public class GenericsTraverse {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("str1");
		strList.add("str2");
		strList.add("str3");
		for(String s: strList){
			s = "str";
		}
		ObjectOutputUtility.outputCollectionToConsole(strList);
	}
}
