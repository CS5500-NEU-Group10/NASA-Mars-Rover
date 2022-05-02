# NASA-Mars-Rover

Nasa Mars Rover is a Full stack Web Application that retrieves images of Mars by the NASA Mars Rovers. Users may login and select the images from the rovers and cameras of their choice and choose real image taken from Mars. Users may also save the images they like as their personal collection.
The project is developed with Java Spring Boot for backend and React Hooks and Thymeleaf for frontend rendering.
Database is implemented with MySQL and JDBC, Hibernate for object relational mapping and query.

# Agile Methodology

This project was developed following the agile methodology in an iterative and incremental manner. Although it is a small-scale project, it adheres to the four main phases of the software development proces, software requirement, design, implementation, and testing. The process is done so in an iterative and incremental manner so as to follow the Scrum process (which falls under the Agile umbrella). In the formation of our project our team of four first brainstormed for ideas, planned the outline and discussed technologies we wanted to incorporate in the project in the preliminary discussions. 
Jira and Confluence are used as part of our Scrum process. The project is developed in short sprints of one to two weeks throughout the timeline, with regular scrum meetings between members to discuss updates. Issues and epics are created in Jira to record the work process, and product backlog are created accordingly to keep track of what work still needs to be done. 
During the project we created a first prototype and then continued tweaking and building upon the prototype.


# On the Backend

## Java Springboot

We wanted to work with Spring Boot to utilize its production-grade features to create a full, stand-alone RESTful web application. We have chosen the MVC architecture as part of the framework to help handle HTTP requests and responses. 
Backend is running on localhost 8080 powered by Apache Tomcat.
To run the backend, import project after git cloning or downloaing zip, make sure Maven dependencies are updated, MySQL workbench is connected and run Springboot project. 


## backend components

### cs5500group10
ServeletInitializer.java <br />
MarsRoverApplication.java <br />

### cs5500group10.dto
HomeDto.java

### Preference Repository 

### cs5500group10.service

MarsRoverApiService.java: stores the NASA Mars Rover API key and dynamically gets the request for our search

### cs5500group10.web

HomeController.java: Home Controller that listens to requests and persists models

### src/main/resources

index.html: (old) new index.html with react.js

### application properties:

JUnit test cases

## MySQL Database

The application uses Spring Data JPA for CRUD funcationalities in the database. 

## Unit Test

The project has unit tests in the developmental phase as part of the testing in the Scrum process. 

## Unit Test for React.js with Jest


## E2E Test for React.js with Cypress

E2E test conducted with Cypress in the Cypress folder

# On the Frontend

## Thymeleaf and React Hooks

Frontend UI is rendered with Thymeleaf and React Hooks

### Update

Frontend with React Hooks since team is more unfamiliar with Thymeleaf. 

## Frontend Components

JS Docs included

### Components:
Navbar.js: Navigation menu with Home, Favorites, menu of the rovers (introduction pages), and login <br />
Curiosity.js: info page of Curiosity Rover <br />
Spirit.js: info page of Spirit Rover <br />
Opportunity.js: info page of Opportunity Rover <br />
orbit.js: landing page with 3D <br />
RoverCams.js: Hash Map of rovers with their corresponding cameras <br />
SelectCamera.js: Camera selection component of the home page <br />
SelectRover.js: Rover selection component of the home page <br />
SelectSol.js: input form component of Sol selection in the home page <br />
mars.js: Landing pace with 3D components <br />
UserNamePasswordEdit: Login and signup implementation, connects to backend.

### Pages:
Fave.js: the favorited list of users <br />
UserAccount.js: login page <br />
SignUp.js: signup page <br />
Main.js: main page(home) of the website <br />
Filter.js: parent component of SelectRover.js and SelectCamera.js <br />
Home.js: parent component of RenderImg.js <br />
App.js: Parent component of all components. 


## Bootstrap 

Bootstrap framework and CSS is used for frontend rendering and screen responsiveness


### Digital Wireframe:

![Screen Shot 2022-04-18 at 3 37 04 PM](https://user-images.githubusercontent.com/101501539/163888253-0433ff41-9c0e-49d2-bdff-bfb175310ea6.png) <br />
 <br />
The main page shows the selection for users to choose the Mars rovers (can choose all three or individual rovers) and the cameras. Since not all rovers have the same cameras, only the cameras that a rover has will light up. Sol Day selection is the Mars day seleciton. If users don't input the Sol day, a default value of the 1000th Sol day will be supplied. 
 <br />
  <br />
![Screen Shot 2022-04-18 at 3 37 25 PM](https://user-images.githubusercontent.com/101501539/163888286-4aa13958-2717-4ff8-9c09-225bec9a2702.png) 
 <br /> 
  <br />
After users select their choices and hit submit, the page calls the NASA Mars Rover photo API and filters the option to render the photos that fit the selection conditions. Users may choose to save the images in their own account album by pressing the heart button.  
<br />
 <br />
![Screen Shot 2022-04-18 at 3 37 48 PM](https://user-images.githubusercontent.com/101501539/163888311-897de5e5-6f68-469d-9e40-8881a62b2c0b.png) 
<br />
 <br />
The navbar menu also has three menu options that are the description of each rovers, namely the Opportunity Rover, the Curiosity Rover, and the Spirit Rover. This gives users a gist of the rovers' missions and more information about them. 
<br />
 <br />
