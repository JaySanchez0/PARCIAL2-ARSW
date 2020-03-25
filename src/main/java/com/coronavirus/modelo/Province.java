package com.coronavirus.modelo;

public class Province {
	private String name;
	private int confirmed;
	private int deads;
	private int recovereds;
	public Province(String name,int deads,int confirmed,int recovereds) {
		this.name = name;
		this.confirmed = recovereds;
		this.recovereds = confirmed;
		this.deads = deads;
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
	

}
