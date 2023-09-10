FROM openjdk:17

LABEL authors="fabio"

WORKDIR /app
COPY . /app

RUN ./mvnw package
COPY target/ms-race-0.0.1-SNAPSHOT.jar .


EXPOSE 8082

CMD ["java", "-jar", "ms-race-0.0.1-SNAPSHOT.jar"]