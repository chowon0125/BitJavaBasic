package phone;

import java.util.Scanner;

/**
 @author H.Kim
 @since 2020.06.18
 @param kind 종류, company 제조사, call 통화
*/

class BelPhone{
	
	protected String kind, company, call;
	public String getKind() {return kind;}
	public void setKind(String kind) {this.kind = kind;}
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	public String getCall() {return call;}
	public void setCall(String call) {this.call = call;}
	public String toString() {
		return String.format("집전화기 [폰종류=%s, 제조사=%s, 통화내역=%s]", kind,company,call);
	}
}

class CelPhone extends BelPhone{
	
	public final static String KIND = "휴대폰";
	protected boolean portable;
	protected String move;
	public boolean isPortable() {return portable;}
	public void setPortable(boolean portable) {
		move = (portable)?"이동중에":"이동불가능";
		this.portable = portable;
	}
	public String getMove() {return move;}
	public void setMove(String move) {this.move = move;}
	public String toString() {
		return String.format("%s인 %s제품을 사용해서 %s %s이라 통화한다.", KIND, company, move, call);
	}
}

class IPhone extends CelPhone{
	
	public final static String KIND = "아이폰";
	protected String search;
	public String getSearch() {return search;}
	public void setSearch(String search) {this.search = search;}
	public String toString() {	
		return String.format("%s의 %s을 사용해서 %s %s을 한다.", company, KIND, move, search);
	}
}

class GalPhone extends IPhone{
	
	public final static String KIND = "갤럭시";
	protected String pay;
	public String getPay() {return pay;}
	public void setPay(String pay) {this.pay = pay;}
	public String toString() {	
		return String.format("%s %s 제품을 사용해서, %s %s한다.",company, KIND, move, pay);
	}
}

public class Phone{
	
	public static void main(String[] args) {
		BelPhone phone = null;
		CelPhone cel = null;
		IPhone iPhone = null;
		GalPhone galaxy = null;
		BelPhone[] arr = new BelPhone[1];
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("0. EXIT  1. 집전화걸기  2. 전화받기  3. 휴대폰걸기  4. 아이폰사용  5. 갤럭시사용");
			switch (scanner.nextInt()) {
			case 0: System.out.println("EXIT"); return;
			case 1: 
				phone = new BelPhone();
				phone.setKind("집전화");
				phone.setCompany("금성사");
				phone.setCall("안녕하세요.");
				arr[0] = phone;
				break;
			case 2:
				System.out.println(arr[0].toString());break;
			case 3:
				cel = new CelPhone();
				cel.setCompany("노키아");
				cel.setPortable(true);
				cel.setCall("통화중");
				arr[0] = cel;
				break;
			case 4:
				iPhone = new IPhone();
				iPhone.setCompany("애플");
				iPhone.setPortable(true);
				iPhone.setSearch("뉴스검색");
				arr[0] = iPhone;
				break;
			case 5:
				galaxy = new GalPhone();
				galaxy.setCompany("삼성");
				galaxy.setPortable(true);
				galaxy.setPay("삼성페이결제");
				arr[0] = galaxy;
				break;
				
			}
		}
	}
}
