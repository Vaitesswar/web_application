package com.sightseeing.superhero;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SuperheroApplicationTests {
	
	@Autowired
	private DAO DAO;

	@Test
	public void recordNewSighting() throws IOException{
		String heroName = "Batman";
		String locationName = "Swimming complex";
		String date = "2022-07-13";
		Sighting sighting = new Sighting(heroName,locationName,date);
		DAO.recordNewSighting(sighting);
    }
	
	@Test
	public void viewSightingByLocation() throws IOException{
		String locationName = "Swimming complex";
		Sighting sighting = new Sighting();
		sighting.setLocationName(locationName);
		List<Sighting> sightingList = DAO.viewSightingByLocation(sighting);
		assertEquals(sightingList.size(),4);
    }

	@Test
	public void viewSightingBySuperhero() throws IOException{
		String heroName = "Batman";
		Sighting sighting = new Sighting();
		sighting.setHeroName(heroName);
		List<Sighting> sightingList = DAO.viewSightingBySuperhero(sighting);
		System.out.println(sightingList.size());
		assertEquals(sightingList.size(),3);
    }
	
	@Test
	public void viewSightingByDate() throws IOException{
		String date = "2022-07-13";
		Sighting sighting = new Sighting();
		sighting.setDate(date);;
		List<Sighting> sightingList = DAO.viewSightingByDate(sighting);
		System.out.println(sightingList.size());
		assertEquals(sightingList.size(),4);
    }

}
