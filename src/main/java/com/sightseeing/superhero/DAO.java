package com.sightseeing.superhero;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	@Autowired
	private final JdbcTemplate jdbc;
	
	public DAO(JdbcTemplate jdbc) { 
		 this.jdbc = jdbc;
	}
	
	public boolean recordNewHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO basicInfo(heroName,info,superpower,organizationName) VALUES(?,?,?,?)",
					superhero.getName(),superhero.getDescription(),superhero.getSuperpower(),superhero.getOrganization());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE basicInfo SET "
					+ "info = ?,superpower = ?,organizationName = ?"
					+ "WHERE heroName = ?",
					superhero.getDescription(),superhero.getSuperpower(),superhero.getOrganization(),superhero.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM basicInfo WHERE heroName = ?",
					superhero.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Superhero viewExistingHero(Superhero superhero) {
		Superhero querySuperhero = new Superhero();
		try{
			querySuperhero = jdbc.queryForObject("SELECT * FROM basicInfo WHERE heroName = ?", new SuperheroMapper(), superhero.getName());
		} catch(Exception e) {
			
		};
		return querySuperhero;
	}
	
	public List<Superhero> viewHeroByOrganization(Superhero superhero) {

		List<Superhero> superheroList = jdbc.query("SELECT * FROM basicInfo WHERE organizationName = ?", new SuperheroMapper(), superhero.getOrganization());
		return superheroList;
	}
	
	public boolean recordNewSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO superpowerInfo(superpower,info) VALUES(?,?)",
					superpower.getSuperpower(),superpower.getDescription());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE superpowerInfo SET "
					+ "info = ? "
					+ "WHERE superpower = ?",
					superpower.getDescription(),superpower.getSuperpower());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM superpowerInfo WHERE superpower = ?",
					superpower.getSuperpower());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Superpower viewExistingSuperpower(Superpower superpower) {
		Superpower querySuperpower = new Superpower();
		try{
			querySuperpower = jdbc.queryForObject("SELECT * FROM superpowerInfo WHERE superpower = ?", new SuperpowerMapper(), superpower.getSuperpower());
		} catch(Exception e) {
			
		};
		return querySuperpower;
	}
	
	public boolean recordNewLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO locationInfo(locationName,info,address,latitude,longitude) VALUES(?,?,?,?,?)",
					location.getName(),location.getDescription(),location.getAddress(),location.getLatitude(),location.getLongitude());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE locationInfo SET "
					+ "info = ?,address = ?,latitude = ?,longitude = ? "
					+ "WHERE locationName = ?",
					location.getDescription(),location.getAddress(),location.getLatitude(),location.getLongitude(),location.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM locationInfo WHERE locationName = ?",
					location.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Location viewExistingLocation(Location location) {
		Location queryLocation = new Location();
		try{
			queryLocation = jdbc.queryForObject("SELECT * FROM locationInfo WHERE locationName = ?", new LocationMapper(), location.getName());
		} catch(Exception e) {
			
		};
		return queryLocation;
	}
	
	public boolean recordNewOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO organizationInfo(organizationName,info,address) VALUES(?,?,?)",
					organization.getName(),organization.getDescription(),organization.getAddress());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE organizationInfo SET "
					+ "info = ?,address = ? "
					+ "WHERE organizationName = ?",
					organization.getDescription(),organization.getAddress(),organization.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM organizationInfo WHERE organizationName = ?",
					organization.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Organization viewExistingOrganization(Organization organization) {
		Organization queryOrganization = new Organization();
		try{
			queryOrganization = jdbc.queryForObject("SELECT * FROM organizationInfo WHERE organizationName = ?", new OrganizationMapper(), organization.getName());
		} catch(Exception e) {
			
		};
		return queryOrganization;
	}
	
	public boolean recordNewSighting(Sighting sighting) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO sighting(heroName,locationName,timedate) VALUES(?,?,?)",
					sighting.getHeroName(),sighting.getLocationName(),sighting.getDate());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingSighting(Sighting sighting) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE sighting SET "
					+ "heroName = ?,locationName = ?,timedate = ?  "
					+ "WHERE id = ?",
					sighting.getHeroName(),sighting.getLocationName(),sighting.getDate(),sighting.getID());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingSighting(Sighting sighting) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM sighting WHERE id = ?",sighting.getID());		
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public List<Sighting> viewSightingByLocation(Sighting sighting) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE locationName = ?", new SightingMapper(), sighting.getLocationName());
		return sightingList;
	}
	
	public List<Sighting> viewSightingBySuperhero(Sighting sighting) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE heroName = ?", new SightingMapper(), sighting.getHeroName());
		return sightingList;
	}
	
	public List<Sighting> viewSightingByDate(Sighting sighting) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE timedate = ?", new SightingMapper(), sighting.getDate());
		return sightingList;
	}
	
	public List<Sighting> viewTenSightings() {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting", new SightingMapper());
		if (sightingList.size() > 10) {
			sightingList = sightingList.subList(sightingList.size()-10, sightingList.size());
		}
		return sightingList;
	}
}
