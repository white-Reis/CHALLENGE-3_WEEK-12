# Race API

"In this project, we delve into the world of microservices, harnessing the power of multiple databases, messaging systems, and consumers. The system comprises three distinct services, each playing a pivotal role in managing races and providing a seamless experience for users.

Car Service: This service is the backbone of the project, equipped with a robust relational database. Its primary responsibility is linking cars to drivers, ensuring that every race has the perfect set of wheels. It serves as the foundation upon which the other services are built.

Race Service: With a powerful blend of OpenFeign and MySQL, the Race Service takes center stage. This service is responsible for creating races by intelligently consuming cars from the Car Service. It doesn't stop there; it features a cutting-edge algorithm that simulates races, sending race track data and the final podium results to a RabbitMQ queue. The Race Service exemplifies the project's agility and adaptability.

Historical Service: Completing the trio, the Historical Service serves as the project's memory bank. It actively consumes data from the queues and diligently stores the results in a MongoDB database. This archival process ensures that every race's history is preserved for future reference.

All services are equipped with robust validation mechanisms and leverage agile development tools like Lombok. We've also gone the extra mile by configuring a Docker Compose setup, simplifying the deployment process for all services and their respective databases. Additionally, we've crafted scripts for building executables, making it effortless to run the project on both Windows, using CMD, and Linux, using sh.

Our project is a testament to the capabilities of microservices, harnessing the potential of various technologies and databases to create a dynamic and efficient racing management system."



## 🔑 Mandatory requirements

- API documentation; Please specify the chosen approach.
- Use of the MongoDB database in one or more services.
- Use of OpenFeign.
- Use of RabbitMQ.
______________________________________________________________________________________________________________________________________________________________________________________________________________________________
# :vulcan_salute:Getting Started

## :memo:Prerequisites

- Java 17
- Maven 3.0.9
- MySQL database
- PostgreSQL
- MongoDB
- OpenFeign
- RabbitMQ
- Docker
- Postman
- GitBash

______________________________________________________________________________________________________________________________________________________________________________________________________________________________
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
   docker-compose up
  

____________________________________________________________________________________________________________________________________________________________________________________________________________________________
## :round_pushpin:EndPoints

You can use the Postman collection to interact with the Compass Scholarship Program API. Download the Postman collection by clicking the link below:

[Postman Collection](https://www.postman.com/speeding-equinox-52035/workspace/compass2023/collection/27688899-bcce56e9-ade6-4b72-b8fe-897066dc0dbd?action=share&creator=27688899)

To use the collection:
1. Open Postman.
2. Import the downloaded collection.
3. Follow the API requests and responses to interact with the endpoints.

______________________________________________________________________________________________________________________________________________________________________________________________________________________________
## :zap: Testing

Run the automated tests by executing the following command:
   ```bash
   mvn test

````      
______________________________________________________________________________________________________________________________________________________________________________________________________________________________
## 🚀Technologies

- Java 17
- Maven 4.0.0
- MySQL database
- Git
- Spring Boot 3.0.9
- Validator
- Lombok
- JPA (Java Persistence API)
- ModelMapper

### :mechanical_arm:Considerations

When starting the application, some data is automatically saved, so there is chance of error due to unique keys generated, the configuration in the application properties is like "spring.jpa.hibernate.ddl-auto=create-drop" if you want to keep your data saves will need to change to "spring.jpa.hibernate.ddl-auto=update" they will generate conflicts if the database is not cleaned up before starting the application again.

feel free to use this project and modify!
