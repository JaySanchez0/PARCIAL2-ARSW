package com.coronavirus.modelo;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
@Component
public class CountriesData {
	private ArrayList<Country> countries;
	private int confirmed;
	private int deads;
	private int recovereds;
	public CountriesData() {
		countries=new ArrayList<Country>();
		confirmed=0;
		recovereds=0;
	}
	public ArrayList<Country> getCountries() {
		return countries;
	}
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getDeads() {
		return deads;
	}
	public void setDeads(int deads) {
		this.deads = deads;
	}
	public int getRecovereds() {
		return recovereds;
	}
	public void setRecovereds(int recovereds) {
		this.recovereds = recovereds;
	}
	
	public void addCountry(Country country) {
		this.confirmed += country.getConfirmed();
	}
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
	public Country getCountry(String name) {
		for(Country c: countries) {
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
}
