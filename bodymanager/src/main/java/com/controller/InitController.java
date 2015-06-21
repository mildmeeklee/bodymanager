package com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.service.BoardService;
import com.command.BoardCommand;
import com.dao.BoardDao;

@Controller
public class InitController {

	static final Logger logger = Logger.getLogger(InitController.class);
	@Autowired
	BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@RequestMapping("/intro.do")
	public String getWelcome(ModelMap map) {
		logger.info("getWelcome init!!");
		BoardService boardService = new BoardService(boardDao);
		List<BoardCommand> list = boardService.getLatestList();
		logger.info(list); 
		map.addAttribute("boardlist", list);
		return "/intro";
	}
}
