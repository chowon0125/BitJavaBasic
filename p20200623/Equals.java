package p20200623;

class Value{
	int value;
	
	Value(int value){
		this.value = value;
	}
	
	int getValue(){
		return value;
	}
}


class Person2{
	long id;
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Person2) {
			return id ==((Person2)obj).id;
		}
		return false;
	}
	
	Person2(long id){
		this.id = id;
	}
	
}

public class Equals {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
	
		if(v1.equals(v2)) {System.out.println("true");}
		else {System.out.println("false");}
		
		if(v1 == v2) {System.out.println("true");}
		else {System.out.println("false");}
		
		if(v1.getValue() == v2.getValue()) {System.out.println("true");}
		else {System.out.println("false");}
		
		
		Person2 p1 = new Person2(8011081111222l);
		Person2 p2 = new Person2(8011081111222l);
	
		if(p1==p2) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		}	
		else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		}	
		else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
	
}
