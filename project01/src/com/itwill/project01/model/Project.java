package com.itwill.project01.model;

public class Project {
	
	private int id;
	private String type;
	private String store;
	private String city;
	private String adress;
	private char visite;
	
	
	
	
	public Project(int id, String type, String store, String city, String adress, char visite) {
		this.id = id;
		this.type = type;
		this.store = store;
		this.city = city;
		this.adress = adress;
		this.visite = visite;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public char getVisite() {
		return visite;
	}
	public void setVisite(char visite) {
		this.visite = visite;
	}


	@Override
	public String toString() {
		return "Project01Model [id=" + id + ", type=" + type + ", store=" + store + ", city=" + city + ", adress="
				+ adress + ", visite=" + visite + "]";
	}
	
	
	
	
	

}
