package homework07.Task01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface Version {
    String value = "1.0";
}
