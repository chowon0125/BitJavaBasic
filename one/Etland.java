package one;

import java.util.Scanner;

/**
 @author H.Kim
 @since 2020.06.18
 @param kind 종류, company 제조사, call 통화
*/

class Product{
	
	
}

class TV extends Product{
	public final static String KIND = "TV";
	@Override public String toString() {return String.format("%s", KIND);}
}

class ColorTV extends TV{
	public final static String KIND = "컬러TV";
	@Override public String toString() {return String.format("%s", KIND);}
	
}

class Computer extends Product{
	public final static String KIND = "컴퓨터";
	@Override public String toString() {return String.format("%s", KIND);}
}

class Notebook extends Computer{
	public final static String KIND = "노트북";
	@Override public String toString() {return String.format("%s", KIND);}
}

class BelPhone extends Product{
	
	public final static String KIND = "유선전화기";
	@Override public String toString() {return String.format("%s", KIND);}

	
}

class CelPhone extends BelPhone{
	
	public final static String KIND = "피쳐폰";
	@Override public String toString() {return String.format("%s", KIND);}

	
}

class IPhone extends CelPhone{
	
	public final static String KIND = "아이폰";
	@Override public String toString() {return String.format("%s", KIND);}

}

class GalPhone extends IPhone{
	
	public final static String KIND = "갤럭시";
	@Override public String toString() {return String.format("%s", KIND);}

}


public class Etland{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Product[] cart = new Product[5];
		int index = 0;
		while(true) {
			System.out.println("쇼핑목록 : 0.종료  1.아이폰  2.갤럭시  3.컬러TV 4.컴퓨터  5.노트북 6.쇼핑목록보기");
			switch (scanner.nextInt()) {
			case 0: System.out.println("EXIT"); return;
			case 1: cart[index] = new IPhone(); index++; break;
			case 2: cart[index] = new GalPhone(); index++; break;
			case 3: cart[index] = new ColorTV(); index++; break;
			case 4: cart[index] = new Computer(); index++; break;
			case 5: cart[index] = new Notebook(); index++; break;
			case 6: 
				for(Product p : cart) {
					System.out.println(p.toString());
				}
				
				break;
			}
		}
	}
}
