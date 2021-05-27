package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.IdentityValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.dtos.EmployeeForRegisterDto;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	private UserService userService;
	private IdentityValidationService identityValidationService;
	
	@Autowired
	public  EmployeeManager(EmployeeDao employeeDao, UserService userService, IdentityValidationService identityValidationService) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.identityValidationService = identityValidationService;
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}

	@Override
	public Result register(EmployeeForRegisterDto employee) {
		if(runAllRules(employee) != null) return runAllRules(employee);
		
		if(!identityValidationService.validate(employee.getNationalityId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getDateOfBirth().getYear()).isSuccess()) {
					return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
				}
		User userToReister = new User(employee.getEmail(), employee.getPassword(), false, UUID.randomUUID().toString());
		userService.add(userToReister);
		Employee employeeToEmployee = new Employee(userToReister.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getNationalityId(),
				employee.getDateOfBirth());
		this.employeeDao.save(employeeToRegister);
		return new SuccessResult("İş arayan kaydı başarılı. Lütfen e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayınız.");
	}

	private Result runAllRules(EmployeeForRegisterDto employee) {
		if(isAllFieldsFilled(employee) != null) return isAllFieldsFilled(employee);
		if(isPasswordMatch(employee) != null) return isPasswordMatch(employee);
		if(isUserExistWithEmail(employee) != null) return isUserExistWithEmail(employee);
		if(isUserExistWithNationalityId(employee) != null) return isUserExistWithNationalityId(employee);
		
		return null;
	}
	
	private Result isAllFieldsFilled(EmployeeForRegisterDto employee) {
		if( employee.getVerifyPassword() == null || employee.getVerifyPassword().equals("")
		 || employee.getPassword() == null || employee.getPassword().equals("")
		 || employee.getEmail() == null || employee.getEmail().equals("")
		 || employee.getNationalityId() == null || employee.getNationalityId().equals("")
		 || employee.getLastName() == null || employee.getLastName().equals("")
		 || employee.getFirstName() == null || employee.getFirstName().equals("")
		 || employee.getDateOfBirth() == null)
			return new ErrorResult("Tüm alanları doldurmalısınız.");
		return null;
	}


	private Result isPasswordMatch(EmployeeForRegisterDto employee) {
		if(! employee.getPassword().equals(employee.getVerifyPassword())) {
			return new ErrorResult("Şifreler uyuşmalıdır.");
		}
		return null;
	}
	
	private Result isUserExistWithEmail(EmployeeForRegisterDto employee) {
		if(userService.getByEmail(employee.getEmail()).getData() != null)
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");	
	return null;
	}

	private Result isUserExistWithNationalityId(EmployeeForRegisterDto employee) {
		if(employeeDao.findByNationalityId(employee.getNationalityId()) != null);
			return new ErrorResult("Bu TCKN ile başka bir kullanıcı mevcut.");
		return null;
	}

	

}
