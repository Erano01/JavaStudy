package me.erano.com.s02intermediateoperations;

import java.util.List;
import java.util.Objects;

public class State {
    
    private String name;
    private List<City> cities;
	public State(String name, List<City> cities) {
		this.name = name;
		this.cities = cities;
	}
	public State() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cities, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(cities, other.cities) && Objects.equals(name, other.name);
	}

}
