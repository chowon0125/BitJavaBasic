package theater;

import java.util.*;

public class TheaterSystemImpl implements TheaterSystem {
	static Scanner scanner = new Scanner(System.in);
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Theater> theater = new ArrayList<Theater>();
	ArrayList<Movie> movieList = new ArrayList<Movie>(); 
	Customer customer;
	
	
	
	//테스트코드
	public TheaterSystemImpl() {
		Theater t1 = new Theater("5 5","A");
		Theater t2 = new Theater("6 6","B");
		Theater t3 = new Theater("7 5","C");
		Theater t4 = new Theater("8 6","D");
		theater.add(t1);
		theater.add(t2);
		theater.add(t3);
		theater.add(t4);
	}
	public static void main(String[] args) {
		TheaterSystemImpl ts = new TheaterSystemImpl();
		while(true) {
			System.out.println("0. 관리자 메뉴 1. 회원가입 2. 로그인 ");
			switch(scanner.nextInt()) {
			case 0 :
				ts.managerPage();
				
				break;
			case 1 : 
				ts.signup(); 
				break;
			case 2 : 
				ts.login();
				break;
			case 3 :
				break;
			case 4:
			}
		}
	}
	//

	@Override
	public void signup() {
		customer = new Customer();
		Boolean check = true;
		while(check) {
			check = false;
			System.out.println("아이디를 입력해주세요.");
			String id = scanner.next();
			customer.setId(id);
			for(int i=0; i<customers.size(); i++) {
				if(customers.get(i).getId().equals(id)) {
					System.out.println("이미 존재하는 아이디 입니다.");
					check = true;
				}
			}
		}
		System.out.println("비밀번호를 입력해주세요.");
		String pw = scanner.next();
		customer.setPw(pw);
		System.out.println("이름을 입력해주세요.");
		String name = scanner.next();
		customer.setName(name);
		System.out.println("회원가입이 완료되었습니다.");
		customers.add(customer);
	}
	
	

	@Override
	public void login() {
		customer = new Customer();
		System.out.println("[로그인]");
		System.out.print("ID : ");
		customer.setId(scanner.next());
		System.out.println();
		System.out.print("PW : ");
		customer.setPw(scanner.next());
		System.out.println();
		for (int i = 0; i < customers.size(); i++) {
			if (customer.getId().equals(customers.get(i).getId())
					&& customer.getPw().equals(customers.get(i).getPw())) {
				System.out.printf(customers.get(i).getName()+"님 환영합니다*^^*%n");
				userPage(i);
			} else {
				System.out.printf("아이디 및 비밀번호를 확인해주세요.\n\n");
			}
		}	
	}

	@Override
	public void userPage(int idx) {
		while(true) {
			System.out.println("0:로그아웃 1:내 정보 확인 2:영화검색 3:영화예매 4:예매확인 5:잔액충전");
			int input = scanner.nextInt();
			switch (input) {
			case 0:
				System.out.println("로그아웃 되었습니다.");
				return;
			case 1: customers.get(idx).showMypage();
				System.out.println("뒤로가려면 아무키나 눌러주세요.");
				String in = scanner.next();
				while(true) {
					if(in!="qinvlkw") {
						break;
					}
				} break;
			case 2: 
				//movieSearch(); 
				searchMovieAll();
				break;
			case 3: 
				String output = reserveMovie(customers.get(idx));
				if(!"".equals(output)) {
					ArrayList<String> temp=customers.get(idx).getReservation();
					temp.add(output);
					customers.get(idx).setReservation(temp);					
				}
				break;
			case 4: customers.get(idx).showReservation(); break;	
			case 5: 
				chargeMoney(idx); break;
			default: System.out.println("잘못된 입력입니다.");
				break;
			}
			
		}
	}

	@Override
	public void movieSearch() {
		System.out.println("현재 상영중인 영화 목록 : ");
		for(int i=0; i<movieList.size(); i++) {
			movieList.get(i).show();
		}
	}

	@Override
	public String reserveMovie(Customer customer) {
		Movie movie;
		int idx;
		Loop0:
		while(true) {
			System.out.println("현재 상영중인 영화 목록 :");
			for(int i=0; i<movieList.size(); i++) {
				movieList.get(i).show();
			}
			System.out.println("예약할 영화를 입력해주세요.");
			String input = scanner.next();
			for(int i=0; i<movieList.size(); i++) {
				if(movieList.get(i).getTitle().equals(input)&&customer.getMoney()<movieList.get(i).price) {
					System.out.println("잔액이 부족합니다.");
					return "";
				}
				if(movieList.get(i).getTitle().equals(input)) {
					movie = movieList.get(i);
					break Loop0;
				}
			}
			System.out.println("잘못 입력하셨습니다.");		
		}
		Loop1:
		while(true) {
			System.out.println("예약할 영화의 상영관을 입력해주세요.");
			for(int i=0; i<theater.size(); i++) {
				/*if(theater.get(i).movies.contains(movie)) {
					System.out.println(theater.get(i).getName());
				}*/
				if(theater.get(i).movie==null) {
					continue;
				}
				if(theater.get(i).movie.equals(movie)) {
					System.out.println(theater.get(i).getName());
				}
				
				//임시
				
			}
			String input = scanner.next();
			for(int i=0; i<theater.size(); i++) {
				if(theater.get(i).getName().equals(input)) {
					idx = i;
					break Loop1;
				}
			}	
			System.out.println("잘못 입력하셨습니다.");
		}
		showSeat(theater.get(idx));
		String seatNum;
		Loop2:
		while(true) {
			System.out.println("예약하실 좌석번호를 입력해주세요.");
			seatNum = scanner.next();
			int num = (seatNum.charAt(0))-65;
			if(theater.get(idx).getSeat()[Integer.parseInt(seatNum.split("")[1])-1][num]==0) {
				theater.get(idx).getSeat()[Integer.parseInt(seatNum.split("")[1])-1][num] = 1;
				System.out.printf("%s 좌석 예약되었습니다.\n",seatNum);
				customer.setMoney(customer.getMoney()-movie.price);	
				break Loop2;
			}else {
				System.out.println("이미 예약된 좌석입니다.");
			}
		}
		String seat = theater.get(idx).getName()+" "+seatNum;
		return seat;	
	}

	@Override
	public void chargeMoney(int idx) {
		System.out.println("충전하실 금액을 입력하세요.");
		int money = scanner.nextInt();
		customers.get(idx).setMoney(customers.get(idx).getMoney()+money);
		System.out.println("충전이 완료되었습니다.");
	}


	@Override
	public void showSeat(Theater theater) {
		System.out.print("   ");
		for(int i=0; i<theater.getSeat()[0].length; i++) {
			System.out.printf((char)(65+i)+"   ");
		}
		System.out.println();
		for(int i=0; i<theater.getSeat().length; i++) {
			System.out.printf("%d ",i+1);
			for(int j=0; j<theater.getSeat()[i].length; j++) {
				if(theater.getSeat()[i][j] == 0) {
					System.out.printf("[ ] ");
				}else {
					System.out.printf("[x] ");
				}				
			}
			System.out.println();
		}
	}
	
	public void managerPage() {
		while(true) {
			System.out.println("0: 돌아가기 1: 영화등록 2: 상영관에 영화등록 3: 영화제거 4: 상영관에서 영화내리기 5: 상영관 전체조회 6: 등록된 영화 전체조회");
			int input = scanner.nextInt();
			switch (input) {
			case 0:
				return;
			case 1:
				System.out.println("영화제목, 장르, 배우를 입력해주세요.");
				String title = scanner.next();
				String genre = scanner.next();
				String actor = scanner.next();
				System.out.println("상영시각을 입력해주세요.");
				String date = scanner.next();
				System.out.println("러닝타임과 가격을 입력해주세요.");
				int runningtime = scanner.nextInt();
				int price = scanner.nextInt();
				enterMovieInformation(new Movie(title,genre,actor,date,runningtime,price));
				break;
			case 2: 
				System.out.println("영화이름과 상영관 이름을 입력해주세요.");
				String str1 = scanner.next();
				String str2 = scanner.next();
				regProcess(str1, str2);
				break;
			case 3:
				System.out.println("제거할 영화 제목을 입력해주세요.");
				String name = scanner.next();
				deleteMovieInformation(name);
				break;
			case 4:
				System.out.println("상영 중지 할 영화 제목을 입력해주세요.");
				String name2 = scanner.next();
				deleteMovie(name2);
				break;
			case 5:
				lookUpTheater(); break;
			case 6:
				lookUpMovie(); break;
			default:
				break;
			}
			
		}
	}
	
	
	
	
	
	public void regProcess(String movie, String theater) {
		int k = searchMovie(movie);
		if(k==-1) {System.out.println("등록된 영화정보가 없습니다");}
		else {registerMovie(k, theater);}
	}
	
	public int searchMovie(String name) {
		int idx = 0, k = -1;
		for(Movie m : movieList) {
			if((m.getTitle()).equals(name)) {
				k = idx;
			}
			idx++;
		}
		return k;
	}
	
	public void registerTheater(Theater theater) {
		this.theater.add(theater);
	}

	public void registerMovie(int k, String name) {
		int idx = -1 ;
		for(int i=0; i<theater.size(); i++) {
			if(theater.get(i).getName().equals(name)) {
				idx = i;
				movieList.get(k).theater = theater.get(i);
				theater.get(i).movie = movieList.get(k);
			}
		}
		if(idx!=-1) {System.out.printf("%s 상영관에 '%s'영화를 등록했습니다.\n",theater.get(idx).getName(),theater.get(idx).movie.getTitle());}
		else {System.out.println("상영관 정보를 찾을 수 없습니다.");}
	}
	
	public void deleteMovie(String name) {
		int idx = -1 ;
		for(int i=0; i<theater.size(); i++) {
			if(theater.get(i).getName().equals(name)) {
				idx = i;
				theater.get(i).movie = null;
			}
		}
		if(idx!=-1) {System.out.printf("%s 상영관의 영화 정보를 제거했습니다.\n",theater.get(idx).getName());}
		else {System.out.println("상영관 정보를 찾을 수 없습니다.");}
	}
	
	public void enterMovieInformation(Movie movie) {
		movieList.add(movie);
	}
	
	public void deleteMovieInformation(String name) {
		int j = -1;
		int i = 0;
		for(Movie m : movieList) {
			if((m.getTitle()).contains(name)) {
				j = i; 
			}
			i++;
		}
		if(j!=-1) {
			System.out.printf("'%s' 영화를 목록에서 제거합니다.\n",movieList.get(j).getTitle());
			for(int k=0; k<theater.size();k++) {
				if(theater.get(k).movie!=null&&(theater.get(k).movie.getTitle()).contains(movieList.get(j).getTitle())) {
					theater.get(k).movie = null;
				}
			}
			movieList.remove(j);
		}
		else {System.out.println("영화 정보를 찾을 수 없습니다.");}
	}
	
	public void lookUpMovie() {
		for(Movie m : movieList) {
			System.out.println(m.toString()); 
		}
	}
	
	public void lookUpTheater() {
		for(Theater t : theater) {
			System.out.println(t.toString());
		}
	}
	
	
	
	public void searchMovieAll() {
		int i = 0;
		System.out.println("[현재 상영중인 영화정보]");
		for(int k=0; k<theater.size();k++) {
			if(theater.get(k).movie!=null) {
				System.out.println(theater.get(k).movie.toString()); i++;
			}
		}
		if(i==0) {System.out.println("상영중인 영화가 없습니다.");}
	}
	
	public void searchMovieByGenre(String genre) {
		int i = 0;
		System.out.printf("[현재 상영중인 %s장르 영화정보]\n",genre);
		for(int k=0; k<theater.size();k++) {
			if(theater.get(k).movie!=null&&(theater.get(k).movie.getGenre()).contains(genre)) {
				System.out.println(theater.get(k).movie.toString()); i++;
			}
		}
		if(i==0) {System.out.printf("상영중인 %s장르의 영화가 없습니다.\n",genre);}
	}

}
