package project_0713;

import java.util.Calendar;
import java.util.Random;

public class ServiceImpl implements IntegrationInterface {

	
	public int inputGrade(int score) {
		int result =0;	
			
			if(score >= 90) {
				result = 4;
			}else if(score >= 70) {
				result = 3;
			}else if(score >= 50) {
				result = 2;
			}else if(score < 50) {
				result = 1;
			}
			
		return result;
	}
	
	
	public int calGrade(Member member) {
		int subScore=0, lessScore=0, familyScore=0, totalScore=0;
		
		if(member.getSubPeriod()>1095) {
			subScore = 40;
		}else if(member.getSubPeriod()>730) {
			subScore = 30;
		}else if(member.getSubPeriod()>365) {
			subScore = 20;
		}
		else subScore = 10;
		
		if(member.getLessPeriod()>1095) {
			lessScore = 40;
		}else if(member.getLessPeriod()>730) {
			lessScore = 30;
		}else if(member.getLessPeriod()>365) {
			lessScore = 20;
		}
		else lessScore = 10;
		
		if(member.getFamilyNum()>3) {
			familyScore = 40;
		}else if(member.getFamilyNum()>2) {
			familyScore = 30;
		}else if(member.getFamilyNum()>1) {
			familyScore = 20;
		}
		else familyScore = 10;
		
		totalScore = subScore + lessScore + familyScore;
		
		return totalScore;
	}
	
	public int calPeriod(Calendar stDate, Calendar edDate) {
		return (int)((edDate.getTimeInMillis() - stDate.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}
	
	public String competition(Housing housing, Member member) {
		int pool = poolSize(housing, member);
		int oneSelf = 0;
		
		if(member.getGrade()>3) {
			oneSelf += 4;
		}else if(member.getGrade()>2) {
			oneSelf += 3;
		}else if(member.getGrade()>1) {
			oneSelf += 2;
		}else if(member.getGrade()>0) {
			oneSelf += 1;
		}
		double rate = (double)oneSelf / (double)pool;
		rate *= 100;
		return String.format("%s 매물의 당첨확률 : %.2f",housing.getName(),rate) + "%";
	}
	
	public String simulator(Housing housing, Member member) {
		Random random = new Random();
		int oneSelf = 0;
		int randomNum = random.nextInt(poolSize(housing, member))+1;
		
		String result = "";
		
		if(member.getGrade()>3) {
			oneSelf += 4;
		}else if(member.getGrade()>2) {
			oneSelf += 3;
		}else if(member.getGrade()>1) {
			oneSelf += 2;
		}else if(member.getGrade()>0) {
			oneSelf += 1;
		}
		
		if(randomNum <= oneSelf) {
			result = "당첨";
		}
		else {
			result = "탈락";
		}
		return result;
	}
	
	public int poolSize(Housing housing, Member member) {
		int pool = 0, oneSelf =0;
		boolean dup = true;
		
		for(int i=0; i<housing.getApplicant().size(); i++) {
			if(housing.getApplicant().get(i).getGrade()>3) {
				pool += 4;
			}else if(housing.getApplicant().get(i).getGrade()>2) {
				pool += 3;
			}else if(housing.getApplicant().get(i).getGrade()>1) {
				pool += 2;
			}else if(housing.getApplicant().get(i).getGrade()>0) {
				pool += 1;
			}
		}
		
		if(member.getGrade()>3) {
			oneSelf += 4;
		}else if(member.getGrade()>2) {
			oneSelf += 3;
		}else if(member.getGrade()>1) {
			oneSelf += 2;
		}else if(member.getGrade()>0) {
			oneSelf += 1;
		}
		
		for(int i=0; i<housing.getApplicant().size(); i++) {
			if((housing.getApplicant().get(i).getId()).equals(member.getId())) {
				dup = false; break;
			}
		}
		if(dup) {
			pool += oneSelf;
		}
		return pool;
	}
	
	public void addApplicant(Housing housing, Member member) {
		housing.getApplicant().add(member);
	}
	
	public Calendar calPeriod(String date) {
		String arr[] = new String[3];
		Calendar c = Calendar.getInstance();
		arr = date.split("/",3);
		c.set(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		return c;
	}
	
	public int finalCalculate(String date) {
		String asdf[] = new String[2];
		asdf = date.split("-",2);
		return calPeriod(calPeriod(asdf[0]),calPeriod(asdf[1]));
	}
	
}
