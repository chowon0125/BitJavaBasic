package theater;

public interface TheaterSystem {
	
	
	public void signup(); //회원가입
	public void login();
	public void userPage(int idx); //고객페이지
	public void movieSearch();
	public String reserveMovie(Customer customer); //예매
	public void chargeMoney(int idx); //돈충전
	public void showSeat(Theater theater);
	
	public void regProcess(String movie, String theater);
	public int searchMovie(String name);
	public void registerTheater(Theater theater);
	public void registerMovie(int k, String name); //영화등록
	public void deleteMovie(String name);
	public void enterMovieInformation(Movie movie);
	public void deleteMovieInformation(String name);
	public void lookUpMovie();
	public void lookUpTheater();
	/* 
	 * 
	 * 판매
	 * 
	 * 고객페이지-
	 * 고객 클래스 - 돈, 예매리스트, 아이디비번 등등, 
	 * (VIP고객클래스 - 고객 상속, 할인시스템 구현)
	 * 회원가입
	 * 로그인
	 * 돈을 충전 
	 * 예매 (할인) ㄱ 집어넣기
	 * 영화 예매 확인 customer의 예매리스트 arraylist{}  ...
	 * 영화검색 (장르별) - Movie.getGenre;
	 * 
	 * 
	 * 
	 * 
	 * (좌석선택)
	 * 
	 * 
	 * 영화 시스템 - 
	 * 영화 분류 (장르별)
	 * 영화 속성 - 장르, 가격, 기간, 이름, 배우들 , 상영관 ...
	 * 상영관에 영화 등록
	 * 상영관에 영화 삭제
	 * 
	 * 영화관 시스템
	 * 속성 - 상영관
	 * 
	 * 상영관 class
	 * 속성 - 좌석 (위치)
	 * 
	 * 
	 */

	
	
	
}


