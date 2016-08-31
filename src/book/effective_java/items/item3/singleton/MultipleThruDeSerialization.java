package book.effective_java.items.item3.singleton;

import java.io.IOException;
import java.io.Serializable;
import utility.SerializeUtility;

public class MultipleThruDeSerialization implements Serializable {
	public static final MultipleThruDeSerialization INSTANCE = new MultipleThruDeSerialization();

	private MultipleThruDeSerialization() {
	}

	public void printSelf() {
		System.out.println(this.getClass().getName() + " instance " + String.valueOf(this.hashCode()));
	}

	private String name = "instance";
	
	private Object readResolve(){
		return INSTANCE;
	}
}

class MainMethodMultipleThruDeSerialization {
	private static final String fileName = "./src/item3/singleton/MultipleThruDeSerializationInstance.ser";
	public static void main(String[] argv) {
		try {
			SerializeUtility.serialize(MultipleThruDeSerialization.INSTANCE, fileName);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			MultipleThruDeSerialization instance1 = (MultipleThruDeSerialization)SerializeUtility.deserialize(fileName);
			MultipleThruDeSerialization instance2 = (MultipleThruDeSerialization)SerializeUtility.deserialize(fileName);
			instance1.printSelf();
			instance2.printSelf();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
	}
}
