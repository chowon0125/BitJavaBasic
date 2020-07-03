package p20200703;

import java.util.HashSet;

public class P0703_2 {
	public static void main(String[] args) {
		HashSet set1 = new HashSet();
		set1.add("apple");
		set1.add("banana");
		System.out.println(set1.add("apple"));
		System.out.println("set1: "+set1);
		System.out.println("contatins: "+set1.contains("apple"));
		
		//추가,삭제
		HashSet set2 = (HashSet) set1.clone();
		set2.add("melon");
		set2.remove("apple");
		System.out.println("set2 :"+set2);
		
		//합집합, Collecton Add
		HashSet result = (HashSet) set1.clone();
		result.addAll(set2);
		System.out.println("add All :"+result);
		
		//교집합
		result = (HashSet) set1.clone();
		System.out.println("result :"+result);
		result.retainAll(set2);
		System.out.println("retainsAll :"+result);
		
		//차집합
		result = (HashSet) set1.clone();
		result.removeAll(set2);
		System.out.println("removeAll :"+result);
	}

}
