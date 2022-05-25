FROM amazoncorretto:17-alpine
COPY target/movie-info-service-0.0.1-SNAPSHOT.jar movie-info-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/movie-info-service-0.0.1-SNAPSHOT.jar"]