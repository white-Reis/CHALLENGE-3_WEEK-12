FROM eclipse-temurin:17-jdk

LABEL authors="fabio"

WORKDIR /app
COPY . /app

COPY target/ms-race-0.0.1-SNAPSHOT.jar .


EXPOSE 8082

CMD ["java", "-jar", "ms-race-0.0.1-SNAPSHOT.jar"]