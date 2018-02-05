package com.sscm.service.impl;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.sscm.entity.BarInfo;
import com.sscm.service.DataService;
@Service("dataService")
public class DataServiceImpl implements DataService {

	@Override
	public BarInfo getBar(String name) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		boolean term = false;
		if (month==3&&day<20){
			term = true;
			year = year - 1;
		} else if (month==10&&day>10) {
			term = true;
		} else {
			term = month < 3 || month > 10;
			year = term?year-1:year;
		}
		return new BarInfo(name, year, term);
	}

}
