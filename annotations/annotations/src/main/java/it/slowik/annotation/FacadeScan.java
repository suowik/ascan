package it.slowik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by suowik
 * 01.02.14.
 */
@Target(value = {ElementType.TYPE})
public @interface FacadeScan {
}
