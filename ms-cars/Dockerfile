FROM openjdk:17
LABEL authors="fabio"

WORKDIR /app

COPY target/ms-cars-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["java", "-jar", "ms-cars-0.0.1-SNAPSHOT.jar"]