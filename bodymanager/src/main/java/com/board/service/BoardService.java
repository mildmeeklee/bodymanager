package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.command.BoardCommand;
import com.dao.BoardDao;

public class BoardService implements BoardInterface{

	private BoardDao boardDao;
	private  Map<String, Object> writeMap = new HashMap<String, Object>();
	private boolean isReply = false;// 답글이라면
	
	private int board_num;
	private int currentPage;
	private BoardCommand boardCommand;
	
	final static Logger logger = Logger.getLogger(BoardService.class);
	public BoardService() {
	}
	
	//construction for insert 
	public BoardService(BoardDao boardDao, Map<String, Object> writeMap) {
		this.boardDao = boardDao;
		this.writeMap = writeMap;
	}
	
	// construction for  goto detail   // construction for update // construction for  delete article
	public BoardService(BoardDao boardDao, int board_num) {
		this.boardDao = boardDao;
		this.board_num = board_num;
	}

	
	// construction for update 
	public BoardService(BoardDao boardDao, BoardCommand boardCommand) {
		this.boardDao = boardDao;
		this.boardCommand = boardCommand;
	}

	// construction for index.jsp / welcome
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	// insert
	public int addArticle(){
		
		// 글의 그룹번호
		int board_maxNum = boardDao.getMaxBoardnum();   //제일 마지막에 쓴글(num 최고값)
		logger.info("board_maxNum :: "+board_maxNum);
		
		int board_num =(Integer) writeMap.get("board_num");
		
		if (board_num != 0) {  // board_num 이 파라미터로 전달되지 않았다면 답글!! 
			isReply = true;
		}
		
		int ref_g = (Integer) writeMap.get("ref_g");
		int re_step = (Integer) writeMap.get("re_step");
		int re_level =(Integer) writeMap.get("re_level");
		
		if(board_maxNum != 0)  
			board_maxNum = board_maxNum +1;
		else
			board_maxNum = 1;
		
		// 답글이라면
		if (isReply==true) {
			Map<String, Integer> groupMap = new HashMap<String, Integer>();
			groupMap.put("ref_g", ref_g);
			groupMap.put("re_step", re_step);
			groupMap.put("re_level", re_level);
			logger.info("groupMap :: "+groupMap);
			boardDao.updateArticle_group(groupMap);
			re_step = re_step +1;
			re_level = re_level +1;
			
		}else{
			ref_g = board_maxNum;
			re_step = 0;
			re_level = 0;
		}
		
		BoardCommand boardCommand = new BoardCommand();
		boardCommand.setCat_id((Integer)writeMap.get("category"));
		boardCommand.setContent((String) writeMap.get("content"));
		boardCommand.setRe_level(re_level);
		boardCommand.setRe_step(re_step);
		boardCommand.setRef_g(ref_g);
//		boardCommand.setReadcount((Integer) writeMap.get("readcount"));
		boardCommand.setSubject((String) writeMap.get("subject"));
		boardCommand.setUser_id((String) writeMap.get("user_id"));
		
		int count = boardDao.addArticle(boardCommand);
		logger.info(count);
		return count;
	}
	
	
	// goto detail page start
	public BoardCommand getArticle(){
		int count = boardDao.updateReadcount(board_num);
		logger.info("count :: "+count);
		BoardCommand boardCommand = boardDao.getArticle(board_num);
		logger.info(boardCommand);
		return boardCommand;
	}
	// goto detail page end

	
	
	// update start
	public BoardCommand getArticleCommand(){
		BoardCommand boardCommand = boardDao.getArticle(board_num);
		logger.info(boardCommand);
		return boardCommand;
	}
	public int updateArticle() {
		logger.info(boardCommand);
		int count = boardDao.updateArticle(boardCommand);
		return count;
	}
	
	// update end

	// delete article start
	
	public int deleteArticle(){
		int count = boardDao.deleteArticle(board_num); 
		logger.info("count :: "+count);
		return count;
	}
	// delete article end
	
	//select list5 start
	public List<BoardCommand> getLatestList(){
		List<BoardCommand> list= boardDao.getLatestList();
		logger.info(list);
		return list;
	}
	
	//select list5 end
	
}
