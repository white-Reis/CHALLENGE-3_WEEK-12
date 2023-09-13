FROM eclipse-temurin:17-jdk

LABEL authors="fabio"

WORKDIR /app
COPY . /app

COPY target/ms-history-0.0.1-SNAPSHOT.jar .


EXPOSE 8083

CMD ["java", "-jar", "ms-history-0.0.1-SNAPSHOT.jar"]