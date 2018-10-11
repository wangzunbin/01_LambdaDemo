package com.wangzunbin.stream.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Director {

	private String name;
	private String country;
	private List<Film> films = new ArrayList<>();
	
	public BigDecimal getTotalBoxOffice() {
		BigDecimal total = BigDecimal.ZERO;
		for(Film film : this.getFilms()) {
			if (Objects.nonNull(film.getBoxoffice())) {
				total = total.add(film.getBoxoffice());
			}
		}
		return total;
	}
	
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
