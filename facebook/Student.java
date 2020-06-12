package facebook;

public class Student {

	private String name, cls;
	private int number;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getCls() {
		return this.cls;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return this.number;
	}
	
	public String toString() {
		return "[이름 : "+name+",  반 : "+cls+",  번호 : "+number+"]";
	}
	
}
