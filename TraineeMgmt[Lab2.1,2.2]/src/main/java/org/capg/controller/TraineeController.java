package org.capg.controller;


import java.util.List;

import org.capg.entities.User;
import org.capg.entities.Trainee;
import org.capg.service.ITraineeService;
import org.capg.session.SessionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TraineeController {
	
	
	@Autowired
	private ITraineeService service;
	
	@Autowired
	private User user;
	
	@Autowired
	private SessionDetails sessionDetails;
	
	  //Login-Page
  	@GetMapping("/signin")
  	public ModelAndView login()
  	{
  		return new ModelAndView("login");
  	}
	
 
	/*HomePage
	@GetMapping("/home")
	public ModelAndView operations()
	{
		ModelAndView mv = new ModelAndView("homepage");
		return mv;
	}*/
	
	 //for validating log-in credentials.
    public boolean credentialsCorrect(int id, String password) {
        boolean flag=false;
    	if (password == null || password.isEmpty()) {
            return false;
        }
        if(id==user.getId()&&password.equals(user.getPassword())) {
        	flag= true;
        }
    return flag;
    }
    
    @GetMapping("/processlogin")
    public ModelAndView login(@RequestParam("id")int id , @RequestParam("password") String password){
        boolean correct=credentialsCorrect(id,password);
        if(!correct){
         return new ModelAndView("/login");
        }
        //sessionDetails.setId(id);
        sessionDetails.setId(id);
	   // User user= service.findId(id);
        ModelAndView modelAndView= new ModelAndView("homepage");
        return modelAndView;
    }

	
	//Add Trainee
	@GetMapping("/registertrainee")
	public ModelAndView addTrainee() {
		int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
	    ModelAndView mv=new ModelAndView("addtrainee");
	    return mv;
    }
	
	@GetMapping("/processtrainee")
    public ModelAndView processTrainee(@RequestParam("traineeid")int id,
                                        @RequestParam("traineename") String traineename,
                                        @RequestParam("traineelocation") String location,
                                        @RequestParam("domain")String domain){
	    System.out.println("id="+id +" name="+traineename+" loc="+location+" domain="+domain);
        Trainee trainee=new Trainee();
        trainee.setTraineeId(id);
        trainee.setTraineeName(traineename);
        trainee.setTraineeLocation(location);
        trainee.setTraineeDomain(domain);
        service.add(trainee);
        ModelAndView mv=new ModelAndView("details","trainee",trainee);
        return mv;
    }
	
	//Retrieve 1 trainee info
		@GetMapping("/retrievet")
		public ModelAndView retrieveTrainee()
		{
			int id=sessionDetails.getId();
	        if(id==-1){
	         return new ModelAndView("/login");
	        }
			ModelAndView mv = new ModelAndView("retreivetrainee");
			return mv;
		}

		@GetMapping("/processretrieve")
		public ModelAndView retrieveProcess(@RequestParam("traineeId") int id)
		{
			 System.out.println("id="+id);
			Trainee trainee = service.findById(id);
			ModelAndView mv=new ModelAndView("RetrieveTraineeInfo","trainee",trainee);
		    return mv;

		}
		
	//Retrieve All trainee  info 
		@GetMapping("/retreivealltrainee")
		public ModelAndView retrieveAllTrainee()
		{
			int id=sessionDetails.getId();
	        if(id==-1){
	         return new ModelAndView("/login");
	        }
			List<Trainee> store = service.retreiveAll();
			ModelAndView mv=new ModelAndView("fetchalltrainee","fetch",store);
			return mv;
		}
		
	//Delete trainee
		@GetMapping("/deletetrainee")
		public ModelAndView deleteTrainee()
		{
			int id=sessionDetails.getId();
	        if(id==-1){
	         return new ModelAndView("/login");
	        }
			ModelAndView mv = new ModelAndView("deletetrainee");
			return mv;
		}

		@GetMapping("/processdelete")
		public ModelAndView deleteProcess(@RequestParam("traineeId") int id)
		{
			System.out.println("id= "+ id);
			service.delete(id);
			ModelAndView mv = new ModelAndView("deletetraineeinfo");
			return mv;
		}
		
	//Modify Trainee
		@GetMapping("/modifytrainee")
		public ModelAndView modifyTrainee()
		{
			int id=sessionDetails.getId();
	        if(id==-1){
	         return new ModelAndView("/login");
	        }
			ModelAndView mv = new ModelAndView("updatetrainee");
			return mv;
		}
		
		@GetMapping("/updatetrainee")
		public ModelAndView updateTrainee()
		{
			ModelAndView mv = new ModelAndView("updatedtraineeinfo");
			return mv;
		}
		
		
		@GetMapping("/processmodify")
		public ModelAndView modifyProcess(@RequestParam("traineeId")int id,@RequestParam("traineename")String traineename,
                @RequestParam("traineelocation") String location,
                @RequestParam("traineedomain")String domain)
		{
			Trainee trainee=new Trainee();
	        trainee.setTraineeId(id);
	        trainee.setTraineeName(traineename);
	        trainee.setTraineeLocation(location);
	        trainee.setTraineeDomain(domain);
	        service.modify(trainee);
	        ModelAndView mv=new ModelAndView("details","trainee",trainee);
	        return mv;
		}
}
