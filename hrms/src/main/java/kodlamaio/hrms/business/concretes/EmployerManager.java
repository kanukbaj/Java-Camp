package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dto.EmployerForRegisterDto;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result register(EmployerForRegisterDto employer) {
		
		Result businessResults = BusinessRules.run(
				isPasswordsSame(employer.getPassword(), employer.getVerifyPassword()),
				isEmailandWebsiteDomainSame(employer.getEmail(),employer.getWebsite()),
				isEmailAlreadyInUse(employer.getEmail())
				);
				
		if(businessResults != null) return businessResults;		
		
		//Maybe add AUTOMAPPER?
		User userToRegister = new User(employer.getEmail(), employer.getPassword(), false, UUID.randomUUID().toString());
		userService.add(userToRegister);
		
		Employer employerToRegister = new Employer(userToRegister.getId(),employer.getCompanyName(),employer.getPhone(), false, employer.getWebsite());
		this.employerDao.save(employerToRegister);
		
		return new SuccessResult("???? veren ba??ar??yla kay??t oldu. L??tfen e-posta adresinize g??nderilen linke t??klayarak ??yli??inizi do??rulay??n.");
	}
	
	@Override
	public DataResult<Employer> getById(int id) {
		Employer employer = employerDao.getOne(id);
		if(employer==null) return new ErrorDataResult<Employer>();
		
		return new SuccessDataResult<Employer>(employer);
	}
	
	private Result isPasswordsSame(String password, String passwordConfirm) {
		if(!password.equals(passwordConfirm)) return new ErrorResult("??ifreleriniz uyu??muyor.");
		return null;
	}
	
	private Result isEmailandWebsiteDomainSame(String email, String website) {
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(website)) return new ErrorResult("E-posta adresinizin domaini web siteniz ile ayn?? olamal??d??r.");
return null;
	}
	
	
	private Result isEmailAlreadyInUse(String email) {
		if(userService.getByEmail(email).getData() != null) return new ErrorResult("Bu e-posta adresiyle kay??tl?? bir kullan??c?? var");
		return null;
	}
	

}
