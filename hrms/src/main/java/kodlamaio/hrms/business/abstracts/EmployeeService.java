package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.dtos.EmployeeForRegisterDto;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result register(EmployeeForRegisterDto employee);

}
