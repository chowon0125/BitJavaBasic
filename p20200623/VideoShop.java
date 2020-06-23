package p20200623;

class Video{
	private int videoNo;
	private String title;
	private String actor;
	
	void setVideoData(int vno, String t, String a) {
		videoNo = vno;
		title = t;
		actor = a;
	}
	int getVideoN() {
		return videoNo;
	}
	String getTitle() {
		return title;
	}
	String getActor() {
		return actor;
	}
}

class GeneralMember{
	private int memberNo;
	private String name;
	private String address;
	private Video rentalVideo;
	
	void setMemberData(int mno, String n, String a, Video rv) {
		memberNo = mno;
		name = n;
		address = a;
		rentalVideo = rv;
	}
	
	void printMemberData() {
		System.out.println("회원번호 : "+memberNo);
		System.out.println("이름 : "+name);
		System.out.println("주소 : "+address);
		System.out.println("대여중인 비디오 번호 : "+rentalVideo.getVideoN());
		System.out.println("대여중인 비디오 제목 : "+rentalVideo.getTitle());
		System.out.println("대여중인 비디오 배우 : "+rentalVideo.getActor());
	}
}

class SpecialMember extends GeneralMember{
	private int bonusPoint;
	
	void setBonusPoint(int b) {
		bonusPoint = b;
	}
	void printBonusPoint() {
		System.out.println("보너스 포인트 : "+bonusPoint);
	}
	
	
}
public class VideoShop {
	public static void main(String[] args) {
		Video v = new Video();
		v.setVideoData(100, "뽀로로 탐험대", "김뽀로");
		
		SpecialMember m = new SpecialMember();
		m.setMemberData(1, "허영석", "광진구 123번지", v);
		m.setBonusPoint(10);
		m.printMemberData();
		m.printBonusPoint();
	}

}
