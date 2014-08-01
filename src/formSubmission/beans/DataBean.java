package formSubmission.beans;

import java.io.Serializable;
import java.util.Random;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="dataB")
@SessionScoped
public class DataBean implements Serializable{
	
	private static final long serialVersionUID = 7180265082017946359L;
	
	private float floatValue;
	private String randomStringValue = "Random ";
	
	private String actionControlValidationValue;
	private boolean actionControlValidationSuccess = false;
	
	public boolean isActionControlValidationSuccess() {
		return actionControlValidationSuccess;
	}
	public String getRandomStringValue() {
		Random rand = new Random();
		String randStr = randomStringValue + rand.nextInt(100);
		return randStr;
	}

	public float getFloatValue() {
		return floatValue;
	}
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}
	
	
	public String getActionControllerValidationValue() {
		return actionControlValidationValue;
	}

	public void setActionControllerValidationValue(String value) {
		this.actionControlValidationValue = value;
	}

	public void reset(ActionEvent e) {
		floatValue = 0.0f;
		
		//Next lines are needed because the UpdateModel-Phase is not executed and the form components 
		//remember their submitted values.
		
		//https://cwiki.apache.org/confluence/display/MYFACES/Clear+Input+Components
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
		  
	}
	
	public String submit() {
		return null;
	}
	public String submitSlow() {
		try {
			Thread.sleep(5000);	
		} catch(InterruptedException e) {}
		return null;
	}
	public String submitActionControllerValidation() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Integer.parseInt(this.actionControlValidationValue);
			actionControlValidationSuccess = true;
		} catch(NumberFormatException e) {
			context.addMessage("inputTextInteger", new FacesMessage("This is not an Integer."));
			actionControlValidationSuccess = false;
		}
		return null;
	}
}
