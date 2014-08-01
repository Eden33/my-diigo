package formSubmission.model;

import java.io.Serializable;

import formSubmission.beans.CityBean;

public class StateInfo implements Serializable {

	private static final long serialVersionUID = -5643903683317352451L;
	
	private String stateName;
	private CityBean[] cities;
	
	public StateInfo(String stateName, CityBean ... cities) {
		this.stateName = stateName;
		this.cities = cities;
	}
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public CityBean[] getCities() {
		return cities;
	}

	public void setCities(CityBean[] cities) {
		this.cities = cities;
	}
}
