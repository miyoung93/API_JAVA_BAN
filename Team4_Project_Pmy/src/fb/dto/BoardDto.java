package fb.dto;

import java.util.Date;

public class BoardDto {
	int board_no;
	String subject;
	String content;
	Date cre_date;
	int hits = 0;
	int member_no;
	String member_name;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardDto(int board_no, String subject, String content, Date cre_date, int hits, int member_no,
			String member_name) {
		super();
		this.board_no = board_no;
		this.subject = subject;
		this.content = content;
		this.cre_date = cre_date;
		this.hits = hits;
		this.member_no = member_no;
		this.member_name = member_name;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	
}
