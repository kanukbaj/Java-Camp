package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dto.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private CityService cityService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerService employerService,
			JobPositionService jobPositionService, CityService cityService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
	}

		
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueOrderByCreateDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_EmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueAndEmployer_UserId(employerId));
	}

	@Override
	public Result addNew(JobAdvertisementForAddDto jobAdvertisement) {
		Result businessRulesResult = BusinessRules.run(
				isJobPositionValid(jobAdvertisement.getJobPositionId()),
				isJobDescValid(jobAdvertisement.getJobDescription()),
				isCityValid(jobAdvertisement.getCityId()),
				isOpenPositionValid(jobAdvertisement.getOpenPositionCount()),
				isEndDateValid(jobAdvertisement.getLastAppllyDate())
				);
		
		if(businessRulesResult != null) return businessRulesResult;
		
		//Asl??nda buras?? authentication dn gelecek fakat ??u an ????renemedik, o y??zden el ile istiyoruz :)
		
		if(!employerService.getById(jobAdvertisement.getEmployerId()).isSuccess()) {
			return new ErrorResult("B??yle bir i?? veren firma yok.");
		}
		
		
		//Automapper entegrasyonu ile ??ok daha clean hale getirilebilir.
		
		JobAdvertisement jobAdvertisementToAdd = new JobAdvertisement(jobAdvertisement.getJobDescription(),
				jobAdvertisement.getMinSalary(),
				jobAdvertisement.getMaxSalary(),
				jobAdvertisement.getOpenPositionCount(),
				jobAdvertisement.getLastAppllyDate(),
				new Date(),
				jobAdvertisement.isActive());
		jobAdvertisementToAdd.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
		jobAdvertisementToAdd.setJobPosition(jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
		jobAdvertisementToAdd.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());
		jobAdvertisementDao.save(jobAdvertisementToAdd);
		
		return new SuccessResult("???? ilan?? ba??ar?? ile olu??turuldu.");
	}
	

	@Override
	public Result changeStatus(int advertisementId, int employerId) {
		JobAdvertisement jobAdvertisementToUpdate = jobAdvertisementDao.findByIdAndEmployer_UserId(advertisementId, employerId);
		if(jobAdvertisementToUpdate == null) return new ErrorResult("Bu kriterlere uyan bir i?? ilan?? bulunamad??. B??yle bir i?? ilan?? yok veya bu i?? ilan?? bu ??irkete ait de??il.");
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessResult("Belirtilen i?? ilan??" + (jobAdvertisementToUpdate.isActive() ? "aktif" : "pasif") + "hale getirildi.");
		
	}
	
	private Result isJobPositionValid(int id) {
		if(id<=0) return new ErrorResult("i?? pozisyonu do??ru girilmedi.");
		if(jobPositionService.getById(id).getData() == null) return new ErrorResult("B??yle bir i?? pozisyonu yok.");
		return new SuccessResult();
	}
	
	private Result isJobDescValid(String jobDesc) {
		if(jobDesc == null ||jobDesc.equals("")) return new ErrorResult("???? a????klamas?? do??ru girilmedi.");
		return new SuccessResult();
	}
	
	private Result isCityValid(int id) {
		if(id<=0) return new ErrorResult("??ehir do??ru girilmedi.");
		if(cityService.getById(id).getData() == null) return new ErrorResult("B??yle bir ??ehir yok.");
		return new SuccessResult();
	}
		
	private Result isOpenPositionValid(int count) {
		if(count<=0) return new ErrorResult("A????k i?? pozisyonu 0 ve 0'dan k??????k olamaz.");
		return new SuccessResult();
	}
	
	private Result isEndDateValid(Date endDate) {
		if(new Date().compareTo(endDate)>0) {
			return new ErrorResult("Son ba??vuru tarihi i?? ilan?? tarihinden ??nce olamaz.");
		}
		return new SuccessResult();
	}

}
