package formSubmission.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import formSubmission.model.StateInfo;
import formSubmission.model.util.StateInfoUtil;

@ManagedBean
@ViewScoped
public class LocationBean implements Serializable{

	private static final long serialVersionUID = -7551872184429960140L;
	private static final String SELECT_A_STATE = "--- Select a state ---";
	private static final String SELECT_A_CITY = "--- Select a city ---";
	
	private String state = SELECT_A_STATE;
	private List<String> states = new ArrayList<String>();
	
	@ManagedProperty(value="#{cityBean}")
	private CityBean city;
	
	private List<String> cities = new ArrayList<String>();
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		if(state.equals(SELECT_A_STATE)) {
			clearCity();
		}
	}
	public List<String> getStates() {
		List<StateInfo> s = new ArrayList<StateInfo>(StateInfoUtil.getNearbyStates());
		states.clear();
		states.add(SELECT_A_STATE);
		for (StateInfo stateInfo : s) {
			states.add(stateInfo.getStateName());
		}
		return states;
	}
	
	public CityBean getCity() {
		return city;
	}
	public void setCity(CityBean city) {
		this.city = city;
	}
	public void setCityName(String cityName) {
		
		List<StateInfo> s = new ArrayList<StateInfo>(StateInfoUtil.getNearbyStates());
		for(StateInfo stateInfo : s) {
			if(stateInfo.getStateName().equals(this.state)) {
				CityBean[] cities = stateInfo.getCities();
				for (CityBean cityBean : cities) {
					if(cityBean.getName().equals(cityName)) {
						this.city.setName(cityName);
						this.city.setAreaCode(cityBean.getAreaCode());
						this.city.setPopulation(cityBean.getPopulation());
						this.city.setZipCode(cityBean.getZipCode());
					}
				}
			}
		}
	}
	public String getCityName() {
		return this.city.getName();
	}

	public List<String> getCities() {
		cities.clear();
		cities.add(SELECT_A_CITY);
		
		List<StateInfo> s = new ArrayList<StateInfo>(StateInfoUtil.getNearbyStates());
		for(StateInfo stateInfo : s) {
			if(stateInfo.getStateName().equals(this.state)) {
				CityBean[] cities = stateInfo.getCities();
				for (CityBean cityBean : cities) {
					this.cities.add(cityBean.getName());
				}
			}
		}

		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public boolean isCityListDisabled() {
		if(this.state.equals(SELECT_A_STATE))
			return true;
		return false;
	}
	private void clearCity() {
		this.city.setName("");
		this.city.setPopulation(0);
		this.city.setAreaCode(0);
		this.city.setZipCode(0);
	}
	
}
