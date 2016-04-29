package item3.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CaveatAccessThruReflection {
	public static final CaveatAccessThruReflection INSTANCE = new CaveatAccessThruReflection();

	private CaveatAccessThruReflection() {
	}

	public void printSelf() {
		System.out.println(this.getClass().getName() + " instance " + String.valueOf(this.hashCode()));
	}
}

class MainMethodCaveatAccessThruReflection {
	public static void main(String[] argv) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class caveatAccessThruReflectionClass = CaveatAccessThruReflection.class;
		Constructor constructor = caveatAccessThruReflectionClass.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		CaveatAccessThruReflection instance1 = (CaveatAccessThruReflection) constructor.newInstance(null);
		CaveatAccessThruReflection instance2 = (CaveatAccessThruReflection) constructor.newInstance(null);
		instance1.printSelf();
		instance2.printSelf();
	}
}