package org.capg.controller;


import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.capg.dto.TraineeDTO;
import org.capg.entities.Trainee;
import org.capg.service.ITraineeService;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.LoggerFactory;

import com.capg.exceptions.TraineeNotFoundException;

import java.util.logging.Logger;

@RestController
@RequestMapping("/trainees")
public class TraineeRestController {
	
	@Autowired
	public ITraineeService service;
	
	
	/*------------Add Trainee---------------*/
	 @PostMapping("/add")
	    public ResponseEntity<Trainee>createEmployee(@RequestBody TraineeDTO dto){
		 Trainee trainee=convertFromDto(dto);
		 trainee=service.add(trainee);
	     ResponseEntity<Trainee>response=new ResponseEntity<>(trainee, HttpStatus.OK);
	     return response;
	   }

	 public Trainee convertFromDto(TraineeDTO dto){
	       Trainee t1=new Trainee();
	       t1.setTraineeId(dto.getTraineeId());
	       t1.setTraineeName(dto.getTraineeName());
	       t1.setTraineeDomain(dto.getTraineeDomain());
	       t1.setTraineeLocation(dto.getTraineeLocation());
	       return t1;
	   }

	 /*-----------------Retrieve 1 trainee info-------------*/
	@GetMapping("/getById/{traineeId}")
	public ResponseEntity<Trainee> findEmployee( @PathVariable("traineeId") @Min(1)  int id)
	{
		Trainee trainee = service.findById(id);
		ResponseEntity<Trainee> response = new ResponseEntity<>(trainee,HttpStatus.OK);
		return response;
	}
	
	/*--------------Retrieve All trainee  info-------------- */
	
	@GetMapping
	public ResponseEntity<List<Trainee>>fetchAll(){
	       List<Trainee> trainees=service.retreiveAll();
	       ResponseEntity<List<Trainee>>response=new ResponseEntity<>(trainees,HttpStatus.OK);
	       return response;
	   }

	/*-----------------------Delete Trainee-----------------------*/
	@DeleteMapping("/delete/{traineeId}")
	public ResponseEntity<Trainee> deleteEmployee( @PathVariable("traineeId") int id)
	{
		Boolean result = service.delete(id);
		if(result==false)
		{
			ResponseEntity<Trainee> response = new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
			return response;
		}
		ResponseEntity<Trainee>response=new ResponseEntity<>(HttpStatus.OK);
	    return response;
	}
	
	/*-----------------------Update Trainee-----------------*/
	@PutMapping("/update/{traineeId}")
	public ResponseEntity<Trainee> updateEmployee(@RequestBody TraineeDTO dto , @PathVariable("traineeId") int id)
	{
		Trainee trainee = convertFromDto(dto);
		trainee.setTraineeId(dto.getTraineeId());
		Trainee t1 = service.modify(trainee);
		ResponseEntity<Trainee> response = new ResponseEntity<>(t1,HttpStatus.OK);
		return response;
	}
	
	 @ExceptionHandler(TraineeNotFoundException.class)
	    public ResponseEntity<String>handleCustomerNotFound(TraineeNotFoundException ex){
	     // Log.error("handleCustomerNotFound()",ex);
	      String msg=ex.getMessage();
	      ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	      return response;
	    }

	   /* @ExceptionHandler(Throwable.class)
	    public ResponseEntity<String>handleAll(Throwable ex){
	       //Log.error("handleAll()",ex);
	       String msg=ex.getMessage();
	       ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	       return response;
	    }
*/
	    

}
