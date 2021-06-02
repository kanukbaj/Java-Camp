package kodlamaio.hrms.core.utilities.mail;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String message);

}
