package com.sightseeing.superhero;

import java.util.Objects;

public class Sighting {
	
	private String heroName;
	private String locationName;
	private String date;
	private int ID;
	
	public Sighting(){};
	
	public Sighting(String heroName, String locationName, String date) {
		super();
		this.heroName = heroName;
		this.locationName = locationName;
		this.date = date;
	}
	public Sighting(int ID, String heroName, String locationName, String date) {
		super();
		this.heroName = heroName;
		this.locationName = locationName;
		this.date = date;
		this.ID = ID;
	}
	
	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, heroName, locationName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sighting other = (Sighting) obj;
		return Objects.equals(date, other.date) && Objects.equals(heroName, other.heroName)
				&& Objects.equals(locationName, other.locationName);
	}
	@Override
	public String toString() {
		return "Sighting [heroName=" + heroName + ", locationName=" + locationName + ", date=" + date
				+ "]";
	}

}
