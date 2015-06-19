package com.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.command.CommentCommand;
import com.dao.CommentDao;

public class CommentListingService {

	private CommentDao commentDao;
	private int board_num;
	private int currentPage;
	private int blockCount;
	private int blockPage;
	
	private PagingService pagingService;
	private HashMap<String, Integer> pageMap;
	
	private int commentTotalCount;
	
	private List<CommentCommand> list = new ArrayList<CommentCommand>();
	
	final static Logger logger = Logger.getLogger(CommentListingService.class);
	
	public CommentListingService() {
	}

	public CommentListingService(CommentDao commentDao, int board_num,
			int currentPage, int blockCount, int blockPage) {
		this.commentDao = commentDao;
		this.board_num = board_num;
		this.currentPage = currentPage;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		commentTotalCount = getCommentListCnt();
		pagingService = new PagingService(currentPage, commentTotalCount, blockCount, blockPage);
	}
	
	public int getCommentListCnt(){
		int count = commentDao.getCommentListCnt(board_num);
		logger.info("count :: "+count);
		return count;
	}

	public List<CommentCommand> getCommentList() {
		int startRow = pagingService.getStartCount();		
		int lastCount = commentTotalCount;  

		if (pagingService.getEndCount() < commentTotalCount)
			lastCount = pagingService.getEndCount() + 1;
		int endRow = lastCount;
		
		list = commentDao.selectList(board_num);		
		list = list.subList(startRow, endRow);
		logger.info(list);
				
		return list;
	}

	public HashMap<String, Integer> getCommentPageMap() {
		HashMap<String, Integer> cpageMap = pagingService.getPageMap();
		return cpageMap;
	}
	

	

	
}
