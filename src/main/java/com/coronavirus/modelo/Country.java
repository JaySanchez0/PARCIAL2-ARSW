package com.coronavirus.modelo;

import java.util.concurrent.CopyOnWriteArrayList;

public class Country {
	private String name;
	private int confirmed;
	private int deads;
	private int recovereds;
	private CopyOnWriteArrayList<Province> provinces;
	/**
	 * 
	 * @param name - Nombre del pais
	 */
	public Country(String name) {
		this.name = name;
		this.confirmed = 0;
		this.deads = 0;
		this.recovereds = 0;
		this.provinces = new CopyOnWriteArrayList<Province>();
	}
	/**
	 * 
	 * @return devuelve el nombre del pais
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name nombre el nuevo nombre del pais
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return numero de casos del covid 19 confirmados
	 */
	public int getConfirmed() {
		return confirmed;
	}
	/**
	 * 
	 * @param confirmed nuevo numero de casos confirmados
	 */
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	/**
	 * 
	 * @return numero de personas que murieron a causa del covid 19
	 */
	public int getDeads() {
		return deads;
	}
	/**
	 * 
	 * @param deads nuevo numero de personas que murieron a causa de la enfermedad
	 */
	public void setDeads(int deads) {
		this.deads = deads;
	}
	/**
	 * 
	 * @return numero de personas que se recuperaron de la enfermedad
	 */
	public int getRecovereds() {
		return recovereds;
	}
	/**
	 * 
	 * @param recovereds nuevo numero de personas que se recuperaron de la enfermedad
	 */
	public void setRecovereds(int recovereds) {
		this.recovereds = recovereds;
	}
	/**
	 * 
	 * @param province añade una nueva provincia a el pais
	 */
	public void addProvice(Province province) {
		provinces.add(province);
		this.recovereds+=province.getRecovereds();
		this.deads+=province.getDeads();
		this.confirmed+=province.getConfirmed();
	}
	/**
	 * 
	 * @return todas las provincias que pertenecen al pais
	 */
	public CopyOnWriteArrayList<Province> getProvinces() {
		return provinces;
	}
	/**
	 * 
	 * @param provinces nuevas provincias que pertenecen al pais
	 */
	public void setProvinces(CopyOnWriteArrayList<Province> provinces) {
		this.provinces = provinces;
	}
	
	

}
