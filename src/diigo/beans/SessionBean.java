package diigo.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 3595333506648077518L;
	
	private boolean loggedIn = false;
	
	@ManagedProperty(value="#{userBean}")
	private UserBean user = null;
	
	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getLogin() {
		return user.getLogin();
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public String login() {
		if(user.getLogin().equals("dummyUser") && user.getPassword().equals("")) {
			loggedIn = true;
			return PagesBean.toMainPage(true);
		}
		
		loggedIn = false;
		return PagesBean.toLoginPage(true);
	}
	public String logout() {
		loggedIn = false;
		user.setLogin("");
		user.setPassword("");
		return PagesBean.toLoginPage(true);
	}
}
