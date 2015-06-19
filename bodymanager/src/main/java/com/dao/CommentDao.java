package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.command.CommentCommand;

public class CommentDao extends SqlSessionDaoSupport{

	final static Logger logger = Logger.getLogger(CommentDao.class);
	
	
	public int insertComments(Map<String, Object> map) {
		logger.info(map);
		int check = getSqlSession().insert("comment.insert_comment", map);
		logger.info(check);
		return check;		
	}


	public int getCommentListCnt(int board_num) {
		logger.info(board_num);
		int count = getSqlSession().selectOne("comment.list_count", board_num);
		return count;
	}


	public List<CommentCommand> selectList(int board_num) {
		logger.info(board_num);
		List<CommentCommand> list = getSqlSession().selectList("comment.list_all", board_num);
		return list;
	}
}
