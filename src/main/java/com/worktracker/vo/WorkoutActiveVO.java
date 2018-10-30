package com.worktracker.vo;

import java.sql.Time;

public class WorkoutActiveVO {

	private int id;

	private boolean status;
	
	private String comment;
	
	private Time startTime;
	
	private Time endTime;
	
	private Time startdate;
	
	private Time enddate;	
	
	private int  workoutId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Time getStartdate() {
		return startdate;
	}

	public void setStartdate(Time startdate) {
		this.startdate = startdate;
	}

	public Time getEnddate() {
		return enddate;
	}

	public void setEnddate(Time enddate) {
		this.enddate = enddate;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	
	
}
