package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.command.BoardCommand;

public class BoardDao extends SqlSessionDaoSupport{

	static final Logger logger  = Logger.getLogger(BoardDao.class);
	
	public List<BoardCommand> selectList(Map<String, Integer> map){
		logger.info("selectList :: map = " + map);
		List<BoardCommand> list = getSqlSession().selectList("board.list_all", map);
		logger.info(list);
		return list;
	}	
	
	public int getListCount(){
		int count = getSqlSession().selectOne("board.list_count");
		logger.info("getListCount :: count = "+count);
		return count;
	}
	
//	update_readcount
	public int updateReadcount(int  board_num){
		logger.info("board_num :: "+board_num);
		int count = getSqlSession().update("board.update_readcount", board_num);
		logger.info("updateReadcount :: count = "+count);	
		return count;
	}
	
	public BoardCommand getArticle(int board_num){
		BoardCommand boardCommand = getSqlSession().selectOne("board.select_detail", board_num);
		logger.info(boardCommand);
		return boardCommand;
	}

	public int getMaxBoardnum(){
		int board_num = getSqlSession().selectOne("board.select_board_num");
		logger.info("board_num :: "+board_num);
		return board_num;
	}
	
	public int updateArticle_group(Map<String, Integer> groupMap){
//		udpate_article_group
		logger.info("groupMap :: "+groupMap);
		int count = getSqlSession().update("board.udpate_article_group", groupMap);
		logger.info("updateArticle_group :: count = "+count);
		return count;
	}
	
	public int addArticle(BoardCommand boardCommand) {
		logger.info(boardCommand);
		int count = getSqlSession().insert("board.add_article", boardCommand);
		logger.info("addArticle :: count = "+count);		
		return count;
	}

	//update article 
	public int updateArticle(Map<String, Integer> map) {
		logger.info("map :: "+map);
		int count = getSqlSession().update("board.update_article", map);
		return 0;
	}

	public int updateArticle(BoardCommand boardCommand) {
		logger.info("boardCommand :: "+boardCommand);
		int count = getSqlSession().update("board.update_article", boardCommand);
		return count;
	}

	
	
}
