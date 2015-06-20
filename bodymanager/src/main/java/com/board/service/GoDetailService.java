package com.board.service;

import org.apache.log4j.Logger;

import com.command.BoardCommand;
import com.dao.BoardDao;

public class GoDetailService {

	static final Logger logger = Logger.getLogger(GoDetailService.class);
	
	private BoardDao boardDao;
	private  int board_num;
	
	public GoDetailService() {
	}
	public GoDetailService(BoardDao boardDao, int board_num) {
		this.boardDao = boardDao;
		this.board_num = board_num;
	}

	public BoardCommand getArticle(){
		int count = boardDao.updateReadcount(board_num);
		logger.info("count :: "+count);
		BoardCommand boardCommand = boardDao.getArticle(board_num);
		logger.info(boardCommand);
		return boardCommand;
	}

	
	
	
}
