package com.worktracker.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="workout_active")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkoutActive {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="status")
	private boolean status;
	
	@Column(name="comment")	
	private String comment;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="start_date")
	private Time startdate;
	
	@Column(name="end_date")
	private Time enddate;
	
	
	@ManyToOne
	@JoinColumn(name="workout_id")
	private WorkoutCollection workoutCollection;

	

	public WorkoutCollection getWorkoutCollection() {
		return workoutCollection;
	}

	public void setWorkoutCollection(WorkoutCollection workoutCollection) {
		this.workoutCollection = workoutCollection;
	}

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
	

}
