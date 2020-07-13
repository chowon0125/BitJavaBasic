package project_0713;

import java.util.Calendar;

public interface IntegrationInterface {
	
	public int calGrade(Member member);
	
	public int calPeriod(Calendar stDate, Calendar edDate);
	
	public String competition(Housing housing, Member member);

	public String simulator(Housing housing, Member member);
	
	public int poolSize(Housing housing, Member member);
	
	public int inputGrade(int score);
	
	public void addApplicant(Housing housing, Member member);
	
	public Calendar calPeriod(String date);
	
	public int finalCalculate(String date);
}
