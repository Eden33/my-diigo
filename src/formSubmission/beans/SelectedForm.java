package formSubmission.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class SelectedForm implements Serializable{
	
	private static final long serialVersionUID = -8706657052365445834L;
	
	private static String SELECT_INIT_VAL = "";
	private static String SELECT_RESET_FORM = "Form with Reset functionality";
	private static String SELECT_SIMPLE_RANDOM_AJAX = "Simple Random Ajax";
	private static String SELECT_CITY_INFO_AJAX = "City Info Ajax";
	private static String SELECT_AJAX_LOADING_GIF = "Ajax Loading gif";
	private static String SELECT_MANUAL_VALIDATION = "Form with action controller validation";
	
	private String selected = SELECT_INIT_VAL;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getDefaultItem() {
		return SELECT_INIT_VAL;
	}

	public String getResetFormItem() {
		return SELECT_RESET_FORM;
	}
	
	public String getSimpleRandomAjaxFormItem() {
		return SELECT_SIMPLE_RANDOM_AJAX;
	}
	
	public String getCityInfoAjaxFormItem() {
		return SELECT_CITY_INFO_AJAX;
	}
	
	public String getAjaxLoadingGifFormItem() {
		return SELECT_AJAX_LOADING_GIF;
	}
	
	public String getManualValidationFormItem() {
		return SELECT_MANUAL_VALIDATION;
	}
	
	public void valueChangedListener(ValueChangeEvent e) {
		selected = (String) e.getNewValue();
	}
}
