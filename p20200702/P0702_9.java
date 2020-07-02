package p20200702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Dog implements Comparable{
	String name;
	int age;

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object o) {
		if(this.age > ((Dog)o).age) {
			return 1;
		}
		return -1;
	}
	
	public String toString() {
		return "[이름 : " + name + ", 나이 : " + age +"살] ";
	}
}


class C1 implements Comparator {

	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}

public class P0702_9 {
	public static void main(String[] args) {
		ArrayList arr = new ArrayList(Arrays.asList(7,5,10,9,3,5,2,8));
		C1 c = new C1();
		ArrayList arr2 = new ArrayList(Arrays.asList("AB","ef","CK","gt","pb"));
		ArrayList arr3 = new ArrayList(Arrays.asList(5,10,15,90,7));
		List list = new ArrayList();
		list.add(new Dog("낙동", 5));
		list.add(new Dog("샤크", 3));
		list.add(new Dog("동해", 7));
		
		System.out.println("1번 문제");
		System.out.println("정렬 전 : "+arr);
		Collections.sort(arr,c);
		System.out.println("내림차순 정렬 후 : "+arr);
		System.out.println("2번 문제");
		System.out.println("정렬 전 : "+arr2);
		Collections.sort(arr2,c);
		System.out.println("내림차순 정렬 후 : "+arr2);
		
		ArrayList arr4 = new ArrayList();
		
		for(int i=0; i<arr3.size(); i++) {
			if(arr.contains(arr3.get(i))) {
				arr4.add(arr3.get(i));
			}
		}
		System.out.println("3번 문제");
		System.out.println("교집합 : "+arr4);
		
		ArrayList arr5 = new ArrayList();
		ArrayList arr6 = new ArrayList();
		ArrayList arr7 = new ArrayList();
		
		for(int i=0; i<arr.size(); i++) {
			if(!arr3.contains(arr.get(i))) {
				arr5.add(arr.get(i));
			}
		}
		
		for(int i=0; i<arr3.size(); i++) {
			if(!arr.contains(arr3.get(i))) {
				arr6.add(arr3.get(i));
			}
		}
		arr7.addAll(arr5);
		arr7.addAll(arr6);
		arr7.addAll(arr4);
		
		System.out.println("4번 문제");
		System.out.println("여집합 1 : "+arr5);
		System.out.println("여집합 2 : "+arr6);
		System.out.println("합집합 : "+arr7);
		
		list.sort(c);
		System.out.println(list);
	}
}
