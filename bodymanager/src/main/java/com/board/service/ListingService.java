package com.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.command.BoardCommand;
import com.dao.BoardDao;

public class ListingService {

	static final Logger logger = Logger.getLogger(ListingService.class);
	
	private BoardDao boardDao;
	private int currentPage;
	private int blockCount;
	private int blockPage;
	private PagingService pagingService;
	private HashMap<String, Integer> pageMap;

	private int totalCount;
	
	private List<BoardCommand> list = new ArrayList<BoardCommand>();
	
	public ListingService() {
	}
	public ListingService(BoardDao boardDao, int currentPage, int blockCount,
			int blockPage) {
		this.boardDao = boardDao;
		this.currentPage = currentPage;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.totalCount = getListCount();
		this.pagingService = new PagingService(currentPage, totalCount, blockCount, blockPage);
	}
	
	public int getListCount(){
		int count = boardDao.getListCount();
		logger.info("count :: "+count);
		return count;
	}
	public List<BoardCommand> getBoardList(){	
		Map<String, Integer> map = new HashMap<String, Integer>();
		int startRow = pagingService.getStartCount();
		
		int lastCount = totalCount;  
		
		if (pagingService.getEndCount() < totalCount)
			lastCount = pagingService.getEndCount() + 1;
		int endRow = lastCount;
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		list = boardDao.selectList(map);
		
//		list = list.subList(pagingService.getStartCount(), lastCount);
		return list;
	}
	
	public HashMap<String, Integer> getPageMap(){
		HashMap<String, Integer> pageMap = this.pagingService.getPageMap();
		return pageMap;
	}
	

}
