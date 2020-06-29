package dailyProject;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		Customer customer = null;
		SimpleDateFormat currentDate = new SimpleDateFormat("MM/dd/HH:mm");
		boolean check = true;
		CustomerService cs = new CustomerServiceImpl();
		ShoppingService ss = new ShoppingServiceImpl();
		AdminService admin = new AdminServiceImpl();
		Calendar cal = Calendar.getInstance();
		Notice tempntc;
		Review review;
		Goods goods;
		String date = currentDate.format(cal.getTime());
		boolean ing = false;
		int scene = 0;
		switch (scene) {
		case 0:
			while (true && scene == 0) {
				System.out.println("메뉴 0:종료 1:회원가입 2:로그인 3:마이페이지 4.회원탈퇴 5.공지사항 조회 6.관리자메뉴");
				switch (scanner.nextInt()) {
				case 0:
					System.out.println("종료");
					return;
				case 1:
					customer = new Customer();
					System.out.println("[회원가입]");
					while (check) {
						System.out.println("ID:");
						customer.setUserId(scanner.next());
						check = cs.idCheck(customer);
					}
					check = true;
					System.out.println("PW:");
					customer.setUserPw(scanner.next());
					System.out.println("이름:");
					customer.setUserName(scanner.next());
					System.out.println("생년월일(예 123456-1):");
					customer.setUserBirth(scanner.next());
					cs.join(customer);
					break;
				case 2:
					customer = new Customer();
					System.out.println("[로그인]");
					System.out.println("ID:");
					customer.setUserId(scanner.next());
					System.out.println("PW:");
					customer.setUserPw(scanner.next());
					String result = cs.login(customer);
					System.out.println(result);
					scene = 1;
					break;
				case 3:
					customer = new Customer();
					System.out.println("[마이페이지]");
					System.out.println("ID:");
					customer.setUserId(scanner.next());
					System.out.println("PW:");
					customer.setUserPw(scanner.next());
					cs.myPage(customer);
					break;
				case 4:
					customer = new Customer();
					System.out.println("[회원탈퇴]");
					System.out.println("ID:");
					customer.setUserId(scanner.next());
					System.out.println("PW:");
					customer.setUserPw(scanner.next());
					result = cs.remove(customer);
					System.out.println(result);
					break;
				case 5:
					System.out.println("공지사항 조회");
					admin.printNotice();
					break;
				case 6:
					System.out.println("[관리자메뉴]");
					System.out.println("0. 뒤로가기  1. 공지사항 등록  2. 회원목록  3. 상품 등록  4. 상품조회  5. 상품 삭제  6. 재고 추가");
					switch (scanner.nextInt()) {
					case 0:
						break;
					case 1:
						System.out.println("추가할 공지사항 내용을 입력하세요");
						tempntc = new Notice();
						String temps = br.readLine();
						admin.writeNotice(tempntc, temps, date);
						admin.insertNotice(tempntc);
						System.out.println("공지 등록 완료");
						break;
					case 2:
						System.out.println("회원목록");
						cs.print();
						break;
					case 3:
						ss.addItem();
						break;
					case 4:
						System.out.println("조회할 상품 번호를 입력하세요");
						admin.searchProduct(scanner.nextInt());
						break;
					case 5:
						ss.eliminateItem();
						break;
					case 6:
						ss.addStock();
						break;
					default:
						System.out.println("정확한 메뉴를 선택하세요");
						break;
					}
					break;
				default:
					System.out.println("정확한 메뉴를 선택하세요");
					break;
				}

			}

		case 1:
			while (true && scene == 1) {
				System.out.println("2:아이템목록확인 3:리뷰작성 4:인기순정렬");
				int input = scanner.nextInt();
				switch (input) {
				case 2:
					int input2 = scanner.nextInt();
					System.out.println("0:전체 1:상의 2:하의 3:속옷 4:신발");
					switch (input2) {
					case 0:
						ss.showList(0);
						break;
					case 1:
						ss.showList(1);
						break;
					case 2:
						ss.showList(2);
						break;
					case 3:
						ss.showList(3);
						break;
					case 4:
						ss.showList(4);
						break;
					default:
						break;
					}

					break;
				case 3:
					review = new Review();
					System.out.println("리뷰를 작성할 상품번호를 입력하세요");

					System.out.println("리뷰 내용을 입력하세요");
					String tempsrv = br.readLine();
					admin.writeReview(review, tempsrv, "Guest", date);
				case 4:
					ss.showSalesRate();
					break;
				default:
					break;
				}
			}
		default:
			break;
		}

	}

}
