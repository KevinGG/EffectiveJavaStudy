package utility;

public class Swapper<T> {
  // predefined singletons
  public static Swapper<Integer> IntegerSwapper = ofInt();
  
  // static swap logic for primitive types
  public static void swap(int[] elements, int i, int j){
    int temp = elements[i];
    elements[i] = elements[j];
    elements[j] = temp;
  }
  // end static swap logic for primitive types
  
  // swap logic for non-primitive types
  public void swap(T left, T right){
    T temp = left;
    left = right;
    right = temp;
  }
  
  public void swap(T[] elements, int i, int j){
    T temp = elements[i];
    elements[i] = elements[j];
    elements[j] = temp;
  }
  // end swap logic for non-primitive types
  
  // public static factory
  public static <S> Swapper<S> create(){
    return new Swapper<S>();
  }
  // end public static factory
  
  // private singleton creation
  private static Swapper<Integer> ofInt(){
    return new Swapper<Integer>();
  }
  // end private singleton creation
}
