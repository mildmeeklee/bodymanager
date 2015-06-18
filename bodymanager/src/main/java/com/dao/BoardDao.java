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
		return list;
	}	
	
	public int getListCount(){
		int count = getSqlSession().selectOne("board.list_count");
		logger.info("getListCount :: count = "+count);
		return count;
	}
	
	
}
