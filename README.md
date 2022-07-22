# Spring Boot Web Application #

## Data layer requirements ##

The system has the following requirements:

- It must keep track of all superhero/supervillain information.
  - Heroes have names, descriptions, and a superpower.
  - Heroes are affiliated with one or more superhero/supervillain organizations.
- It must keep track of all location information:
  - Locations have names, descriptions, address information, and latitude/longitude coordinates.
- It must keep track of all superhero/supervillain organization information:
  - Organizations have names, descriptions, and address/contact information.
  - Organizations have members.
- A user must be able to record a superhero/supervillain sighting for a particular location and date.
- The system must be able to report all of the superheroes sighted at a particular location.
- The system must be able to report all of the locations where a particular superhero has been seen.
- The system must be able to report all sightings (hero and location) for a particular date.
- The system must be able to report all of the members of a particular organization.
- The system must be able to report all of the organizations a particular superhero/villain belongs to.

## User interface requirements ##

The system has the following requirements:

- It must have a screen(s) to create, view, edit, and delete superheroes/supervillains in the system.
- It must have a screen(s) to create, view, edit, and delete superpowers in the system.
- It must have a screen(s) to create, view, edit, and delete locations in the system.
- It must have a screen(s) to create, view, edit, and delete superhero/supervillain organizations in the system.
- It must have a screen(s) to create, view, edit, and delete superhero/supervillain sighting (superhero/supervillain, location, and time) in the system.
- It must have a home page that displays general information about the application, navigation to all the other pages, and a newsfeed of the latest 10 sightings in the database.

## Running the application ##
1) Run the Springboot application in a Java IDE
2) Run the SQL script in MySQL
3) Access the web application using "http://localhost:8099/" in a web browser (e.g. chrome, morzilla)
