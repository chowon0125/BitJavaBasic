package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import assignment.Descending;


public class CollectionTest {
	public static void main(String[] args) {
		//문제1.
		Integer[] strArr1 = {7, 5, 10, 9, 3, 5, 2, 8};
		Arrays.sort(strArr1, new Descending());
		System.out.println("문제1.");
		System.out.println(("strArr=" +Arrays.toString(strArr1)));		

   //문제2.
	String[] strArr2 = {"AB", "ef", "CK", "gt", "pb"};
	Arrays.sort(strArr2, new Descending());
	System.out.println("문제2.");
	System.out.println(("strArr=" +Arrays.toString(strArr2)));
	

	
	//문제3.
//	Integer[] Arr = {7, 5, 10, 9, 3, 5, 2, 8};
//	Integer[] Arr2 = {5,10,15, 90, 7};
//	//181page
//	List list = new ArrayList(Arrays.asList(7, 5, 10, 9, 3, 5, 2, 8));
//	List list2 = new ArrayList(Arrays.asList(5, 10, 15, 90, 7));
//	System.out.println("문제3.");
//	System.out.println(list.retainAll(list2));
//	print(list);
//	
//	}
//	static void print(List list) {
//		System.out.println("list:" + list);
//
//	}
	
	
	//문제4.
	Integer[] Arr = {7, 5, 10, 9, 3, 5, 2, 8};
	Integer[] Arr2 = {5,10,15, 90, 7};
	
	//181page
	List list = new ArrayList(Arrays.asList(7, 5, 10, 9, 3, 5, 2, 8));
	List list2 = new ArrayList(Arrays.asList(5, 10, 15, 90, 7));
	List copy = new ArrayList();
	//retain.addAll(list);
	System.out.println("문제4.");
	print(list);	
	for (int i = list2.size() - 1; i >= 0; i--) {
		if (list.contains(list2.get(i)))
			list2.remove(i);
	}
	print2(list2); 
	
	list.addAll(list2);
	print(list);
	
	Iterator it =list.iterator();
	
	while(it.hasNext()) {
	//	Integer num = (Integer) list.next();
		if(it.next()==list) {
		//copy.add(it.next()) ;
		it.remove();
		}		System.out.println(list);break;
			}

	//문제5: 다음 클래스의 객체를 ArrayList에 담아서 오름차순으로 정렬하시오
	//(age가 큰 것이 큰값으로 간주)
	List list3 = new ArrayList();
	list3.add(new Dog("낙동", 5));
	list3.add(new Dog("샤크", 3));
	list3.add(new Dog("동해", 7));
	
	Collections.sort(list3);
	
	
}
	
	
	 


	static void print(List list) {
		System.out.println("list:" + list);

	}
	
	
	static void print2(List list2) {
		System.out.println("list2:" + list2);
	}
	
}

class Dog{
	String name;
	int age;
	
	Dog(String name, int age){
		this.name=name;
		this.age=age;
	}

}


class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 =(Comparable)o2;
			
			return c1.compareTo(c2) *-1; //-1을 곱해서 기본 정렬방식의 역으로 변경한다.
			//또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
		}
		return -1;
	}
}