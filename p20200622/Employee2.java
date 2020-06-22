package p20200622;

interface EmployeeType {
	public int getAmount();
}

class Engineer implements EmployeeType{
	public int getAmount() {
		return 100;
	}
}

class Manager implements EmployeeType{
	public int getAmount() {
		return 200;
	}
}

class SalesMan implements EmployeeType{
	public int getAmount() {
		return 300;
	}
}

public class Employee2 {
	private Employee2 type;
	
	public void setType(Employee2 type) {
		this.type = type;
	}

	public Employee2(Employee2 type) {
		setType(type);
	}
	
	public int getAmount() {
		return type.getAmount();
	}
	
	public static void main(String[] args) {
		Engineer e = new Engineer();
		//에러나서 주석처리
		//EmployeeType emp = new EmployeeType(e);
		//emp.getAmount();

	}
}
