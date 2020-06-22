package p20200622;

public class Dog {
	
	String name;
	
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "Bart";
		dog1.bark(dog1);
		
		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		myDogs[0].name = "Fred";
		myDogs[1].name = "Marge";
		
		System.out.println("마지막 개의 이름");
		System.out.println(myDogs[2].name);
		br();
		for(int i = 0; i<myDogs.length; i++) {
			myDogs[i].bark(myDogs[i]);
		}
		br();
		for(int i = 0; i<myDogs.length; i++) {
			myDogs[i].eat(myDogs[i]);
		}
		br();
		for(int i = 0; i<myDogs.length; i++) {
			myDogs[i].chaseCat(myDogs[i]);
		}
		
	}
	
	public void bark(Dog dog) {
		this.name = dog.name;
		System.out.println(name+"이 왈! 하고 짖습니다.");
	}
	
	public void eat(Dog dog) {
		this.name = dog.name;
		System.out.println(name+"이 밥을 먹습니다.");
	}
	
	public void chaseCat(Dog dog) {
		this.name = dog.name;
		System.out.println(name+"이 고양이를 쫓습니다");
	}
	static public void br() {
		System.out.println("");
	}

}
