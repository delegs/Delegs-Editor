package de.signWritingEditor;

import java.lang.reflect.Modifier;

import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.reflections.Reflections;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(AllTests.class)
public class CodeTestSuite extends GWTTestSuite {

	public static Test suite() {

		TestSuite suite = new TestSuite("GWT Integration Tests");

		new Reflections("de.signWritingEditor").getSubTypesOf(GWTTestCase.class).stream()
				.filter(clazz -> !Modifier.isAbstract(clazz.getModifiers())).forEach(suite::addTestSuite);

		return suite;
	}
}
