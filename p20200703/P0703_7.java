package p20200703;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

public class P0703_7 {
	public static void main(String[] args) {
		System.out.println("=1번 문제=");
		
		List al = new ArrayList(Arrays.asList(7,5,10,9,3,5,2,8));
		System.out.println("최초 값 입력 :"+al);
		List sub = new ArrayList(al.subList(0,3));
		al.subList(0,3).clear();
		al.addAll(sub);
		System.out.println("이동 후 배열 :"+al);
		
		
		System.out.println("=2번 문제=");
		Set hs = new HashSet();
		Random random = new Random();
		for(int i=0; i<20; i++) hs.add(random.nextInt(100)+1);
		System.out.println("랜덤 숫자 20개 :"+hs);
		List hslist = new ArrayList(hs);
		Collections.sort(hslist);
		System.out.println("오름차순 정렬 :"+hslist);
		System.out.println("최소값 :"+hslist.get(0));
		System.out.println("최대값 :"+hslist.get(hslist.size()-1));
		
		
		System.out.println("=3번 문제=");
		Set dogs = new HashSet();
		Dog dog1 = new Dog("동동이","1");
		Dog dog2 = new Dog("동동이","1");
		Dog dog3 = new Dog("짬타이거","1");
		Dog dog4 = new Dog("호떡","4");
		Dog dog5 = new Dog("호떡","6");
		dogs.add(dog1); dogs.add(dog2); 
		dogs.add(dog3); dogs.add(dog4); dogs.add(dog5);
		System.out.println(dogs);
		
		
		System.out.println("=4번 문제=");
		HashMap hashmap = new HashMap();
		hashmap.put(100001,new Employee("홍길동",28,"인사팀"));
		hashmap.put(100000,new Employee("박길동",30,"총무팀"));
		hashmap.put(100003,new Employee("박찬호",29,"회계팀"));
		hashmap.put(100002,new Employee("이순신",28,"총무팀"));
		
		System.out.println(hashmap);
		TreeMap treeMap = new TreeMap(hashmap);
		Iterator treeMapIter = treeMap.keySet().iterator();
		while(treeMapIter.hasNext()) {
			int key = (int) treeMapIter.next();
			Employee value = (Employee) treeMap.get(key);
			
			System.out.println(key + " : " + value);
		}
	}
}

class Dog{
	public String name, age;
	
	public Dog(String name, String age){
		this.name = name; this.age = age;
	}

	public int hashCode() {
		return Objects.hash(name,age);
	}

	public boolean equals(Object obj) {
		if(obj instanceof Dog) {
			Dog tmp = (Dog)obj;
			return name.equals(tmp.name)&&age.equals(tmp.age);
		}
		return false;
	}
	
	public String toString() {
		return name + " : " + age + "살";
	}
}

class Employee{
	String name, depart;
	int age;
	
	public Employee(String name, int age, String depart) {
		this.name = name; this.age = age; this.depart = depart;
	}
	
	public String toString() {
		return "["+name + ", " + age + ", " + depart +"]";
	}
	
}
