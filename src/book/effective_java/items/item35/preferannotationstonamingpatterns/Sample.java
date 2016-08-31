package book.effective_java.items.item35.preferannotationstonamingpatterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Sample {
	/**
	 * Test should pass
	 */
	@Test
	public static void m1() {
	}

	/**
	 * Test should fail
	 */
	@Test
	public static void m2() {
		throw new RuntimeException("BOOM");
	}

	/**
	 * Invalid use on nonstatic method
	 */
	@Test
	public void m3() {

	}
}

class TestRunnerAlpha {
	public static void main(String[] argv) throws Exception {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("item35.preferannotationstonamingpatterns.Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + "failed: " + exc);
				}catch(Exception exc){
					System.out.println("Invalid @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests-passed);
	}
}