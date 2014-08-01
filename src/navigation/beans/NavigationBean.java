package navigation.beans;

import java.io.Serializable;

/**
 * Defined explicitly in faces-config.xml
 * Is used for Navigation demo.
 * A demo web application for explicit declaration of beans and navigation rules.
 * 
 * @author edi
 */
public class NavigationBean implements Serializable {
	
	private static final long serialVersionUID = -3301444031829251810L;
	
	private MessageBean messageBean;
	
	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}

	public String doNavigation() {
		int msgLength = messageBean.getMessage().length();
		if(msgLength > 10 || msgLength <= 1) {
			return "navigation-error";
		}
		if(msgLength == 3) {
			return null;
		}
		return "navigation-page-2";
	}
}
