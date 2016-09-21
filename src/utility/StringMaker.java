package utility;

public class StringMaker {
  private StringBuilder sb;
  
  public static StringMaker create(){
    return new StringMaker();
  }
  
  private StringMaker(){
    sb = new StringBuilder();
  }
  
  public StringMaker append(String s){
    sb.append(s);
    return this;
  }
  
  public StringMaker appendNl(String s){
    sb.append(s).append(System.lineSeparator());
    return this;
  }
  
  public StringMaker leftSquareBracket(){
    sb.append("[");
    return this;
  }
  
  public StringMaker rightSquareBracket(){
    sb.append("]");
    return this;
  }
  
  public StringMaker leftSquareBracketAppend(String s){
    leftSquareBracket().append(s);
    return this;
  }
  
  public StringMaker appendRightSquareBracket(String s){
    rightSquareBracket().append(s);
    return this;
  }
  
}
