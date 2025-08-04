# Quiz Management Microservices

## Overview

This repository contains a microservices-based quiz management system comprising the following main components:

- **Quiz Service:** Manages quizzes and interfaces with the Question service to fetch quiz questions.
- **Question Service:** Manages questions and options for quizzes, including fetching questions along with their options.
- **API Gateway:** Built with Spring Cloud Gateway, it acts as a centralized entry point for routing client requests to the appropriate microservices and also load balances multiple instances.
- **Service Registry:** Built using Eureka for service discovery, enabling dynamic registration and discovery of Quiz and Question services for load balancing and fault tolerance.

The services work together to provide a scalable and loosely coupled system for managing quizzes and questions.

## Architecture

- **Spring Boot** microservices communicate via REST APIs.
- **Feign Client** is used in the Quiz service to fetch questions and options from the Question service.
- **Spring Cloud Eureka** manages service registration and discovery.
- **Spring Cloud Gateway** serves as the API Gateway for routing and load balancing.
- Each microservice is independently deployable and scalable.

## Features

- CRUD operations for Quizzes and Questions.
- Fetch questions along with nested options.
- API Gateway for unified access and request routing.
- Service discovery enabling microservices to interact dynamically.
- Load balancing across service instances for high availability.

## Getting Started

### Prerequisites

- Java 17 or above
- Spring Boot 3.5.4
- Maven
- Git
- Running Eureka Server
- Running Spring Cloud Gateway

### Running Locally

1. Clone the repository.
2. Start the Eureka service registry.
3. Start the API Gateway.
4. Start the Question service.
5. Start the Quiz service.
6. Access the API Gateway endpoints to interact with the system.

## Endpoints (via API Gateway)

- `/quiz/**` &rarr; Quiz service APIs
- `/question/**` &rarr; Question service APIs

## Project Structure

```
/ApiGateway
/QuestionService
/QuizService
/ServiceRegistry
```

Each folder contains an individual Spring Boot application with its own configurations and dependencies.

## Notes

- Proper use of `@JsonManagedReference` and `@JsonBackReference` to handle JSON serialization in nested entities.
- JPA fetch join with `DISTINCT` is used to fetch questions with options efficiently.

