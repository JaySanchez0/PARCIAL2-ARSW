package com.coronavirus.cache;

import com.coronavirus.modelo.CountriesData;

public class Container {
	private long time;
	private CountriesData data;
	/**
	 * 
	 * @param time tiempo de validez del cache
	 * @param data la coleccion de paises
	 */
	public Container(long time,CountriesData data) {
		this.time = time;
		this.data = data;
	}
	/**
	 * 
	 * @return valida si el cache tiene un estado valido
	 */
	public boolean isValid() {
		return System.currentTimeMillis()-time<=1000*60*5;
	}
	/**
	 * 
	 * @return obtiene los datos de los paises de memoria
	 */
	public CountriesData getCountriesData() {
		// TODO Auto-generated method stub
		return data;
	}
}
