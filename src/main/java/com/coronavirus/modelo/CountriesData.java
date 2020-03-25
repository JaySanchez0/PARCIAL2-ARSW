package com.coronavirus.modelo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;
@Component
public class CountriesData {
	private CopyOnWriteArrayList<Country> countries;
	private int confirmed;
	private int deads;
	private int recovereds;
	/**
	 * Coleccion de paises
	 */
	public CountriesData() {
		countries=new CopyOnWriteArrayList<Country>();
		confirmed=0;
		recovereds=0;
		deads=0;
	}
	/**
	 * 
	 * @return todos los paises donde esta la enfermedada
	 */
	public CopyOnWriteArrayList<Country> getCountries() {
		return countries;
	}
	/**
	 * 
	 * @param countries todos los paises en que esta presente la enfermedad
	 */
	public void setCountries(CopyOnWriteArrayList<Country> countries) {
		this.countries = countries;
	}
	/**
	 * 
	 * @return numero de personas confirmadas en todos los paises
	 */
	public int getConfirmed() {
		return confirmed;
	}
	/**
	 * 
	 * @param confirmed nuevo numero de personas confirmadas de la enfermedad
	 */
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	/**
	 * 
	 * @return numero de personas en todos los paises que han muerto a causa de la enfermedad
	 */
	public int getDeads() {
		return deads;
	}
	/**
	 * 
	 * @param deads nuevo numero de personas que han muerto en todos los paises
	 */
	public void setDeads(int deads) {
		this.deads = deads;
	}
	/**
	 * 
	 * @return numero de personas que se han recuperado de la enfermedad
	 */
	public int getRecovereds() {
		return recovereds;
	}
	/**
	 * 
	 * @param recovereds nuevo numero de personas que se han recuperado en todos los paises
	 */
	public void setRecovereds(int recovereds) {
		this.recovereds = recovereds;
	} 
	/**
	 * 
	 * @param country pais al que se le va a añadir la provincia
	 * @param province provincia a añadir
	 */
	public void addProvince(String country,Province province) {
		Country con = getCountry(country);
		if(con==null) {
			con = new Country(country);
			countries.add(con);
		}
		con.addProvice(province);
		this.confirmed+=province.getConfirmed();
		this.deads+=province.getDeads();
		this.recovereds+=province.getRecovereds();
	}
	/**
	 * 
	 * @param name nombre del pais
	 * @return pais solicitado
	 */
	public Country getCountry(String name) {
		for(Country c: countries) {
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
}
