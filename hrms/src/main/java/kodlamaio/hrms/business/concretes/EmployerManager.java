package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.dtos.EmployerForRegisterDto;

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
		
		if(runAllRegisterRules(employer) != null) return runAllRegisterRules(employer);
		User userToRegister = new User(employer.getEmail(), employer.getPassword(),false, UUID.randomUUID().toString());
		userService.add(userToRegister);
		Employer employerToRegister = new Employer(userToRegister.getId(), employer.getCompanyName(), employer.getPhone(), false, employer.getWebsite());
		this.employerDao.save(employerToRegister);
		return new SuccessResult("İş veren başarıyla kayıt oldu. Lütfen e-posta adresinize gönderilen linke tıklayarak üyeliğinizi doğrulayın.");
	}
	
	private Result runAllRegisterRules(EmployerForRegisterDto employer) {
		if(isAllFieldsFilled(employer) != null) return isAllFieldsFilled(employer);
		if(isPasswordsSame(employer) != null) return isPasswordsSame(employer);
		if(isEmailandWebsiteDomainSame(employer) != null) return isEmailandWebsiteDomainSame(employer);
		if(isEmailAlreadyInUse(employer) != null) return isEmailAlreadyInUse(employer);
		return null;
	}

	private Result isEmailAlreadyInUse(EmployerForRegisterDto employer) {
		if(userService.getByEmail(employer.getEmail()).getData() != null) return new ErrorResult("Bu e-posta adresiyle kayıtlı bir kullanıcı var");
		return null;
	}

	private Result isEmailandWebsiteDomainSame(EmployerForRegisterDto employer) {
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(employer.getWebsite())) return new ErrorResult("E-posta adresinizin domaini web siteniz ile aynı olamlıdır.");
		return null;
	}

	private Result isPasswordsSame(EmployerForRegisterDto employer) {
		if(!employer.getPassword().equals(employer.getVerifyPassword())) return new ErrorResult("Şifreleriniz uyuşmuyor.");
		return null;
	}

	private Result isAllFieldsFilled(EmployerForRegisterDto employer) {
		if(employer.getCompanyName() == null || employer.getPhone() ==null|| employer.getWebsite() == null || employer.getEmail() == null ||
					employer.getPassword() == null || employer.getVerifyPassword() == null) 
	return new ErrorResult("Hiç bir alan boş bırakılmamalıdır.");
	
	if(employer.getCompanyName().equals("") || employer.getPhone().equals("") || employer.getWebsite().equals("") ||
		employer.getEmail().equals("") || employer.getPassword().equals("") || employer.getVerifyPassword().equals("")) 
	return new ErrorResult("Hiç bir alan boş bırakılmamalıdır.");
		return null;
	}
	

}