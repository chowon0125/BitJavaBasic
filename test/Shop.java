package test;

public class Shop {
	
	private String name;
	private int phoneValue, tvValue, comValue, sum;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setPV(int phoneValue) {
		this.phoneValue = phoneValue;
	}
	public int getPV() {
		return this.phoneValue;
	}
	public void setTV(int tvValue) {
		this.tvValue = tvValue;
	}
	public int getTV() {
		return this.tvValue;
	}
	public void setCV(int comValue) {
		this.comValue = comValue;
	}
	public int getCV() {
		return this.comValue;
	}
	
	public void sum() {
		this.sum = this.phoneValue + this.comValue + this.tvValue;
	}
	
	public void result() {
		System.out.println(name+"님"+" 결제하실 총 금액은 " + sum/10000 + "만원입니다.");
	}
}
