package dailyProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Notice {
	String notice;
	String writer = "관리자";
	String date;
}

class Review {
	String review;
	String writer;
	String date;
}

class Product {
	int reviewIdx = 0;
	Review[] review = new Review[50];
	String name;
	int productNum;
	int stock;
	int price;
}

interface AdminService {
	
	//상품번호 검색(관리자)
	public void searchProduct(int productNum);
	
	//공지사항 작성
	public void writeNotice(Notice notice, String content, String date);
	
	//공지사항 등록
	public void insertNotice(Notice notice);
	
	//공지사항 출력
	public void printNotice();
	
	//리뷰 작성
	public void writeReview(Review instance, String content, String writer, String date);
	
	//리뷰 등록
	public void insertReview(Product product, Review review);
	
	//리뷰 출력
	public void printReview(Product product);
	
}

class AdminServiceImpl implements AdminService{
	
	int productIdx = 0;
	Product[] productList = new Product[50]; 
	int noticeIdx = 0;
	Notice[] noticeList = new Notice[50];

	public void searchProduct(int productNum) {
		boolean check = true;
		for(int i=0; i<productIdx; i++ ) {
			if(productNum == productList[i].productNum) {
				System.out.printf("상품번호 : %d%n"
						+ "상품명 : %s%n"
						+ "가격 : %d%n"
						+ "재고 : %d%n"
						,productList[i].productNum,productList[i].name,productList[i].price,productList[i].stock);
				check = false; break;
			}
		}
		if(check) {System.out.println("일치하는 상품번호가 없습니다.");}
	}

	public void writeNotice(Notice notice, String content, String date) {
		notice.notice = content;
		notice.date = date;
	}
	
	public void insertNotice(Notice notice) {
		noticeList[noticeIdx] = notice;
		noticeIdx++;
	}
	
	public void printNotice() {
		System.out.println("[공지사항]");
		for(int i=0; i< noticeIdx; i++) {
			System.out.printf("[no.%d]  ", noticeIdx - i);
			System.out.printf("[%s / 작성자 %s / 작성일%s]%n", noticeList[noticeIdx-1-i].notice
					,noticeList[noticeIdx-1-i].writer,noticeList[noticeIdx-1-i].date);
		}
		
	}

	public void writeReview(Review instance, String content, String writer, String date) {
		instance.review = content;
		instance.writer = writer;
		instance.date = date;
	}

	public void insertReview(Product product, Review review) {
		product.review[product.reviewIdx] = review;
		product.reviewIdx++;
	}

	public void printReview(Product product) {
		System.out.println("[상품리뷰]");
		for (int i = 0; i < product.reviewIdx; i++) {
			System.out.printf("[no.%d]  ", product.reviewIdx - i);
			System.out.printf("[%s / 작성자 : %s / 작성일 (%s)]%n", (product.review[product.reviewIdx - 1 - i]).review,
					(product.review[product.reviewIdx - 1 - i]).writer,
					(product.review[product.reviewIdx - 1 - i]).date);
		}
	}

}

public class Temp1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat currentDate = new SimpleDateFormat("MM/dd/HH:mm");
		Calendar cal = Calendar.getInstance();
		Notice notice = new Notice();
		Review review = new Review();
		Product shirt1 = new Product();
		AdminService admin = new AdminServiceImpl();

		String writer = "abc";
		String writer2 = "cde";
		String date = currentDate.format(cal.getTime());
		String date2 = "0630";
		System.out.println("리뷰입력");
		admin.writeReview(review, scanner.nextLine(), writer, date);
		admin.insertReview(shirt1, review);
		admin.printReview(shirt1);
		
		System.out.println(notice.writer);

	}

}
