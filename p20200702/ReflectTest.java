package p20200702;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public String str;
	public ReflectTest(String str) {
		this.str = str;
		System.out.println("REFLECT 생성자호출:"+str);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, 
	NoSuchMethodException, IllegalArgumentException, InstantiationException,
	IllegalAccessException, InvocationTargetException {
		Class c = Class.forName("p20200702.ReflectTest");
		System.out.println(c);
		
		Constructor[] ctor = c.getConstructors();
		for(int i=0; i<ctor.length;i++) {
			System.out.println("생성자 : "+ctor[i].toString());
		}
		
		Method m[] = c.getMethods();
		for(int i=0; i<m.length; i++) {
			System.out.println("메소드 : "+m[i].toString());
		}
		
		Class c2 = Class.forName("p20200702.ReflectTest");
		Class[] parameterTypes = new Class[] {String.class};
		Constructor constructor = c2.getConstructor(parameterTypes);
		
		Class[] parameterTypes2 = new Class[] {String.class};
		Method method = c2.getMethod("test01", parameterTypes2);
		Object[] parameters = new Object[] {"메소드 호출"};
	}
	
	public void test01(String paramStr) {
		System.out.println("test01 메소드 호출 :" + paramStr);
	}
	public void test02() {}

}
