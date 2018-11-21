package com.worktracker.service;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worktracker.dao.WorkoutActiveDAO;
import com.worktracker.dao.WorkoutCollectionDAO;
import com.worktracker.entity.WorkoutActive;
import com.worktracker.entity.WorkoutCollection;
import com.worktracker.vo.WorkoutActiveVO;

@Service
@Transactional
public class WorkoutActiveServiceImp implements WorkoutActiveService {
	@Autowired
	WorkoutActiveDAO workoutActiveDAO;
	@Autowired
	WorkoutCollectionDAO workoutCollectionDAO;


	public List<WorkoutActive> getWorkoutActive() {
		return workoutActiveDAO.getWorkoutAct();
	}

	public WorkoutActive findById(int id) {
		return workoutActiveDAO.findById(id);
	}

	public void updateWorkoutActive(WorkoutActiveVO workoutActiveVO) {
		
		
		WorkoutActive workoutActive = findById(workoutActiveVO.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		long ms;
		try {
			ms = sdf.parse(workoutActiveVO.getEndTime()).getTime();
			Time t = new Time(ms);
			workoutActive.setEndTime(t);
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		       System.out.println(DateFormat.parse(workoutActiveVO.getEndDate()));
		       workoutActive.setEnddate(new java.sql.Date(DateFormat.parse(workoutActiveVO.getEndDate()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		workoutActive.setStatus(false);
		workoutActive.setWorkoutId(workoutActiveVO.getWorkoutId());
		workoutActive.setComment(workoutActiveVO.getComment());
		workoutActiveDAO.update(workoutActive,workoutActiveVO.getId());
	}
	public void createWorkoutActive(WorkoutActiveVO workoutActiveVO) {
		
		WorkoutActive workoutActive =new WorkoutActive();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		long ms;
		try {
			ms = sdf.parse(workoutActiveVO.getStartTime()).getTime();
			Time t = new Time(ms);
			workoutActive.setStartTime(t);
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		       System.out.println(DateFormat.parse(workoutActiveVO.getStartDate()));
		       workoutActive.setStartdate(new java.sql.Date(DateFormat.parse(workoutActiveVO.getStartDate()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		workoutActive.setStatus(true);
		workoutActive.setWorkoutId(workoutActiveVO.getWorkoutId());
		workoutActive.setComment(workoutActiveVO.getComment());
		
		workoutActiveDAO.addWorkoutAct(workoutActive);
	}
	public void deleteWorkoutActive(WorkoutActive workoutActive) {
	}
	
}
