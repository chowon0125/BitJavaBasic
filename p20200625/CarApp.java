package p20200625;

import java.util.Scanner;

/*
 * • 실습: 차량판매시스템
선택하세요. [0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매]

[차량등록]

차량번호: 111

차량크기(소형(1)/중형(2)/대형(3)): 2

차량타입(세단(1)/SUV(2)): 1

[고객등록]

고객번호: 122

고객명: 홍길동

[차량조회]

차량번호: 111

차량크기(소형(1)/중형(2)/대형(3)): 2

차량타입(세단(1)/SUV(2)): 1

--------------

[고객조회]

고객번호: 111

고객명: 홍길동

-------------

[차량판매]

고객번호를 등록하세요[0:취소]: 122

차량번호를 등록하세요[0:취소]: 111

====================================================================

* 차량등록 시 중복체크
   ‘차량번호가 중복됩니다’

* 차량판매 시
   - 존재하는 고객번호일 때까지 ‘고객번호를 등록하세요’
   - 존재하는 차량번호일 때까지 ‘차량번호를 등록하세요’

  - 판매된 차량번호이면 ‘판매된 차량번호 입니다. 차량번호를 등록하세요’
 * 
 * 
 */
class Car{
	private int carNumber, size, type;
	

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

class Customer{
	private int cusNumber;
	private String name;
	private Car car = null;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public int getCusNumber() {
		return cusNumber;
	}
	public void setCusNumber(int cusNumber) {
		this.cusNumber = cusNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class CarService{
	int cusIndex = 0, carIndex = 0;
	Customer[] customerList = new Customer[30];
	Car[] carList = new Car[30];
	
	public void inputCar(Car car) {
		carList[carIndex] = car;
		carIndex++;
	}
	public void inputCustomer(Customer customer) {
		customerList[cusIndex] = customer;
		cusIndex++;
	}
	public void searchCar() {
		for(int i=0; i<carIndex; i++) {
			System.out.printf("차량번호: %d%n차량크기(소형(1)/중형(2)/대형(3)): %d%n차량타입(세단(1)/SUV(2)): %d%n"
								,carList[i].getCarNumber(),carList[i].getSize(),carList[i].getType());
			System.out.println("--------------------------------");
		}
	}
	
	public void searchCustomer() {
		for(int i=0; i<cusIndex; i++) {
			System.out.printf("고객 번호 : %d%n고객 이름 : %s%n",customerList[i].getCusNumber(),customerList[i].getName());
			if(customerList[i].getCar() == null) {System.out.println("소유중인 차량 : 없음");}
			else {System.out.printf("소요중인 차량 : 차량번호 %d번%n",(customerList[i].getCar()).getCarNumber());}
			System.out.println("--------------------------------");
		}
	}	
	public void sellCar(int cusNum, int carNum) {
		Car car = null;
		Customer cus = null;
		int cusI = 0;
		
		for(int i=0; i<cusIndex; i++) {
			if(cusNum == customerList[i].getCusNumber()) {
				cus = customerList[i]; cusI = i; break;
			}
		}
		for(int i=0; i<carIndex; i++) {
			if(carNum == carList[i].getCarNumber()) {
				car = carList[i]; break;
			}
		}
		if( cus != null && car != null){
			if(cus.getCar()!=null){System.out.println("이미 등록된 차량이 있습니다.");}
			else{
				cus.setCar(car);
				customerList[cusI] = cus;
				System.out.printf("%s 고객님에게 %d번 차량 판매 완료.%n",cus.getName(), car.getCarNumber());
				}
		}
		else {System.out.println("고객번호나 차량번호를 확인하세요.");}
	}
	
	public boolean cusNumDup(int cusNum) {
		boolean check = true;
		for(int i=0; i<cusIndex; i++) {
			if(cusNum == customerList[i].getCusNumber()) {
				check = false; break;
			}
		}
		return check;
	}
	
	public boolean carNumDup(int carNum) {
		boolean check = true;
		for(int i=0; i<carIndex; i++) {
			if(carNum == carList[i].getCarNumber()) {
				check = false; break;
			}
		}
		return check;
	}
}

public class CarApp {
	public static void main(String[] args) {
		CarService service = new CarService();
		Scanner scanner = new Scanner(System.in);
		Car car;
		Customer cus;
		
		while(true) {
			System.out.println("[0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매]");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("시스템 종료"); return;
			case 1 : 
				car = new Car();
				int caNum;
				System.out.println("차량번호 : ");
				caNum = scanner.nextInt();
				if(service.carNumDup(caNum)) {
					car.setCarNumber(caNum);
					System.out.println("차량크기(소형(1)/중형(2)/대형(3)): ");
					car.setSize(scanner.nextInt());
					System.out.println("차량타입(세단(1)/SUV(2)): ");
					car.setType(scanner.nextInt());
					service.inputCar(car);
					System.out.println("차량등록 완료되었습니다.");
				}
				else {System.out.println("중복된 번호입니다.");}
				break;
			case 2 : 
				cus = new Customer();
				int cuNum;
				System.out.println("고객번호 : ");
				cuNum = scanner.nextInt();
				if(service.cusNumDup(cuNum)){
					cus.setCusNumber(cuNum);
					System.out.println("이름 : ");
					cus.setName(scanner.next());
					service.inputCustomer(cus);
					System.out.println("고객 등록이 완료되었습니다.");
				}
				else {System.out.println("중복된 번호입니다.");}
				break;
			case 3 : 
				service.searchCar();
				break;
			case 4 : 
				service.searchCustomer();
				break;
			case 5 : 
				int cusNum, carNum;
				System.out.println("고객번호를 등록하세요");
				cusNum = scanner.nextInt();
				System.out.println("차량 번호를 등록하세요");
				carNum = scanner.nextInt();
				service.sellCar(cusNum, carNum);
				break;
			default : 
				System.out.println("정확한 메뉴를 선택하세요.");
				break;
			}
		}
		
	}
}
