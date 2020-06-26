package p20200626;

class Vehicle{
	private String ownerName, color;
	private int year;
	
	Vehicle(int year, String color){
		this.year = year; this.color = color;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void move() {}
	
	public String toString() {
		return getOwnerName()+"/"+getYear()+"/"+getColor();
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch(CloneNotSupportedException e) {}
		return obj;
	}
	
	
}

class Car extends Vehicle{
	private String Kind;
	
	Car(int year, String color, String Kind){
		super(year,color);
		this.Kind = Kind;
	}

	public String getKind() {
		return Kind;
	}

	public void setKind(String Kind) {
		this.Kind = Kind;
	}
	
	public void move() {System.out.println("Car로 이동");}
	public void supplyPuel() {System.out.println("Car에 주유하다");}
	public String toString() {
		return getOwnerName()+"/"+getYear()+"/"+getColor()+"/"+getKind();
	}
	
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Car) {
			return getOwnerName() == ((Car)obj).getOwnerName();
		}else {return false;}
	}
}

class AutoBicycle extends Vehicle{
	private String Kind;
	
	AutoBicycle(int year, String color, String Kind){
		super(year,color);
		this.Kind = Kind;
	}

	public String getKind() {
		return Kind;
	}

	public void setKind(String Kind) {
		this.Kind = Kind;
	}
	
	public void move() {System.out.println("오토바이로 이동");}
	public void supplyPuel() {System.out.println("오토바이에 주유하다");}
	public String toString() {
		return getOwnerName()+"/"+getYear()+"/"+getColor()+"/"+getKind();
	}
	
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof AutoBicycle) {
			return getOwnerName() == ((AutoBicycle)obj).getOwnerName();
		}else {return false;}
	}
}


public class VehiclePractice {
	public static void main(String[] args) {
		Vehicle[] vs = new Vehicle[3];
		vs[0] = new Car(5,"blue","소나타");
		vs[1] = new Car(5,"blue","소나타");
		vs[2] = new AutoBicycle(6, "rec", "대림");
		
		vs[0].setOwnerName("홍길동");
		vs[0].move();
		vs[2].move();
		System.out.println(vs[0].equals(vs[1]));
		System.out.println(vs[0].toString());
		
		Vehicle v = (Vehicle)vs[0].clone();
		System.out.println(v.equals(vs[0]));
		((Car)vs[0]).supplyPuel();
	}
}
