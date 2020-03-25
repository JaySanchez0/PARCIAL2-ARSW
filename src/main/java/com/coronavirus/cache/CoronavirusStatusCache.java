package com.coronavirus.cache;

import org.springframework.stereotype.Component;

import com.coronavirus.modelo.CountriesData;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class CoronavirusStatusCache {
	Container data = null;
	/**
	 * 
	 * @return verifica si el dato esta en cache
	 */
	public boolean isCacheCountriesData() {
		return data!=null && data.isValid();
	}
	/**
	 * 
	 * @param countries guarda de nuevo la coleccion de paises
	 */
	public void saveCountries(CountriesData countries) {
		data = new Container(System.currentTimeMillis(),countries);
	}
	/**
	 * 
	 * @return devuelve los datos en memoria de los paises
	 */
	public CountriesData getCountiesData() {
		return data.getCountriesData();
	}
}
