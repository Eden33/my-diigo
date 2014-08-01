package diigo.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{
	

	private static final long serialVersionUID = 2731251914126292569L;
	
	private String login = "dummyUser";
	private String password = "";
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
