import static org.junit.Assert.*;
import java.util.*;
import java.lang.reflect.*;
import org.junit.Test;
import org.junit.Before;

public class InspectorTest {
	ClassD objD;
	Inspector inspec = null;
	boolean recursive = false;
	
	
	@Before
	public void initialize() {
		objD = new ClassD();
		inspec = new Inspector();
	}
	
	@Test
	public void testPrintClassInfo(){
		System.out.println("======================");
		System.out.println("test printClassInfo: ");
		try {
			inspec.printClassInfo(objD.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrintMethodInfo(){
		System.out.println("======================");
		System.out.println("test printMethodInfo: ");
		try {
			inspec.printMethodInfo(objD.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrintConstructorInfo(){
		System.out.println("======================");
		System.out.println("test printConstructorInfo: ");
		try {
			inspec.printConstructorInfo(objD.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrintNonOrRecursive() throws Exception {
		System.out.println("======================");
		System.out.println("test printNonOrRecursive: ");
		ClassB objB = new ClassB();
		Field f = objB.getClass().getDeclaredFields()[0];
		inspec.printNonOrRecursive(objB, f, false);
	}
	
	@Test
	public void testArrayRecursiveMethod() throws Exception {
		System.out.println("======================");
		System.out.println("test arrayRecursiveMethod: ");
		char[][] testArray= {{'a'},{'b','c'},{'d','e'}};
		inspec.arrayRecursiveMethod(testArray);
	}
	
	@Test
	public void testArrayInfo() throws Exception {
		System.out.println("======================");
		System.out.println("test arrayRecursiveMethod: ");
		Class[] testClassObject = {new ClassA().getClass(), new ClassB().getClass(), new ClassD().getClass()};
		inspec.arrayInfo(testClassObject);
	}
	
	@Test
	public void testInspect() {
		System.out.println("======================");
		System.out.println("test inspect: ");
		inspec.inspect(objD, false);
	}
}
