package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	
	@Id
	@Column(name="UserId")
	private int userId;
	
	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="VerifiedBySystem")
	private boolean verifiedBySystem;
	
	@Column(name="Website")
	private String website;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UserId")
	private User user;
	
	public Employer(int userId, String companyName, String phone, boolean verifiedBySystem, String website) {
		this.userId = userId;
		this.companyName = companyName;
		this.phone = phone;
		this.verifiedBySystem = verifiedBySystem;
		this.website = website;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isVerifiedBySystem() {
		return verifiedBySystem;
	}

	public void setVerifiedBySystem(boolean verifiedBySystem) {
		this.verifiedBySystem = verifiedBySystem;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
