package book.effective_java.items.item7.dontusefinalizer;

import static utility.ObjectOutputUtility.outputInstanceToConsole;

public class FinalizerDemo {
	private String name;

	public FinalizerDemo(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		this.name = "no name";
		super.finalize();
	}

	public static void main(String[] argv) throws Throwable {
		System.out.println("Creating finalizer object...");
		final FinalizerDemo finalizerDemo = new FinalizerDemo("demo");
		System.out.println("Object finalizerDemo created");
		outputInstanceToConsole("finallizerDemo with name " + finalizerDemo.name, (Object) finalizerDemo);

		System.out.println("Finalizing finalizerDemo...");
		finalizerDemo.finalize();
		System.out.println("Object finalizerDemo finalized.");
		outputInstanceToConsole("finallizerDemo with name " + finalizerDemo.name, (Object) finalizerDemo);
	}
}
