package com.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.command.TimetableCommand;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="timetable-list")
public class TimeTableList {

	@XmlElement(name="page-rank")
	private List<TimetableCommand> timetableList;
	
	public List<TimetableCommand> getTimetableList() {
		return timetableList;
	}

	public TimeTableList() {
	}

	public TimeTableList(List<TimetableCommand> timetableList) {
		this.timetableList = timetableList;
	}
	
	
}
