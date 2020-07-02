package p20200702;

import java.util.Calendar;

abstract class Project {
	private String name, startDt, endDt, location;
	private Developer[] dev = new Developer[100];
	private int devIdx = 0;

	public Project() {
	}

	public Project(String name, String startDt, String endDt, String location) {
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.location = location;
	}

	public Project(String name, String startDt, String endDt, String location, Developer[] dev) {
		this(name, startDt, endDt, location);
		for (int i = 0; i < dev.length; i++) {
			this.dev[i] = dev[i];
			devIdx++;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Developer[] getDev() {
		return dev;
	}

	public void setDev(Developer[] dev) {
		this.dev = dev;
	}

	public void process() {
		plan();
		design();
		develop();
	}

	public void plan() {
		System.out.println("프로젝트 준비");
	}

	public void join(Developer d) {
		dev[devIdx] = d;
		devIdx++;
	}

	public abstract void design();

	public abstract void develop();

	public int getPeriod() {
		Calendar sd = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
		String[] arr = new String[3];
		int[] arr2 = new int[3];
		arr = getStartDt().split("/", 3);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		sd.set(arr2[0], arr2[1], arr2[2]);

		arr = getEndDt().split("/", 3);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		ed.set(arr2[0], arr2[1], arr2[2]);

		long diffSec = (ed.getTimeInMillis() - sd.getTimeInMillis()) / 1000;
		long difDay = diffSec / (60 * 60 * 24);

		return (int) difDay;
	}

	public int getMMByDeveloper() {
		int sum = 0;
		for (int i = 0; i < devIdx; i++) {
			sum += dev[i].getPeriod();
		}
		return sum / 30;
	}

	public void printDeveloper() {
		for (int i = 0; i < devIdx; i++) {
			if (dev[i] instanceof HighDeveloper) {
				System.out.println("고급개발자 " + dev[i].getName() + "/특기 " + ((HighDeveloper) dev[i]).getSpecialSkill());
			} else {
				System.out.println("일반개발자 " + dev[i].getName());
			}
		}
	}
}

class HrProject extends Project {
	
	public HrProject(String name, String startDt, String endDt, String location) {
		super(name, startDt, endDt, location);
	}

	public void design() {
		System.out.println("HR 설계작업수행");
	}

	public void develop() {
		System.out.println("개발작업수행");
	}
}

class Developer extends Project {

	private int period;

	public Developer(String name, int period) {
		super();
		setName(name);
		this.period = period;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void design() {

	}

	public void develop() {

	}

}

class HighDeveloper extends Developer {

	private String specialSkill;

	public HighDeveloper(String name, int period, String specialSkill) {
		super(name, period);
		this.specialSkill = specialSkill;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}
}

public class P0702_1 {
	public static void main(String[] args) {
		Project p = new HrProject("HR 프로젝트", "2019/01/01", "2019/12/31", "서울");
		Developer p1 = new Developer("홍길동", 10);
		Developer p2 = new Developer("김길동", 15);
		HighDeveloper p3 = new HighDeveloper("김고급", 12, "Java");
		p.join(p1);
		p.join(p2);
		p.join(p3);
		System.out.println("프로젝트 총 Resource:"+p.getMMByDeveloper());
		p.printDeveloper();
		p.process();
		System.out.println(p.getPeriod());
		
	}
}
