package p20200701;

import java.util.Scanner;

abstract class Book {
	int number;
	String title, author;
	
	Book(int number, String title, String author){
		this.number = number;
		this.title = title;
		this.author = author;
	}
	
	public boolean equals(Book book) {
		if(this.number == book.number) {
			return true;
		}
		else {return false;}
	}
	
	public int getLateFee(int date) {
		int result;
		result = 100 * date;
		return result;
	}
	
	public String toString() {
		return String.format("[관리자번호 : %d, 제목 : %s, 저자 : %s]",
				number, title, author); 
	}
}

class Animation extends Book{
	Animation(int number, String title, String author){
		super(number, title, author);
	}
	
	public int getLateFee(int date) {
		int result;
		result = 300 * date;
		return result;
	}
}

class Science extends Book{
	Science(int number, String title, String author){
		super(number, title, author);
	}
	
	public int getLateFee(int date) {
		int result;
		result = 200 * date;
		return result;
	}
}

public class P0701_2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Book book1 = new Animation(1,"애니1","애니작가1");
		Book book2 = new Science(2,"과학2","야스오");
		Book book3 = new Animation(1,"애니1","애니작가1");
		System.out.println(book1.equals(book3));
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		int lateFee;
		lateFee = book1.getLateFee(6);
		System.out.println(lateFee+"원");
		lateFee = book2.getLateFee(6);
		System.out.println(lateFee+"원");
		
	}

}
