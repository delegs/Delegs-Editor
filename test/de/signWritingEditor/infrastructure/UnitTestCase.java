package de.signWritingEditor.infrastructure;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class UnitTestCase {

	/**
	 * Retrieves the value of a static field/constant of a class. Works for
	 * private fields,too.
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	protected int getFieldValue(Class<?> clazz, String fieldName) {
		Field field = getStaticField(clazz, fieldName);
		try {
			return field.getInt(clazz);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private Field getStaticField(Class<?> clazz, String fieldName) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field;
		} catch (SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void setFieldValue(Object target, Class<?> targetClass, String fieldName, Object value) {
		try {
			Field field = targetClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(target, value);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	protected void setFieldValue(Object target, String fieldName, Object value) {
		setFieldValue(target, target.getClass(), fieldName, value);
	}

	protected void callMethod(Object target, Class<?> targetClass, String methodName, Object... args) {
		Class<?>[] clazzes = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			clazzes[i] = args[i].getClass();
		}
		callMethod(target, targetClass, clazzes, methodName, args);
	}

	protected void callMethod(Object target, Class<?> targetClass, Class<?>[] clazzes, String methodName,
			Object... args) {
		try {
			Method method = targetClass.getDeclaredMethod(methodName, clazzes);
			method.setAccessible(true);
			method.invoke(target, args);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void callMethod(Object target, String methodName, Object... args) {
		callMethod(target, target.getClass(), methodName, args);
	}
}
