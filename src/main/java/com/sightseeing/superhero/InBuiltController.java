package com.sightseeing.superhero;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InBuiltController {
	@Autowired
	private final DAO DAO;
	
	public InBuiltController(DAO DAO) {
		this.DAO = DAO;
	}
	
	@GetMapping("/")
	public String getHomepage(Model model) {
	   List<Sighting> sightingList = DAO.viewTenSightings();
	   model.addAttribute("sightingList", sightingList);
	   return "homepage";
	}
	
	@GetMapping("/homepage")
	public String returnHomepage(Model model) {
	   List<Sighting> sightingList = DAO.viewTenSightings();
	   model.addAttribute("sightingList", sightingList);
	   return "homepage";
	}
	
	@RequestMapping("/superheroCreate")
	public String createSuperheros() {
	    return "superhero/create";
	}
	
	@RequestMapping("/superheroView")
	public String viewSuperheros() {
	    return "superhero/view";
	}
	
	@RequestMapping("/superheroViewOrganization")
	public String viewSuperherosOrganization() {
	    return "superhero/viewOrganization";
	}
	
	@RequestMapping("/superheroViewByOrganization")
	public String viewSuperherosByOrganization() {
	    return "superhero/viewByOrganization";
	}
	
	@RequestMapping("/superheroEdit")
	public String editSuperheros() {
	    return "superhero/edit";
	}
	
	@RequestMapping("/superheroDelete")
	public String deleteSuperheros() {
	    return "superhero/delete";
	}
	
	@RequestMapping("/superpowerCreate")
	public String createSuperpower() {
	    return "superpowers/create";
	}
	
	@RequestMapping("/superpowerView")
	public String viewSuperpower() {
	    return "superpowers/view";
	}
	
	@RequestMapping("/superpowerEdit")
	public String editSuperpower() {
	    return "superpowers/edit";
	}
	
	@RequestMapping("/superpowerDelete")
	public String deleteSuperpower() {
	    return "superpowers/delete";
	}
	
	@RequestMapping("/locationCreate")
	public String createLocation() {
	    return "locations/create";
	}
	
	@RequestMapping("/locationView")
	public String viewLocation() {
	    return "locations/view";
	}
	
	@RequestMapping("/locationEdit")
	public String editLocation() {
	    return "locations/edit";
	}
	
	@RequestMapping("/locationDelete")
	public String deleteLocation() {
	    return "locations/delete";
	}
	
	@RequestMapping("/organizationCreate")
	public String createOrganization() {
	    return "organization/create";
	}
	
	@RequestMapping("/organizationView")
	public String viewOrganization() {
	    return "organization/view";
	}
	
	@RequestMapping("/organizationEdit")
	public String editOrganization() {
	    return "organization/edit";
	}
	
	@RequestMapping("/organizationDelete")
	public String deleteOrganization() {
	    return "organization/delete";
	}
	
	@RequestMapping("/sightingCreate")
	public String createSighting() {
	    return "sighting/create";
	}
	
	
	@RequestMapping("/sightingEdit")
	public String editSighting() {
	    return "sighting/edit";
	}
	
	@RequestMapping("/sightingDelete")
	public String deleteSighting() {
	    return "sighting/delete";
	}
	
	@RequestMapping("/sightingViewByLocation")
	public String viewSightingByLocation() {
	    return "sighting/viewLocation";
	}
	
	@RequestMapping("/sightingViewBySuperhero")
	public String viewSightingBySuperhero() {
	    return "sighting/viewSuperhero";
	}
	
	@RequestMapping("/sightingViewByDate")
	public String viewSightingByDate() {
	    return "sighting/viewDate";
	}
	
	@PostMapping("createSuperheroForm")
	public String createNewSuperhero(HttpServletRequest request) {
		Superhero superhero = new Superhero();
		superhero.setName(request.getParameter("name"));
		superhero.setSuperpower(request.getParameter("superpower"));
		superhero.setOrganization(request.getParameter("organization"));
		superhero.setDescription(request.getParameter("description"));
		boolean valid = DAO.recordNewHero(superhero);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("editSuperheroForm")
	public String editNewSuperhero(HttpServletRequest request) {
		Superhero superhero = new Superhero();
		superhero.setName(request.getParameter("name"));
		superhero.setSuperpower(request.getParameter("superpower"));
		superhero.setOrganization(request.getParameter("organization"));
		superhero.setDescription(request.getParameter("description"));
		boolean valid = DAO.editExistingHero(superhero);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("deleteSuperheroForm")
	public String deleteNewSuperhero(HttpServletRequest request) {
		Superhero superhero = new Superhero();
		superhero.setName(request.getParameter("name"));
		boolean valid = DAO.deleteExistingHero(superhero);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@GetMapping("viewSuperheroForm")
	public String viewNewSuperhero(Model model, HttpServletRequest request) {
		Superhero superhero = new Superhero();
		superhero.setName(request.getParameter("name"));
		Superhero querySuperhero = DAO.viewExistingHero(superhero);
		String URL = new String();
		if (querySuperhero.getName() == null) {
			URL = "invalid";
		} else {
			model.addAttribute("name",querySuperhero.getName());
			model.addAttribute("description",querySuperhero.getDescription());
			model.addAttribute("organization",querySuperhero.getOrganization());
			model.addAttribute("superpower",querySuperhero.getSuperpower());
			URL = "superhero/display";
		}
		
	    return URL;
	}
	
	@GetMapping("viewSuperheroByOrganizationForm")
	public String viewSuperheroByOrganization(Model model, HttpServletRequest request) {
		Superhero superhero = new Superhero();
		superhero.setOrganization(request.getParameter("organization"));
		List<Superhero> superheroList = DAO.viewHeroByOrganization(superhero);
		model.addAttribute("superheroList", superheroList);
        
	    return "superhero/displayByOrganization";
	}
	
	@PostMapping("createSuperpowerForm")
	public String createNewSuperpower(HttpServletRequest request) {
		Superpower superpower = new Superpower();
		superpower.setSuperpower(request.getParameter("superpower"));
		superpower.setDescription(request.getParameter("description"));
		boolean valid = DAO.recordNewSuperpower(superpower);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("editSuperpowerForm")
	public String editNewSuperpower(HttpServletRequest request) {
		Superpower superpower = new Superpower();
		superpower.setSuperpower(request.getParameter("superpower"));
		superpower.setDescription(request.getParameter("description"));
		boolean valid = DAO.editExistingSuperpower(superpower);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("deleteSuperpowerForm")
	public String deleteNewSuperpower(HttpServletRequest request) {
		Superpower superpower = new Superpower();
		superpower.setSuperpower(request.getParameter("superpower"));
		boolean valid = DAO.deleteExistingSuperpower(superpower);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@GetMapping("viewSuperpowerForm")
	public String viewNewSuperpower(Model model, HttpServletRequest request) {
		Superpower superpower = new Superpower();
		superpower.setSuperpower(request.getParameter("superpower"));
		Superpower querySuperpower = DAO.viewExistingSuperpower(superpower);
		String URL = new String();
		if (querySuperpower.getSuperpower() == null) {
			URL = "invalid";
		} else {
			model.addAttribute("superpower",querySuperpower.getSuperpower());
			model.addAttribute("description",querySuperpower.getDescription());
			URL = "superpowers/display";
		}
		
	    return URL;
	}

	@PostMapping("createLocationForm")
	public String createNewLocation(HttpServletRequest request) {
		Location location = new Location();
		location.setName(request.getParameter("name"));
		location.setAddress(request.getParameter("address"));
		BigDecimal latitude = new BigDecimal(0);
		if (request.getParameter("latitude") != null && !request.getParameter("latitude").isEmpty()){
			latitude = new BigDecimal(request.getParameter("latitude")).setScale(6, RoundingMode.HALF_UP);
		}
		location.setLatitude(latitude);
		BigDecimal longitude = new BigDecimal(0);
		if (request.getParameter("longitude") != null && !request.getParameter("longitude").isEmpty()){
			longitude = new BigDecimal(request.getParameter("longitude")).setScale(6, RoundingMode.HALF_UP);
		}
		location.setLongitude(longitude);
		location.setDescription(request.getParameter("description"));
		boolean valid = DAO.recordNewLocation(location);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("editLocationForm")
	public String editNewLocation(HttpServletRequest request) {
		Location location = new Location();
		location.setName(request.getParameter("name"));
		location.setAddress(request.getParameter("address"));
		BigDecimal latitude = new BigDecimal(0);
		if (request.getParameter("latitude") != null && !request.getParameter("latitude").isEmpty()){
			latitude = new BigDecimal(request.getParameter("latitude")).setScale(6, RoundingMode.HALF_UP);
		}
		location.setLatitude(latitude);
		BigDecimal longitude = new BigDecimal(0);
		if (request.getParameter("longitude") != null && !request.getParameter("longitude").isEmpty()){
			longitude = new BigDecimal(request.getParameter("longitude")).setScale(6, RoundingMode.HALF_UP);
		}
		location.setLongitude(longitude);
		location.setDescription(request.getParameter("description"));
		boolean valid = DAO.editExistingLocation(location);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("deleteLocationForm")
	public String deleteNewLocation(HttpServletRequest request) {
		Location location = new Location();
		location.setName(request.getParameter("name"));
		boolean valid = DAO.deleteExistingLocation(location);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@GetMapping("viewLocationForm")
	public String viewNewLocation(Model model, HttpServletRequest request) {
		Location location = new Location();
		location.setName(request.getParameter("name"));
		Location queryLocation = DAO.viewExistingLocation(location);
		String URL = new String();
		if (queryLocation.getName() == null) {
			URL = "invalid";
		} else {
			model.addAttribute("name",queryLocation.getName());
			model.addAttribute("address",queryLocation.getAddress());
			model.addAttribute("latitude",queryLocation.getLatitude());
			model.addAttribute("longitude",queryLocation.getLongitude());
			model.addAttribute("description",queryLocation.getDescription());
			URL = "locations/display";
		}
		
	    return URL;
	}
	
	@PostMapping("createOrganizationForm")
	public String createNewOrganization(HttpServletRequest request) {
		Organization organization = new Organization();
		organization.setName(request.getParameter("organization"));
		organization.setAddress(request.getParameter("address"));
		organization.setDescription(request.getParameter("description"));
		boolean valid = DAO.recordNewOrganization(organization);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("editOrganizationForm")
	public String editNewOrganization(HttpServletRequest request) {
		Organization organization = new Organization();
		organization.setName(request.getParameter("organization"));
		organization.setAddress(request.getParameter("address"));
		organization.setDescription(request.getParameter("description"));
		boolean valid = DAO.editExistingOrganization(organization);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("deleteOrganizationForm")
	public String deleteNewOrganization(HttpServletRequest request) {
		Organization organization = new Organization();
		organization.setName(request.getParameter("organization"));
		boolean valid = DAO.deleteExistingOrganization(organization);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@GetMapping("viewOrganizationForm")
	public String viewNewOrganization(Model model, HttpServletRequest request) {
		Organization organization = new Organization();
		organization.setName(request.getParameter("organization"));
		Organization queryOrganization = DAO.viewExistingOrganization(organization);
		String URL = new String();
		if (queryOrganization.getName() == null) {
			URL = "invalid";
		} else {
			model.addAttribute("organization",queryOrganization.getName());
			model.addAttribute("address",queryOrganization.getAddress());
			model.addAttribute("description",queryOrganization.getDescription());
			URL = "organization/display";
		}
		
	    return URL;
	}
	

	
	@PostMapping("createSightingForm")
	public String createNewSighting(HttpServletRequest request){
		Sighting sighting = new Sighting();
		sighting.setHeroName(request.getParameter("name"));
		sighting.setLocationName(request.getParameter("location"));
		sighting.setDate(request.getParameter("date"));
		boolean valid = DAO.recordNewSighting(sighting);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("editSightingForm")
	public String editNewSighting(HttpServletRequest request) throws ParseException {
		Sighting sighting = new Sighting();
		sighting.setID(Integer.parseInt(request.getParameter("ID")));
		sighting.setHeroName(request.getParameter("name"));
		sighting.setLocationName(request.getParameter("location"));
		sighting.setDate(request.getParameter("date"));
		boolean valid = DAO.editExistingSighting(sighting);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@PostMapping("deleteSightingForm")
	public String deleteNewSighting(HttpServletRequest request) {
		Sighting sighting = new Sighting();
		sighting.setID(Integer.parseInt(request.getParameter("ID")));
		boolean valid = DAO.deleteExistingSighting(sighting);
		String URL = new String();
		if (valid){
			URL = "valid";
		} else {
			URL = "invalid";
		}
	    return URL;
	}
	
	@GetMapping("viewSightingByLocationForm")
	public String viewSightingByLocation(Model model, HttpServletRequest request) {
		Sighting sighting = new Sighting();
		sighting.setLocationName(request.getParameter("location"));
		List<Sighting> sightingList = DAO.viewSightingByLocation(sighting);
		model.addAttribute("sightingList", sightingList);
        
	    return "sighting/displayLocation";
	}
	
	@GetMapping("viewSightingBySuperheroForm")
	public String viewSightingBySuperhero(Model model, HttpServletRequest request) {
		Sighting sighting = new Sighting();
		sighting.setHeroName(request.getParameter("name"));
		List<Sighting> sightingList = DAO.viewSightingBySuperhero(sighting);
		model.addAttribute("sightingList", sightingList);
        
	    return "sighting/displaySuperhero";
	}
	
	@GetMapping("viewSightingByDateForm")
	public String viewSightingByDate(Model model, HttpServletRequest request) {
		Sighting sighting = new Sighting();
		sighting.setDate(request.getParameter("date"));
		List<Sighting> sightingList = DAO.viewSightingByDate(sighting);
		model.addAttribute("sightingList", sightingList);
        
	    return "sighting/displayDate";
	}
}
