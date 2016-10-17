package utility;

import java.lang.reflect.Field;

public final class HashCode<T> {
  private final T t;
  
  public HashCode(final T t){
    this.t = t;
  }
  
  public int hashCode(){
    Field[] fields = t.getClass().getDeclaredFields();
    int hash = 17;
    for(Field f : fields){
      hash = hashField(hash, f);
    }
    return hash;
  }
  
  private int hashField(int hash, final Field f){
    try {
      hash = 31 * hash;
      final Class<?> fieldType = f.getType();
      Object fieldValue = f.get(t);
      if(fieldType.isPrimitive()){ // only do explicit 
        // boolean
        if(fieldType.equals(Boolean.TYPE)) return hash + (((Boolean)fieldValue) ? 1 : 0);
        // long
        if(fieldType.equals(Long.TYPE)){
          long lv = ((Long)fieldValue).longValue();
          lv = lv ^ (lv >>> 32);
          return hash + (int)lv;
        }
        // float
        if(fieldType.equals(Float.TYPE)){
          float fv = ((Float)fieldValue).floatValue();
          return hash + Float.floatToIntBits(fv);
        }
        //double
        if(fieldType.equals(Double.TYPE)){
          double dv = ((Double)fieldValue).doubleValue();
          long lv = Double.doubleToLongBits(dv);
          lv = lv ^ (lv >>> 32);
          return hash + (int)lv;
        }
        // byte, char, short, int
        return hash + (int)fieldValue;
      }
      return hash + fieldValue.hashCode();
    } catch (Exception e) {
      return 0;
    }
  }
}
