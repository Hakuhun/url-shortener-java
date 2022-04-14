package hu.haku.urlshortener.configuration.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiKeyChecker {
    public static String API_KEY_HEADER_NAME = "x-api-key";
    String endpointName() default "";
}
