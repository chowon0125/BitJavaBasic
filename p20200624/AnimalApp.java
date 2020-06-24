package p20200624;
/*
 * 과제: Animal class를 설계한다
 * */

class Animal{
	private String name;
	private int age;
	private String type;
	public static int count;	
	
	public Animal() {
		
	}
	
	public Animal(Animal ani) {
		this.name = ani.getName();
		this.age = ani.getAge();
		this.type = ani.getType();
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setType(String type) {
		if(type.equals("Dog") || type.equals("Cat")) {
			this.type = type;
		}else {
			System.out.println("Dog과 Cat중 하나로 초기화 해주세요.");
		}
	}

	public void bark(int param) {
		String sound = "";
		if(this.type.equals("Dog")) {
			sound = "멍멍! ";
		}else if(this.type.equals("Cat")){
			sound = "야옹~ ";
		}else {
			sound =	"";
		}
		for(int i = 0; i < param; i++) {
			System.out.printf(sound);
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "나는 "+this.type+"이고, 이름은 "+this.name+"입니다.";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Animal) {
			return this.type == ((Animal)obj).type && this.name == ((Animal)obj).name;
		}else {
			return	false;
		}
	}
	
	public static void count() {
		count++;
	}
	
	public static String totalCount() {
		return	"총 동물의 수는 "+count+"마리";
	}
	
}

public class AnimalApp {
	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.setName("멍뭉이");
		ani.setAge(5);
		ani.setType("Dog"); 				// Type으로는 Dog, Cat이 올수 있다
		ani.bark(5); 						// 5번 Dog는 ‘멍멍’,Cat은 ‘야옹’으로 출력
		System.out.println(ani.toString()); // ‘나는 Dog이고이름은 멍뭉이 입니다’

		Animal ani2 = new Animal(ani);
		if(ani2.equals(ani)){
		 System.out.println("같은 강아지 입니다");
		}
		
		Animal.count(); // 동물 수 Count추가	(과제 조건상 생성자로 생성했을때 추가하는게 아니라 count함수를 호출했을때 추가하도록 함) 

		System.out.println(Animal.totalCount()); // 총 동물수(count) 출력
	}
}
