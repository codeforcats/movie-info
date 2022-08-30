FROM amazoncorretto:17-alpine
COPY target/movie-info-0.0.1-SNAPSHOT.jar movie-info-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/movie-info-0.0.1-SNAPSHOT.jar"]