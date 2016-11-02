package java8.functionalinterface;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface ActionExecutor<T extends Action> {

  public void printActionPlan(final Collection<Supplier<T>> actions);

  public default void execute(final Collection<Supplier<T>> actions) {
    actions.forEach(action -> action.get().takeAction());
  }

  public static <T> Stream<T> stream(final Collection<T> collection) {
    return collection.stream();
  }

}
