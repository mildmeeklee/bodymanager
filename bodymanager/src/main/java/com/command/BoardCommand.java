package com.command;

import java.util.Date;


public class BoardCommand {

	private int board_num;
	private String subject;
	private String content;
	private String user_id;
	private Date reg_date;
	private int ref_g;
	private int re_step;
	private int re_level;
	private int cat_id;
	private int readcount;
	private int rownum;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRef_g() {
		return ref_g;
	}
	public void setRef_g(int ref_g) {
		this.ref_g = ref_g;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "[ BoardCommand = board_num : " + board_num+", subject : "+subject+", content : "+content
				+", user_id : "+user_id+", reg_date : " +reg_date+", ref_g : "+ref_g+", re_step : "+re_step
				+", re_level : "+re_level+", cat_id : "+cat_id+", readcount : "+readcount+" ]";
	}
	
}
