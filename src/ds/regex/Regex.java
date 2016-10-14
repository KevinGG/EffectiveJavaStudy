package ds.regex;

public class Regex {
  private String regex;
  
  public Regex(String regex){
    this.regex = regex;
  }
  
  public boolean isMatching(String s){
    
    return true;
  }
  
  public static void main(String[] argv){
    String s = "?";
    System.out.println(s.length());
    System.out.println(s.charAt(0));
    
    String s2 = "" + '?';
    System.out.println(s2.length());
    System.out.println(s2.charAt(0));
  }
}
