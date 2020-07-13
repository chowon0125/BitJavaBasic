package p20200707;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

class Dog {
	private String name, kind;
	private int age, interval;
	private ArrayList<String> inoculate = new ArrayList<String>();
	private HashSet<String> handler = new HashSet<String>();
	private HashMap<String, String> family = new HashMap<String, String>();

	public Dog(String name, int age, String kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
		switch (kind) {
		case "셰퍼드":
			interval = 7;
			break;
		case "진도견":
			interval = 10;
			break;
		case "보더콜리":
			interval = 15;
			break;
		}
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getInoculate() {
		return inoculate;
	}

	public void setInoculate(ArrayList<String> inoculate) {
		this.inoculate = inoculate;
	}

	public HashSet<String> getHandler() {
		return handler;
	}

	public void setHandler(HashSet<String> handler) {
		this.handler = handler;
	}

	public HashMap<String, String> getFamily() {
		return family;
	}

	public void setFamily(HashMap<String, String> family) {
		this.family = family;
	}

	public void shotInoculate(String name, String date) { //미완성 - 훈련사 메소드와 동일한 로직으로 날짜 차이 계산 후 interval 변수보다 작다면 튕겨내버리는 식으로 구현 예정
		if (inoculate.contains(name + "/" + date)) {
			System.out.println("동일한 날짜에 같은 예방접종을 할 수 없습니다.");
		} else {
			inoculate.add(name + "/" + date);
		}
	}

	public void printInoculateHistory() {
		String[][] temp1 = new String[inoculate.size()][2];
		for (int i = 0; i < inoculate.size(); i++) {
			temp1[i] = (inoculate.get(i)).split("/");
		}
		for (int i = 0; i < inoculate.size(); i++) {
			System.out.printf("{%s} - {%s}", temp1[i][1], temp1[i][0]);
		}
	}

	public void addHandler(String name, String strDt, String endDt) {
		if(!handler.contains(name + "/" + strDt + "/" + endDt)) {
			handler.add(name + "/" + strDt + "/" + endDt);
		}
		else {System.out.println("중복 발생");}
	}

	public int getTotalHandlerPeriod() {
		String[] temp = new String[3];
		ArrayList<String> temp2 = new ArrayList<String>();
		String[] temp3 = new String[3];
		Calendar sd = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
		long temp4 = 0l;
		int sum = 0;
		temp2.addAll(handler);
		for (int i = 0; i < temp2.size(); i++) {
			temp = (temp2.get(i)).split("/");
			temp3 = temp[1].split("-");
			sd.set(Integer.parseInt(temp3[0]), Integer.parseInt(temp3[1]), Integer.parseInt(temp3[2]));
			temp3 = temp[2].split("-");
			ed.set(Integer.parseInt(temp3[0]), Integer.parseInt(temp3[1]), Integer.parseInt(temp3[2]));
			temp4 = (ed.getTimeInMillis() - sd.getTimeInMillis()) / 1000;
			temp4 /= (60 * 60 * 24);
			sum += (int) temp4;
		}
		return sum;
	}

	public void addFamily(String info) {
		String[] temp = new String[2];
		temp = info.split("/");
		if (!family.containsValue(temp[1])) {
			family.put(temp[0], temp[1]);
		} else {
			System.out.println("이름이 중복됩니다.");
		}
	}

}

public class P0707_1 {
	public static void main(String[] args) {
		Dog d = new Dog("캐빈", 10, "셰퍼드");
		d.addHandler("홍길동", "2019-01-05", "2019-02-01");
		d.addHandler("김길동", "2019-05-09", "2019-05-30");
		System.out.println(d.getTotalHandlerPeriod() + "일");

	}

}
