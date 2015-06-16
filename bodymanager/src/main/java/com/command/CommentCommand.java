package com.command;

import java.util.Date;

public class CommentCommand {

	private int comment_num;
	private int board_num;
	private String comment;
	private String user_id;
	private Date reg_date;
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	
	@Override
	public String toString() {
		return "[ CommentCommand = comment_num : "+comment_num+", board_num : "+board_num+", comment : "+comment
				+", user_id :"+user_id+", reg_date : "+reg_date+" ]";
	}
	
}
