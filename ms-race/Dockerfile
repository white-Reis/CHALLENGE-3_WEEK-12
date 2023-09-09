FROM openjdk:17
LABEL authors="fabio"

WORKDIR /build
COPY . /build

RUN apt-get update && apt-get install -y maven
RUN mvn package

WORKDIR /app
COPY target/ms-cars-0.0.1-SNAPSHOT.jar .

EXPOSE 8082

CMD ["java", "-jar", "ms-race-0.0.1-SNAPSHOT.jar"]