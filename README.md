# Race API

In this project, we delve into the world of microservices, harnessing the power of multiple databases, messaging systems, and consumers. The system comprises three distinct services, each playing a pivotal role in managing races and providing a seamless experience for users.

Car Service: This service is the backbone of the project, equipped with a robust relational database. Its primary responsibility is linking cars to drivers, ensuring that every race has the perfect set of wheels. It serves as the foundation upon which the other services are built.

Race Service: With a powerful blend of OpenFeign and MySQL, the Race Service takes center stage. This service is responsible for creating races by intelligently consuming cars from the Car Service. It doesn't stop there; it features a cutting-edge algorithm that simulates races, sending race track data and the final podium results to a RabbitMQ queue. The Race Service exemplifies the project's agility and adaptability.

Historical Service: Completing the trio, the Historical Service serves as the project's memory bank. It actively consumes data from the queues and diligently stores the results in a MongoDB database. This archival process ensures that every race's history is preserved for future reference.

All services are equipped with robust validation mechanisms and leverage agile development tools like Lombok. We've also gone the extra mile by configuring a Docker Compose setup, simplifying the deployment process for all services and their respective databases. Additionally, we've crafted scripts for building executables, making it effortless to run the project on both Windows, using CMD, and Linux, using sh.

Our project is a testament to the capabilities of microservices, harnessing the potential of various technologies and databases to create a dynamic and efficient racing management system.



## 🔑 Mandatory requirements

- API documentation; Please specify the chosen approach.
- Use of the MongoDB database in one or more services.
- Use of OpenFeign.
- Use of RabbitMQ.
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

# :vulcan_salute:Getting Started

## :memo:Prerequisites

- Java 17
- Maven 4.0.0
- MySQL database
- PostgreSQL
- MongoDB
- OpenFeign
- RabbitMQ
- Docker
- Postman
- GitBash
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

## :hammer_and_wrench:Installation

If you don't have Maven, GitBash our Docker installed, you can download it from here 
Maven - https://maven.apache.org/download.cgi
GitBash - https://git-scm.com/downloads
Docker - https://www.docker.com/products/docker-desktop/

1. Clone the repository:
   ```bash
   git clone https://github.com/white-Reis/CHALLENGE-3_WEEK-12.git

2. Build projects:
   ```bash
   cd CHALLENGE-3_WEEK-12
   bash build_all.sh

3. Run Docker compose
   ```bash
   docker-compose up -d


Services take a while to start, Spring applications take a little longer because a waiting time has been defined for the services to start correctly, but if it doesn't happen as expected, it can be monitored by Docker.
If everything goes correctly, all services will be running as in the image below

![dock](https://github.com/white-Reis/CHALLENGE-3_WEEK-12/assets/82837278/bf94e74d-205b-4264-93b1-726cf03a3ee5)

If any service has the exited status, the "docker-compose up -d" command must be run again or click on the action arrow in the right corner of the containers, as shown in the image below

![ssa](https://github.com/white-Reis/CHALLENGE-3_WEEK-12/assets/82837278/3710e918-0722-46ba-acc4-6395ebde694b)
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

## :zap: Testing

Running the test requires you to enter the service directory:
   ```bash
   cd .\ms-cars\
   mvn test

````     
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

## :round_pushpin:EndPoints

You can use the Postman collection to interact with the API. Download the Postman collection by clicking the link below:

[Postman Collection](https://www.postman.com/speeding-equinox-52035/workspace/race-api/collection/27688899-92be23e3-5d60-4987-a410-839132c0b875?action=share&creator=27688899)

To use the collection:
1. Open Postman.
2. Import the downloaded collection.
3. Follow the API requests and responses to interact with the endpoints.
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

## 🚀Technologies

- Java 17
- Maven 4.0.0
- Docker
- MySQL database
- PostgreSQL
- MongoDB
- OpenFeign
- RabbitMq
- Git
- GitBash
- Spring Boot
- Validator
- Lombok
- JPA (Java Persistence API)
- ModelMapper
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

## :speech_balloon: BackLog of project(Kanban)

Here is how the division of tasks was organized during development

![ls](https://github.com/white-Reis/CHALLENGE-3_WEEK-12/assets/82837278/a76900f4-6d1a-4bdb-b4f1-fe1f8bad9ccb)

