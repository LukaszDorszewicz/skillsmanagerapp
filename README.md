# Content
Simple spring boot / angular / mongo / docker application for managing (create / read / update / delete) our own skills.
Docker is needed to run this application locally.

## Tools
- Spring Boot
- Angular
- Mongo Database
- Docker

### Steps
- from pom.xml in level in skillsmanager package execute command: "mvn clean install -DskipTests" (creating jar)
- from docker-compose.yml level execute command: "docker-compose up -d --build" (generating docker containers)
- from docker-compose.yml level execute command: "docker-compose logs -f" (checking logs / if app is successfully running)
- go to http://localhost:4200 and have fun :)

#### Screens
![alt text](https://cdn.imageupload.workers.dev/8FMKwyIm_skills.jpg)
