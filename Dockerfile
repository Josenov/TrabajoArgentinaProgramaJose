FROM amazoncorretto:17
COPY target/argentinaprograma-0.0.1-SNAPSHOT.jar argentinaprograma-app.jar
ENTRYPOINT  ["java","-jar","/argentinaprograma-app.jar"]
