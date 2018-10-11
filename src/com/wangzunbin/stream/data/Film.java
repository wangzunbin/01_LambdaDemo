package com.wangzunbin.stream.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Film {

	private String name;
	private BigDecimal boxoffice;
	private List<Actor> actors = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBoxoffice() {
		return boxoffice;
	}

	public void setBoxoffice(BigDecimal boxoffice) {
		this.boxoffice = boxoffice;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
}
