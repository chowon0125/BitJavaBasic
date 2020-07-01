package p20200701;

import java.util.Scanner;

class Mother{
	String name, job;
	int age;
	Child[]childs;
	
	Mother(String name, int age){
		this.name = name;
		this.age = age;
	}
	Mother(String name, int age, String job, Child[]childs){
		this(name, age);
		this.job = job;
		this.childs = childs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Child[] getChilds() {
		return childs;
	}
	public void setChilds(Child[] childs) {
		this.childs = new Child[childs.length];
		this.childs = childs;
	}
	
	public void goToSchool() {
		System.out.println("아이들과 학교가다.");
	}
	
	public void callChild() {
		for(int i=0; i<childs.length; i++) {
			System.out.println(childs[i].getName()+"이 지금 갑니다.");
		}
	}
	
}

class Child extends Mother{
	String[] hobby;
	Child(String name, int age){
		super(name, age);
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		String[] arr = hobby.split(",");
		this.hobby = new String[arr.length];
		this.hobby = arr;
	}
	
	public void goToSchool() {
		System.out.println("학교에 가다");
	}
	
	public void fight(Child c) {
		System.out.println(c.getName()+"과 싸웠습니다.");
	}
	
	public void printHobby() {
		String s = String.join(",", hobby);
		System.out.println(name+"의 취미 : "+s);
	}
	
}

public class P0701_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mother mother = new Mother("A", 35);
		Child child1 = new Child("a", 9);
		Child child2 = new Child("b", 11);
		
		child1.setHobby("바둑,농구,수영");
		child1.printHobby();
		child2.setHobby("축구,야구,게임");
		child2.printHobby();
		Child[] c = {child1, child2};
		mother.setChilds(c);
		mother.callChild();
	}
	

}
