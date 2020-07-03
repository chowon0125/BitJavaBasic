package p20200703;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class P0703_6 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-111-1112");
		addPhoneNo("친구", "박자바", "010-111-1113");
		addPhoneNo("회사", "최자바", "010-111-1114");
		addPhoneNo("회사", "신자바", "010-111-1115");
		addPhoneNo("서점", "010-111-1116");
		printList();
		
	}

	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) phoneBook.put(groupName, new HashMap());
	}
	
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel,name);
	}
	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타",name,tel);
	}
	
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator sublt = subSet.iterator();
			
			System.out.println(" * "+e.getKey()+"["+subSet.size()+"]");
			
			while(sublt.hasNext()) {
				Map.Entry subE = (Map.Entry)sublt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
}
