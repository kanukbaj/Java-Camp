package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="SystemUsers")
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
	
	@Id
	@Column(name="UserId")
	private int userId;
	
	public SystemUser(int userId, String roles) {
		super();
		this.userId = userId;
		this.roles = roles;
	}

	@Column(name="Roles")
	private String roles;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
