package com.coronavirus.cache;

import com.coronavirus.modelo.CountriesData;

public class Container {
	private long time;
	private CountriesData data;
	public Container(long time,CountriesData data) {
		this.time = time;
		this.data = data;
	}
	public boolean isValid() {
		return System.currentTimeMillis()-time<=1000*60*5;
	}
	public CountriesData getCountriesData() {
		// TODO Auto-generated method stub
		return data;
	}
}
