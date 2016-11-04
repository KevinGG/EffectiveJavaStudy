package java8.functionalinterface;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalInterface {
  public static void main(String[] argv){
    Action action1 = () -> {
      System.out.println("Action 1");
      return true;
    };
    
    Action action2 = () -> {
      System.out.println("Action 2");
      return true;
    };
    
    List<Supplier<Action>> list  = new LinkedList<>();
    list.add(()->action1);
    list.add(()->action2);
    
    ActionExecutor<Action> ae = actionPlan -> actionPlan.forEach(action -> System.out.println(action.toString()));
    ae.printActionPlan(list);
    ae.execute(list);
    ActionExecutor.stream(list).forEach(action -> action.get().takeAction());
  }
}
