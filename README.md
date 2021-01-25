# Spring-Boot
Spring Boot micro services that send requests to each other in ping pong fashion

## How to run

Run the project with gradle

  #### ./gradlew bootrun
  
## What you need

- Two postgres instances running on ports 5433 and 5434.
- For port 5433 :
  * Create a database 'microservice2' and a table 'messages'.
  * Create a role called 'user2' with password set to 'password'.
  * Grant access to table 'messages' to the role 'user2'.
- For port 5433 :
  * Create a database 'microservice1' and a table 'messages'.
  * Create a role called 'microservice1' with password set to 'password'.
  * Grant access to table 'messages' to the role 'microservice1'.
- Zookeeper and Kafka server should be running on their default ports before running the microservices.
