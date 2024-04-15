package in.kawshik.dto;

public class ResetPwdDto {
	
	
	private String email;
	
	
	private String oldPwd;
	
	private String newPwd;
	
	
	private String conPwd;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getOldPwd() {
		return oldPwd;
	}


	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}


	public String getNewPwd() {
		return newPwd;
	}


	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	public String getConPwd() {
		return conPwd;
	}


	public void setConPwd(String conPwd) {
		this.conPwd = conPwd;
	}
	
	
	

}
