package p20200703;

import java.util.HashSet;
import java.util.Objects;

public class P0703_3 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",10));
		
		System.out.println(set);
	}
}

class Person2 {
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int hashCode() {
		return Objects.hash(name,age);
	}

	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name)&&age==tmp.age;
		}
		return false;
	}
	
	public String toString() {
		return name+":"+age;
	}



}
