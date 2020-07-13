package project_0713;

import java.sql.Date;
import java.util.ArrayList;

public class Housing {
	String idx, name, location;
	ArrayList<Member> applicant = new ArrayList<>();
	Date stDate, edDate;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ArrayList<Member> getApplicant() {
		return applicant;
	}
	public void setApplicant(ArrayList<Member> applicant) {
		this.applicant = applicant;
	}
	public Date getStDate() {
		return stDate;
	}
	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}
	public Date getEdDate() {
		return edDate;
	}
	public void setEdDate(Date edDate) {
		this.edDate = edDate;
	}
	
}
