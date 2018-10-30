package com.worktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worktracker.entity.WorkoutActive;
import com.worktracker.service.WorkoutService;
import com.worktracker.vo.WorkoutActiveVO;

@RestController
@RequestMapping(value={"/workoutactive"})
public class WorkoutActiveController {
	@Autowired
	WorkoutService workoutService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkoutActive> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        WorkoutActive user = workoutService.findById(id);
        if (user == null) {
            return new ResponseEntity<WorkoutActive>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<WorkoutActive>(user, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody WorkoutActiveVO workoutActiveVO){
	     System.out.println("Creating User "+workoutActiveVO.getId());
	     workoutService.createWorkoutActive(workoutActiveVO);
	     HttpHeaders headers = new HttpHeaders();
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<WorkoutActive> getAllUser() {	 
	  List<WorkoutActive> tasks=workoutService.getWorkoutActive();
	  return tasks;
	
	 }

	/*@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody WorkoutActiveDAO currentUser)
	{
		System.out.println("sd");
	WorkoutActiveDAO user = userService.findById(currentUser.getId());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<WorkoutActiveDAO> deleteUser(@PathVariable("id") int id){
		WorkoutActiveDAO user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<WorkoutActiveDAO>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<WorkoutActiveDAO>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<WorkoutActiveDAO> updateUserPartially(@PathVariable("id") int id, @RequestBody WorkoutActiveDAO currentUser){
		WorkoutActiveDAO user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<WorkoutActiveDAO>(HttpStatus.NOT_FOUND);
		}
		WorkoutActiveDAO usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<WorkoutActiveDAO>(usr, HttpStatus.OK);
	}*/
}
