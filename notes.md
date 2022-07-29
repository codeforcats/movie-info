# Movie Info Service Notes

## make the executable jar file
* ./mvnw package

## then, EITHER
## run jar file from the command line
java -jar target/movie-info-service-0.0.1-SNAPSHOT.jar

## OR
## build a docker image which runs the executable jar file
* docker build -t movie-info-service-image .

## then run (detached) the image in a docker container, with ports mapped.
* docker run --name movie-info-service-container -d -p 8082:8082 movie-info-service-image 

## test the application (for movie found)
* curl http://localhost:8082/movies/Jaws

## test the application (for movie not found)
* curl http://localhost:8082/movies/foo
