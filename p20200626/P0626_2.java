package p20200626;

class Person{
	private String name, gender;
	private Hobby hobby;
	
	Person(String name, String gender){
		this.name = name; this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	public void eat() {System.out.println("식사를 합니다.");}
	public void hello() {}
}
class Student2 extends Person{
	Student2(String name, String gender){
		super(name, gender);
	}
	public void hello() {System.out.printf("안녕하세요 취미가 %s인 %s입니다.%n",super.getHobby().getName(), super.getName());}
}

class Hobby{
	
	private String name, type;
	
	Hobby(String name, String type){
		this.name = name; this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

public class P0626_2 {
	
	public static void main(String[] args) {
		Person p = new Student2("김학생", "남");
		Hobby h = new Hobby("농구", "구기");
		p.setHobby(h);
		p.eat();
		p.hello();
	}
}
