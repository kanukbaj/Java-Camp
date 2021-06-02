package kodlamaio.hrms.entities.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	
	@NotBlank
	@NotNull
	private String companyName;
	
	@NotBlank
	@NotNull
	private String phone;
	
	@NotBlank
	@NotNull
	private String website;
	
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String verifyPassword;
		

}
