package com.coronavirus.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Country {
	private String name;
	private int confirmed;
	private int deads;
	private int recovereds;
	private ArrayList<Province> provinces;
	public Country(String name) {
		this.name = name;
		this.confirmed = 0;
		this.deads = 0;
		this.recovereds = 0;
		this.provinces = new ArrayList<Province>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void addProvice(Province province) {
		provinces.add(province);
		this.recovereds+=province.getRecovereds();
		this.deads+=province.getDeads();
		this.confirmed+=province.getDeads();
	}
	public ArrayList<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(ArrayList<Province> provinces) {
		this.provinces = provinces;
	}
	
	

}
