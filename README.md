# Quiz Application - Microservices

A backend Quiz Application developed using Java and Spring Boot Microservices. The application separates question management and quiz operations into independent services, with Netflix Eureka for service discovery and OpenFeign for communication between services.

## Features

- **Question Management:** Add questions, retrieve all questions, and filter questions by category.
- **Quiz Creation:** Create quizzes based on a selected category and number of questions.
- **Random Question Selection:** Retrieve random question IDs based on category and question count.
- **Quiz Retrieval:** Fetch quiz questions using a quiz ID.
- **Score Calculation:** Submit answers and calculate the quiz score.
- **Service Discovery:** Register and discover microservices using Netflix Eureka.
- **Inter-Service Communication:** Communicate between Question Service and Quiz Service using OpenFeign.
- **Database Integration:** Store questions and quiz details in MySQL.

## Technologies Used

- Java 17
- Spring Boot
- Spring Web MVC / REST APIs
- Spring Data JPA
- Hibernate
- MySQL
- Spring Cloud Netflix Eureka
- Spring Cloud OpenFeign
- Maven
- Lombok
- IntelliJ IDEA

## Microservices Architecture

### 1. Question Service
Manages question data, retrieves questions by category, selects random questions, and calculates scores.

### 2. Quiz Service
Creates quizzes, stores the associated question IDs, retrieves quiz questions, and processes quiz submissions.

### 3. Service Registry
Uses Netflix Eureka Server to register and discover available microservices.

## API Overview

### Question Service
- `GET /questions/allQuestions` — Retrieve all questions.
- `GET /questions/category/{category}` — Retrieve questions by category.
- `POST /questions/add` — Add a question.
- `GET /questions/Generate` — Generate random question IDs using category and question count.
- `POST /questions/getQuestion` — Retrieve questions using a list of IDs.
- `POST /questions/getScore` — Calculate the score from submitted answers.

### Quiz Service
- `POST /quiz/create` — Create a quiz.
- `GET /quiz/get/{id}` — Retrieve questions for a quiz.
- `POST /quiz/submit/{id}` — Submit answers and calculate the score.

## Local Setup

### Prerequisites
- JDK 17
- MySQL
- Maven
- IntelliJ IDEA or another Java IDE

### Database Configuration
Create two MySQL databases:

- `Question_db`
- `Quiz_db`

Configure your MySQL username and password in the `application.properties` file of each service.

### Service Ports

| Service | Port |
|---|---:|
| Service Registry | 8761 |
| Quiz Service | 8082 |
| Question Service | 8090 |

### Running the Application

1. Start the Service Registry.
2. Start the Question Service.
3. Start the Quiz Service.
4. Open the Eureka dashboard at `http://localhost:8761` to check service registration.
5. Test the REST APIs using Postman.

## Learning Outcomes

This project demonstrates practical implementation of microservices architecture, REST API development, database persistence, service discovery, and inter-service communication using Java and Spring Boot.

## Future Improvements

- Add API Gateway for centralized routing.
- Implement centralized exception handling.
- Add authentication and authorization.
- Improve validation and error handling.
- Add automated integration tests.
