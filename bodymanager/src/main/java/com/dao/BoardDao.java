package com.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.command.TimetableCommand;

public class BoardDao extends SqlSessionDaoSupport{

	public List<TimetableCommand> selectTitleList(String title){
		System.out.println("selectTitleList :: title = " + title);
		List<TimetableCommand> list = getSqlSession().selectList("timetable.list_withtitle", title);
		return list;
	}	
}
