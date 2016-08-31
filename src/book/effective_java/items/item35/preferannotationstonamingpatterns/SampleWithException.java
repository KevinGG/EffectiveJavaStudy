package book.effective_java.items.item35.preferannotationstonamingpatterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleWithException {
	/**
	 * Test should pass
	 */
	@ExceptionTest(ArithmeticException.class)
	public static void m1(){
		int i = 0;
		i = i/i;
	}
	
	/**
	 * Test should fail because of wrong exception
	 */
	@ExceptionTest(ArithmeticException.class)
	public static void m2(){
		int[] a = new int[0];
		int i = a[1];
	}
	
	/**
	 * Test should fail because of no exception
	 */
	@ExceptionTest(ArithmeticException.class)
	public static void m3(){
		int i = 1;
		i = i + 1;
	}
}

class TestRunnerBeta {
	public static void main(String[] argv) throws Exception {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("item35.preferannotationstonamingpatterns.SampleWithException");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + "failed: " + exc);
				} catch(Exception exc){
					System.out.println("Invalid @Test: " + m);
				}
			}
			if (m.isAnnotationPresent(ExceptionTest.class)){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				}catch (InvocationTargetException wrappedExc){
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
					if(excType.isInstance(exc)){
						passed++;
					}else{
						System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
					}
				}catch (Exception exc){
					System.out.println("Invalid @ExceptionTest: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests-passed);
	}
}