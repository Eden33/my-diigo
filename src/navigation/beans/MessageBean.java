package navigation.beans;

import java.io.Serializable;

/**
 * Defined explicitly in faces-config.xml
 * Is used for Navigation demo.
 * A demo web application for explicit declaration of beans and navigation rules.
 * 
 * @author edi
 */
public class MessageBean implements Serializable {

	private static final long serialVersionUID = -6764298572575426022L;
	
	private String message;
	private boolean cleanMessage = false;

	public String getMessage() {
		if(cleanMessage) {
			message = "";
			cleanMessage = false;
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageAndClean() {
		cleanMessage = true;
		return message;
	}
}
