# DiecastFinder - Crawler

The project that helps to get the list of desired models for collection. 
The project itself is located in private repository, here only README file presented for information purposes.

## Test demo features
* PACT Consumer driven contract testing (provider part);
* Schema testing - TBD;
* Fuzzy testing - TBD.

## Configuration in IntelliJ
1. Add "local-discovery" to Active profiles

## How to run application
1. Run Docker (Docker Decktop for Win OS)
2. Run artemis container: docker run --detach --name mycontainer -p 61616:61616 -p 8161:8161 --rm apache/activemq-artemis:latest-alpine
3. Run project eurekareganddiscovery, check http://localhost:8761
4. Run [CatalogApplication.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2FCatalogApplication.java) .main().

## Testing
* PACT provider contract test

## Deployment: artifacts preparation
* Docker - to make a container out of service from DevOps point of view.
  To build docker image use command:
  `C:\Projects\DiecastFinder2\crawler> docker build -f .\src\main\docker\Dockerfile -t diecastfinder-crawler .`
  <br>To run build use command:
  `C:\Projects\DiecastFinder2\crawler> docker run -p 8081:8081 diecastfinder-crawler`


* Spring Boot docker Layers - to optimize consuming of space by sharing common parts of software between services and versions.
  https://springframework.guru/why-you-should-be-using-spring-boot-docker-layers/
    * `mvn clean package` -> fat jar

  Manual creation of layers. Just to test the command.
    * `java -Djarmode=tools -jar target/crawler-0.0.1-SNAPSHOT.jar list-layers` -> printed list
    * `java -Djarmode=tools -jar target/crawler-0.0.1-SNAPSHOT.jar extract --layers --launcher` -> folder with layers

  Run docker file and let docker do all job.
    * `--no-cache` - cache is turned off,<br>
      `-D --progress=plain` - print stdout to console<br>
      `C:\Projects\DiecastFinder2\crawler> docker -D build -f .\src\main\docker\Dockerfile -t diecastfinder-crawler --progress=plain --no-cache .`


* Docker is using Maven properties