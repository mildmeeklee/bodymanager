package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.BoardDao;

@Controller
public class BoardController {

	/*@Autowired
	BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}*/
	
	static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value="/board/boardlist.do", method= RequestMethod.GET)
	public String boardlist(){
		logger.info("hi");
		return "board/list";
	}
}
