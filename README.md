# Spring-Boot
Two Spring Boot micro services that send requests to each other in ping pong fashion.

## How to run

Run the microservices 'demo' and 'demo1' with gradle

  #### ./gradlew bootrun
  
- 'demo' runs on 
  #### port 8080
- 'demo1' runs on 
  #### port 8082
- To start the ping pong send a request to url
  ### /start
  on any of the two microservices.
- Similarly, to stop the ping pong send a request to url
  ### /stop
  
## What you need

- Two postgres instances running on ports 5433 and 5434.
- For port 5433 :
  * Create a database 'microservice2' and a table 'messages'.
  * Create a role called 'user2' with password set to 'password'.
  * Grant access to table 'messages' to the role 'user2'.
- For port 5434 :
  * Create a database 'microservice1' and a table 'messages'.
  * Create a role called 'microservice1' with password set to 'password'.
  * Grant access to table 'messages' to the role 'microservice1'.
- Zookeeper and Kafka server should be running on their default ports before running the microservices.
