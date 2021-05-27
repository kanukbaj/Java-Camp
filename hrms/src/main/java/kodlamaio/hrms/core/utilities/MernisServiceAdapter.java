package kodlamaio.hrms.core.utilities;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements IdentityValidationService{

	@Override
	public Result validate(String tckn, String firstName, String lastName, int yearOfDate) {
		
		return new SuccessResult("TCKN doğrulaması başarılı.");
	}
	
	
}
