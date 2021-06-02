package kodlamaio.hrms.business.concretes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.IdentityValidationService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dto.EmployeeForRegisterDto;

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
		Result businessResult = BusinessRules.run(
				isPasswordMatch(employee.getPassword(),employee.getVerifyPassword()),
				isUserExistWithEmail(employee.getEmail()),
				isUserExistWithNationalityId(employee.getNationalityId())
				);
		if(businessResult != null) return businessResult;
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(employee.getDateOfBirth());
				
		if(!identityValidationService.validate(employee.getNationalityId(),
				employee.getFirstName(),
				employee.getLastName(),
				calendar.get(Calendar.YEAR)).isSuccess()) {
					return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
				}
		User userToReister = new User(employee.getEmail(), employee.getPassword(), false, UUID.randomUUID().toString());
		userService.add(userToReister);
		
		Employee employeeToRegister = new Employee(userToReister.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getNationalityId(),
				employee.getDateOfBirth());
		this.employeeDao.save(employeeToRegister);
		return new SuccessResult("İş arayan kaydı başarılı. Lütfen e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayınız.");
	}
	

	private Result isPasswordMatch(String password, String passwordVerify) {
		if(! password.equals(passwordVerify)) {
			return new ErrorResult("Şifreler uyuşmalıdır.");
		}
		return new SuccessResult();
	}
	
	private Result isUserExistWithEmail(String email) {
		if(userService.getByEmail(email).getData() != null)
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");	
	return new SuccessResult();
	}
	
	private Result isUserExistWithNationalityId(String nationalityId) {
		if(employeeDao.findByNationalityId(nationalityId) != null)
				return new ErrorResult("Bu TCKN ile başka bir kullanıcı mevcut");
		return new SuccessResult();
		}

	
}
