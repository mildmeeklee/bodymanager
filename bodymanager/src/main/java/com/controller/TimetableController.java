package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.command.TimetableCommand;
import com.dao.TimetableDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TimetableController {

	@Autowired
	TimetableDao timetableDao;

	public void setTimetableDao(TimetableDao timetableDao) {
		this.timetableDao = timetableDao;
	}

	static final Logger logger  = Logger.getLogger(TimetableController.class);
	
	@RequestMapping(value = "/timetable/timetablelist.do", method = RequestMethod.GET)
	public ModelAndView timetableList() {
		logger.info("Going to create timetableList Obj eylee");
		ModelAndView mav = new ModelAndView("timetable/list");
		return mav;
	}

	// ajax start
	

	/**
	 * mildmeeklee  2015.06.11
	 * add ajax controller
	 * @param userID
	 * @param response
	 */
	@RequestMapping(value = "gettitlelist.do", method = RequestMethod.GET, headers="accept=application/json")
	public void getAjax(@RequestParam(value = "userID") String userID, HttpServletResponse response) {
		System.out.println("getAjax id :: "+userID);
		
		List<TimetableCommand> list = timetableDao.selectTitleList("study");
		for(TimetableCommand a :list){
			System.out.println(a.toString());
			
		}
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/xml; charset= utf-8");
		try {
			response.getWriter().print(mapper.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// ajax end
	//<a  href="timetable/getTimetable/user/eylee/bd/0308">g
	@RequestMapping("/timetable/getTimetable/user/{user}/bd/{bd}")
	public String getTimetableList(@PathVariable String user, @PathVariable("bd") int birthday){
		return "timetable/list";
	}
}
