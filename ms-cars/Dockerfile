FROM eclipse-temurin:17-jdk

LABEL authors="fabio"

WORKDIR /app
COPY . /app

RUN ./mvnw package
COPY target/ms-cars-0.0.1-SNAPSHOT.jar .


EXPOSE 8081

CMD ["java", "-jar", "ms-cars-0.0.1-SNAPSHOT.jar"]