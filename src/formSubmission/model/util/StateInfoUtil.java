package formSubmission.model.util;

import java.util.ArrayList;
import java.util.List;

import formSubmission.beans.CityBean;
import formSubmission.model.StateInfo;

public class StateInfoUtil {
	
	public static List<StateInfo> getNearbyStates() {
		List<StateInfo> list = new ArrayList<StateInfo>();
		
		CityBean bregenz = new CityBean();
		bregenz.setName("Bregenz");
		bregenz.setPopulation(28203);
		bregenz.setAreaCode(05574);
		bregenz.setZipCode(6900);
		
		CityBean feldkirch = new CityBean();
		feldkirch.setName("Feldkirch");
		feldkirch.setPopulation(31269);
		feldkirch.setAreaCode(05522);
		feldkirch.setZipCode(6800);

		list.add(new StateInfo("Voralberg", bregenz, feldkirch));
		return list;
	}
}
