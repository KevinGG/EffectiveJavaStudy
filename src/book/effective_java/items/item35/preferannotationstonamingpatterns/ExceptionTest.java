package book.effective_java.items.item35.preferannotationstonamingpatterns;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception> value();
}
