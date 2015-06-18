package com.board.service;

import java.util.HashMap;
import java.util.Map;

public class BoardService implements BoardInterface{
	public void getlistall(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		int startRow = 1;
		int endRow = 10;
		map.put("startRow", startRow);
		map.put("endRow", endRow);
//		System.out.println("modifyPasswd :: map.get passwd = "+map.get("passwd"));
//		System.out.println("modifyPasswd :: map.get id = "+map.get("id"));
//		int count = memberDao.updatePasswd(map);
	}
}
