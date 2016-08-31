package book.effective_java.items.item8.obeyequalscontractwhenoverriding;

import java.util.Date;
import java.sql.Timestamp;

public class ViolatesSymmetry {
	public static void main(String[] argv){
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.println(timestamp.equals(date));
		System.out.println(date.equals(timestamp));
	}
}
