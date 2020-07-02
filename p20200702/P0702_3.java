package p20200702;

import java.util.ArrayList;

class Student{
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name=name; this.age=age;
	}
	public String toString() {
		return "[name:"+this.name+" age:"+this.age+"]";
	}
}

public class P0702_3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(null);
		list.add(1,10); //index 1 뒤에 10 삽입
		System.out.println(list);
		
		ArrayList list2 = new ArrayList(list);
		Student student = new Student("박찬호",28);
		list2.add(student);
		list2.add(new Student("홍길동",15));
		System.out.println(list2);
		
		ArrayList list3 = new ArrayList(list);
		list3.remove(1); //index 1 제거
		System.out.println(list3);
		list3.clear();
		System.out.println(list3);
		System.out.println(list3.isEmpty());
		
		ArrayList list4 = new ArrayList(list);
		System.out.println(list4.contains(1)); // list에 1이 있는지 검색
		System.out.println(list4.indexOf(1)); // 1이 있는 인덱스값 반환
		list4.addAll(list2);
		System.out.println(list4);
		
		
		
	}
}
