package theater;

import java.util.*;

public class Theater {
	Scanner scanner = new Scanner(System.in);
	String name;
	Movie movie;
	//ArrayList<Movie> movies = new ArrayList<Movie>();
	int[][] seat;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[][] getSeat() {
		return seat;
	}
	public void setSeat(int[][] seat) {
		this.seat = seat;
	}
	
	void showMovie() {
		
	}
	/*
	void showMovie() {
		for(int i=0; i<movies.size(); i++) {
			int year = movies.get(i).getDate().get(Calendar.YEAR);
			int month = movies.get(i).getDate().get(Calendar.MONTH);
			int day = movies.get(i).getDate().get(Calendar.DAY_OF_MONTH);
			int hour = movies.get(i).getDate().get(Calendar.HOUR_OF_DAY);
			int minute = movies.get(i).getDate().get(Calendar.MINUTE);
			String time = month+"월 "+day+"일 "+hour+"시 "+minute+"분 ";
			System.out.printf("상영관:%s관  ",name);
			System.out.printf("제목:%s  장르:%s  상영시각:%s  러닝타임 %s분\n",movies.get(i).getTitle(),movies.get(i).getGenre(),time,movies.get(i).getRunningTime());
			
		}
	}
	*/
	
	public String toString() {
		if(movie!=null) {
			return "[상영관 이름 :" + name + ", 상영 영화 :" + movie.getTitle() + "]";
		}
		else {
			return "[상영관 이름 :" + name + ", 상영 영화 : 미정]";
		}
	}


	Theater(String room, String name){
		seat = new int[Integer.parseInt(room.split(" ")[1])][Integer.parseInt(room.split(" ")[0])];
		this.name = name;
	}
	

}
