package theater;

import java.util.*;

public class Movie {
	
	//Genre genre_;
	String title;
	String genre;
	String actor;
	Calendar date;
	Calendar endDate;
	Theater theater;
	int price;
	int runningTime;
		
	public Movie(String title, String genre, String actor, String day , int runningTime, int price) {
		this.title = title;
		this.genre = genre;
		this.actor = actor;
		this.runningTime = runningTime;
		this.price = price;
		date = Calendar.getInstance();
		endDate = Calendar.getInstance();
		String[] str = day.split("-");
		int[] temp = new int[str.length];
		for(int i=0; i<str.length; i++) {
			temp[i] = Integer.parseInt(str[i]);
		}
		date.set(temp[0], temp[1], temp[2], temp[3], temp[4]);
		endDate.set(temp[0], temp[1], temp[2], temp[3], temp[4]+runningTime);
	}
	

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	public void show() {
		System.out.printf("제목:%s 장르:%s 관람료:%s\n",title,genre,price);
	}
	public String toString() {
		if(theater!=null) {
			return "[제목 :" + title + " 장르 :" + genre + " 배우 :" + actor
					+ " 상영일 :" + date.get(Calendar.YEAR)+"/"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.DATE) + " 상영관 :" + theater.name + "]";
		}
		else {
			return "[제목 :" + title + " 장르 :" + genre + " 배우 :" + actor
				+ " 상영일 :" + date.get(Calendar.YEAR)+"/"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.DATE) + " 상영관 :미정]";
		}
	}
	
	
}

class Genre{
	
}
