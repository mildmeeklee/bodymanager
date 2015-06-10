package com.command;



public class TimetableCommand {

	private int tt_num;
	private String title;
	private String content;
	private int charge;
	private String goal;
	public int getTt_num() {
		return tt_num;
	}
	public void setTt_num(int tt_num) {
		this.tt_num = tt_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "tt_num :: "+tt_num +", title :: " + title+", content :: " + content+", charge :: " + charge +", goal :: " + goal;
	}
	
	
}
