package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.service.CommentListingService;
import com.board.service.ListingService;
import com.command.BoardCommand;
import com.command.CommentCommand;
import com.dao.BoardDao;
import com.dao.CommentDao;
/**
 * 
 * @author eylee
 *
 */

@Controller
@RequestMapping("/board")
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
	
	
	
	@RequestMapping(value="/boardlist.do", method= RequestMethod.GET)
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
	}
	
//	detail.do?board_num
	@RequestMapping(value="/detail.do", method=RequestMethod.GET)
	public ModelAndView getDetailArticle(@RequestParam(value="board_num") int board_num, @RequestParam(value="p", defaultValue="1") int currentPage){
		logger.info(board_num);
		ModelAndView mav = new ModelAndView("board/detail");	
		logger.info("currentPage :: "+currentPage);
		BoardService boardService = new BoardService(boardDao, board_num);
		BoardCommand boardCommand = boardService.getArticle();
		logger.info(boardCommand);
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
	
	// write start
	@RequestMapping("/writeform.do")
	public String writeForm(@RequestParam(value="board_num", defaultValue="0") int board_num, @RequestParam(value="ref_g", defaultValue="0") int ref_g, 
			@RequestParam(value="re_step", defaultValue="0") int re_step, @RequestParam(value="re_level", defaultValue="0") int re_level, Model model){		
		logger.info("board_num :: "+board_num+", ref_g :: "+ref_g+", re_step :: "+re_step+", re_level :: "+re_level);
			model.addAttribute("board_num", board_num);
			model.addAttribute("ref_g", ref_g);
			model.addAttribute("re_step", re_step);
			model.addAttribute("re_level", re_level);
		return "board/write";
	}
	
	@RequestMapping(value="/writesave.do", method=RequestMethod.POST )
	public String writeArticle(@RequestParam(value="board_num", defaultValue="0") int board_num, @RequestParam(value="ref_g", defaultValue="0") int ref_g, 
			@RequestParam(value="re_step", defaultValue="0") int re_step, @RequestParam(value="re_level", defaultValue="0") int re_level, 
			String subject, String content, int category){
		logger.info("board_num :: "+board_num+", ref_g :: "+ref_g+", re_step :: "+re_step+", re_level :: "+re_level);
		logger.info("title :: "+subject +", category :: "+category);
		logger.info("content :: "+content);
		Map<String, Object> writeMap = new HashMap<String, Object>();
		writeMap.put("board_num", board_num);
		writeMap.put("ref_g", ref_g);
		writeMap.put("re_step", re_step);
		writeMap.put("re_level", re_level);
		writeMap.put("subject", subject);
		writeMap.put("category", category);
		writeMap.put("content", content);
		writeMap.put("user_id", "eylee");
		
		BoardService addBoardService = new BoardService(boardDao, writeMap);
		addBoardService.addArticle();
	
		return "redirect:/board/boardlist.do";
	}	
	// write end	
	
	//update start
//	contextPath+'/board/updateform.do?board_num='+board_num+'&p='+p;
	@RequestMapping("/updateform.do")
	public String updateForm(@RequestParam(value="board_num", defaultValue="0") int board_num,
			@RequestParam(value="p", defaultValue="1") int currentPage, ModelMap map){		
		logger.info("board_num :: "+board_num+", currentPage :: "+currentPage);
//	
		BoardService boardService = new BoardService(boardDao, board_num);
		BoardCommand boardCommand = boardService.getArticleCommand();
		logger.info(boardCommand);		
		map.put("article", boardCommand);
		map.put("p", currentPage);
		return "board/update";
		
	}
	
	@RequestMapping(value="/updatesave.do", method=RequestMethod.POST)
	public String updateArticle(BoardCommand boardCommand, @RequestParam(value="p", defaultValue="1") int currentPag){
		logger.info(boardCommand);
		logger.info(currentPag);
		boardCommand.setUser_id("eylee");
//		 		select_detail
		BoardService boardService = new BoardService(boardDao, boardCommand);
		int count = boardService.updateArticle();
		logger.info("count :: "+count);
		return "redirect:/board/boardlist.do?p="+currentPag;
		
	}
	
	// update end
	
	// delete article start
	@RequestMapping(value="/deletearticle.do", method=RequestMethod.GET)
	public String deleteArticle(@RequestParam(value="board_num", defaultValue="0") int board_num,
			@RequestParam(value="p", defaultValue="1") int currentPage){
		logger.info("board_num :: "+board_num+", currentPage :: "+currentPage);
		BoardService boardService = new BoardService(boardDao, board_num);
		int count = boardService.deleteArticle();
		logger.info("count :: "+count);
		return "redirect:/board/boardlist.do?p="+currentPage;
	}
	
	// delete article end
	
	
}
