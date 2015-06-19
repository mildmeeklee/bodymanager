package com.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.DetailService;
import com.board.service.ListingService;
import com.command.BoardCommand;
import com.dao.BoardDao;

@Controller
public class BoardController {

	@Autowired
	BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value="/board/boardlist.do", method= RequestMethod.GET)
	public ModelAndView boardlist(@RequestParam(value="p", defaultValue="1") int currentPage){
		logger.info("hi");
		ModelAndView mav = new ModelAndView("board/list");
		logger.info("currentPage :: "+currentPage);
		int blockCount = 3;	 
		int blockPage = 3;	 
		
		ListingService listingService = new ListingService(boardDao, currentPage, blockCount, blockPage);
		List<BoardCommand> list =  listingService.getBoardList();
		HashMap<String, Integer> pageMap = listingService.getPageMap();
		mav.addObject("list", list);
		mav.addObject("pageMap", pageMap);
		return mav;
//		return "board/list";
	}
	
//	detail.do?board_num
	@RequestMapping(value="/board/detail.do", method=RequestMethod.GET)
	public ModelAndView boarddetail(@RequestParam(value="board_num") int board_num){
		logger.info(board_num);
		ModelAndView mav = new ModelAndView("board/detail");
		
		DetailService detailService = new DetailService(boardDao, board_num);
		BoardCommand boardCommand = detailService.getArticle();
		mav.addObject("article", boardCommand);
		return mav;
	}
	
	@RequestMapping("board/write.do")
	public String boardwrite(){		
		return "board/write";
	}
	
	
}
