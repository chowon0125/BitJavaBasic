package race;

public class Player {

	private String name;
	private int record;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setRec(int record) {
		this.record = record;
	}
	public int getRec() {
		return this.record;
	}
	
	
	void result() {
	
		System.out.println("�̸� :" + name + "��� :" + record);
		
	
	}
	}
