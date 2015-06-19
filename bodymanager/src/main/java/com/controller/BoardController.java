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

import com.board.service.CommentListingService;
import com.board.service.CommentService;
import com.board.service.DetailService;
import com.board.service.ListingService;
import com.command.BoardCommand;
import com.command.CommentCommand;
import com.dao.BoardDao;
import com.dao.CommentDao;

@Controller
public class BoardController {

	@Autowired
	BoardDao boardDao;

	@Autowired
	CommentDao commentDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}



	static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value="/board/boardlist.do", method= RequestMethod.GET)
	public ModelAndView getBoardList(@RequestParam(value="p", defaultValue="1") int currentPage){
		
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
	public ModelAndView getDetailArticle(@RequestParam(value="board_num") int board_num, @RequestParam(value="p", defaultValue="1") int currentPage){
		logger.info(board_num);
		ModelAndView mav = new ModelAndView("board/detail");	
		logger.info("currentPage :: "+currentPage);
		DetailService detailService = new DetailService(boardDao, board_num);
		BoardCommand boardCommand = detailService.getArticle();
		mav.addObject("article", boardCommand);
		
		int blockCount = 3;	 
		int blockPage = 3;	 
		CommentListingService clistingService = new CommentListingService(commentDao, board_num, currentPage, blockCount, blockPage);
		List<CommentCommand> clist = clistingService.getCommentList();
		HashMap<String, Integer> cpageMap = clistingService.getCommentPageMap();
		logger.info(cpageMap);
		mav.addObject("clist", clist);
		mav.addObject("cpageMap", cpageMap);
		return mav;
	}
	
	@RequestMapping("board/write.do")
	public String writeBoard(){		
		return "board/write";
	}
	
	
	
	
}
