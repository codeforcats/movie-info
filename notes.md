# Movie Info Service Notes

## make the executable jar file
* ./mnvw package

## build a docker image which runs the executable jar file
* docker build -t movie-info-service-image .

## run (detached)the image in a docker container, with ports mapped.
* docker run -d -p 8082:8082 movie-info-service-image 

## test the image (for movie found)
* curl http://localhost:8082/movies/Jaws

## test the image (for movie not found)
* curl http://localhost:8082/movies/foo
