package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.command.TimetableCommand;
import com.dao.TimetableDao;

@Controller
public class TimetableController {

	@Autowired
	TimetableDao timetableDao;

	public void setTimetableDao(TimetableDao timetableDao) {
		this.timetableDao = timetableDao;
	}

	@RequestMapping(value = "timetablelist.do", method = RequestMethod.GET)
	public ModelAndView timetableList() {
		ModelAndView mav = new ModelAndView("timetable/list");
		return mav;
	}

	// ajax start
	@RequestMapping(value = "gettitlelist.do", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAjax(@RequestParam(value = "userID") String userID, ModelMap map) {
		ModelAndView mav = new ModelAndView("timetable/list");
		System.out.println("id :: "+userID);
		List<TimetableCommand> list = timetableDao.selectTitleList("study");
		for(TimetableCommand a :list){
			System.out.println(a.toString());
			
		}
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "gettitlelist.do", method = RequestMethod.POST)
	public @ResponseBody ModelAndView postAjax(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("timetable/list");
//		String userId =  request.getParameter("data");
//		System.out.println("postAjax id :: "+userId);
		List<TimetableCommand> list = timetableDao.selectTitleList("study");
		for(TimetableCommand a :list){
			System.out.println(a.toString());
			
		}
		/*
		 * String userId =  request.getParameter("hi");
		
		System.out.println("postAjax id :: "+userId);
		List<TimetableCommand> list = timetableDao.selectTitleList("study");
		for(TimetableCommand a :list){
			System.out.println(a.toString());
			
		}
		mav.addObject("timeTableList", new TimeTableList(list))
		 */
		mav.addObject("list", list);
		return mav;
	}
	// ajax end
}
