package com.worktracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worktracker.dao.WorkoutCategoryDAO;
import com.worktracker.dao.WorkoutCollectionDAO;
import com.worktracker.entity.WorkoutCollection;
import com.worktracker.vo.WorkoutCollectionVO;

@Service
@Transactional
public class WorkoutCollectionServiceImp implements WorkoutCollectionService {
	
	@Autowired
	WorkoutCollectionDAO workoutCollectionDAO;
	
	@Autowired
	WorkoutCategoryDAO WorkoutCategoryDAO;

	@Override
	public List<WorkoutCollection> getWorkoutCollectionList() {
		// TODO Auto-generated method stub
		return workoutCollectionDAO.getWorkoutCollection();
	}

	@Override
	public WorkoutCollection findById(int id) {
		// TODO Auto-generated method stub
		WorkoutCollection workoutCollection;
		try {
			workoutCollection = workoutCollectionDAO.findById(id);
		}catch(Exception ex) {
			workoutCollection = null;
		}
		System.out.println(workoutCollection);
		return workoutCollection;
	}

	@Override
	public void createWorkoutCollection(WorkoutCollectionVO workoutCollectionVO) {
		// TODO Auto-generated method stub
		WorkoutCollection workoutCollection = new WorkoutCollection();
		workoutCollection.setCaloriesBurnPerMin(workoutCollectionVO.getCaloriesBurnPerMin());
		workoutCollection.setWorkoutNote(workoutCollectionVO.getWorkoutNote());
		workoutCollection.setWorkoutTitle(workoutCollectionVO.getWorkoutTitle());
		workoutCollection.setWorkoutCategory(WorkoutCategoryDAO.findById(workoutCollectionVO.getCategoryId()));
		workoutCollectionDAO.addWorkoutCollection(workoutCollection);
	}

	public void deleteWrkCollectionById(int id) {
		// TODO Auto-generated method stub
		workoutCollectionDAO.delete(id);
	}
	/*@Override
	public WorkoutActive updatePartially(WorkoutActiveDAO user, int id) {
		workoutActiveDAO.updateCountry(user,id);
		return workoutActiveDAO.findById(id);
	}

	@Override
	public WorkoutActive update(WorkoutActiveDAO user,int id) {
		// TODO Auto-generated method stub
		return workoutActiveDAO.update(user, id);
	}*/

}
