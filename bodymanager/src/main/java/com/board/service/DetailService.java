package com.board.service;

import org.apache.log4j.Logger;

import com.command.BoardCommand;
import com.dao.BoardDao;

public class DetailService {

	static final Logger logger = Logger.getLogger(DetailService.class);
	
	private BoardDao boardDao;
	private  int board_num;
	
	public DetailService() {
	}
	public DetailService(BoardDao boardDao, int board_num) {
		this.boardDao = boardDao;
		this.board_num = board_num;
	}

	public BoardCommand getArticle(){
		BoardCommand boardCommand = boardDao.getArticle(board_num);
		logger.info(boardCommand);
		return boardCommand;
	}

	
	
	
}
