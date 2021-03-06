package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dto.JobAdvertisementForAddDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getAllActive(){
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/getAllActiveOrderByDate")
	public DataResult<List<JobAdvertisement>> getAllActiveOrdeDate(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderByCreateDate();
	}
	
	@GetMapping("/getAllActiveByEmployer")
	public DataResult<List<JobAdvertisement>> getAllActiveOrderDate(int employerId){
		return this.jobAdvertisementService.findByEmployer_EmployerId(employerId);
	}
	
	@GetMapping("/changestatus")
	public Result changeStatus(int jobadvertisementId, int employerId) {
		return this.jobAdvertisementService.changeStatus(jobadvertisementId, employerId);
	}
	
	@GetMapping("/add")
	public Result addNew(@RequestBody JobAdvertisementForAddDto jobAdvertisement) {
		return this.jobAdvertisementService.addNew(jobAdvertisement);
	}

}
