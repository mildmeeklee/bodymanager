package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.CommentService;
import com.dao.CommentDao;

@Controller
public class CommentController {

	@Autowired
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	final static Logger logger = Logger.getLogger(CommentController.class);

	@RequestMapping(value="/board/writecomment.do", method=RequestMethod.POST)
	public String writeComments(@RequestParam("board_num") int board_num, @RequestParam("comment") String comment){
		logger.info(board_num);
		logger.info(comment);
		String user_id = "eylee";
		CommentService commentService = new CommentService(commentDao, board_num, comment, user_id);
		commentService.insert();
		return "redirect:/board/detail.do?board_num="+ board_num;
	}
}
