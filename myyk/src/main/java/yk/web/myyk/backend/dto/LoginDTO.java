package yk.web.myyk.backend.dto;

public class LoginDTO {

	private String localPartEmail;
	private String domainPartEmail;
	private String password;
	private boolean autoLoginCheck;
	
	@Deprecated
	public LoginDTO() {
		// 하이버네이트용
	}
	
	public String getLocalPartEmail() {
		return localPartEmail;
	}
	
	public void setLocalPartEmail(String localPartEmail) {
		this.localPartEmail = localPartEmail;
	}
	
	public String getDomainPartEmail() {
		return domainPartEmail;
	}
	
	public String getEmail() {
		return getLocalPartEmail() + "@" + getDomainPartEmail();
	}
	
	public void setDomainPartEmail(String domainPartEmail) {
		this.domainPartEmail = domainPartEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAutoLoginCheck() {
		return autoLoginCheck;
	}
	
	public void setAutoLoginCheck(boolean autoLoginCheck) {
		this.autoLoginCheck = autoLoginCheck;
	}
}
