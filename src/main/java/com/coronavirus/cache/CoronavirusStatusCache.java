package com.coronavirus.cache;

import org.springframework.stereotype.Component;

import com.coronavirus.modelo.CountriesData;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class CoronavirusStatusCache {
	Container data = null;
	public boolean isCacheCountriesData() {
		return data!=null && data.isValid();
	}
	public void saveCountries(CountriesData countries) {
		data = new Container(System.currentTimeMillis(),countries);
	}
	public CountriesData getCountiesData() {
		return data.getCountriesData();
	}
}
