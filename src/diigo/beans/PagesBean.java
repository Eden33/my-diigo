package diigo.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
@ApplicationScoped
public class PagesBean {
	public static final String LOGIN_PAGE = "/login.xhtml";
	private static final String MAIN_PAGE = "/secured/main.jsf";
	
	public static String toLoginPage(boolean redirect) {
		String retVal = LOGIN_PAGE + (redirect == true ? "?faces-redirect=true" : "");
		return retVal;
	}
	public static String toMainPage(boolean redirect) {
		String retVal = MAIN_PAGE + (redirect == true ? "?faces-redirect=true" : "");	
		return retVal;
	}
}
