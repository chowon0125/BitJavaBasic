package theater;

import java.util.ArrayList;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

public class Customer {
	
	String id,pw,name;
	ArrayList<Movie> Movies = new ArrayList<Movie>();
	ArrayList<String> reservation = new ArrayList<String>();
	int money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public ArrayList<String> getReservation() {
		return reservation;
	}
	public void setReservation(ArrayList<String> reservation) {
		this.reservation = reservation;
	}
	public void showReservation() {
		System.out.println(reservation);
		for(int i=0; i<reservation.size(); i++) {
		}
	}
	public void showMypage() {
		System.out.printf("이름 : %s 아이디 : %s 비밀번호 : %s 현재 충전된 금액 : %d \n",name,id,pw,money);
	}
}
