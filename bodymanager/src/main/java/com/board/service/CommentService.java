package com.board.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.CommentDao;

public class CommentService {

	private CommentDao commentDao;
	private int board_num;
	private String comment;
	private String user_id;
	private Map<String, Object> map;
	
	final static Logger logger = Logger.getLogger(CommentService.class);
	public CommentService() {
	}
	
	
	public CommentService(CommentDao commentDao, int board_num, String comment,
			String user_id) {
		this.commentDao = commentDao;
		this.board_num = board_num;
		this.comment = comment;
		this.user_id = user_id;
		setMap();
		
	}

	

	
	// insert comment start

	public void setMap() {		
		map = new HashMap<String, Object>();
		map.put("board_num", board_num);
		map.put("c_content", comment);
		map.put("user_id", user_id);	
		logger.info(map);
	}


	public void insert() {
		int check = commentDao.insertComments(map);
		logger.info(check);
	}
	
	// insert comment end

}
