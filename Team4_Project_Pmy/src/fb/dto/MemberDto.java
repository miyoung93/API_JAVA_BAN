package fb.dto;

import java.util.Date;

public class MemberDto {
	int no;
	String first_name;
	String last_name;
	String email;
	String pwd;
	Date birth_date;
	String gender;
	String full_name;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int no, String first_name, String last_name, String email, String pwd, Date birth_date,
			String gender, String full_name) {
		super();
		this.no = no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.pwd = pwd;
		this.birth_date = birth_date;
		this.gender = gender;
		this.full_name = full_name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	
}
