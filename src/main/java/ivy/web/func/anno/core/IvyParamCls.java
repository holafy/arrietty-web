package ivy.web.func.anno.core;

public @interface IvyParamCls {
	Class<?> value() default Object.class;
	String name() default "";
	
}
