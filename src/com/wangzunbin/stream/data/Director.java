package com.wangzunbin.stream.data;

import java.util.ArrayList;
import java.util.List;

public class Director {

	private String name;
	private String country;
	private List<Film> films = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	
	@Override
	public String toString() {
		return "Director [name=" + name + ", country=" + country + "]";
	}
	
	
}
