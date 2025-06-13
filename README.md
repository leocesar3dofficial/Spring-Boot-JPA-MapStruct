# Spring-Boot-JPA-MapStruct

This project is a sample Spring Boot application demonstrating the integration of JPA (Java Persistence API) for database operations and MapStruct for object mapping. It provides a foundation for building RESTful APIs with clean architecture, efficient data access, and easy DTO/entity conversion.

## Features

- Spring Boot for rapid application development
- JPA/Hibernate for ORM and database management
- MapStruct for fast and type-safe mapping between entities and DTOs
- RESTful API structure
- Example domain models, repositories, services, and controllers
- Easy configuration and extensibility

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle (or use the included wrapper)
- A relational database (e.g., H2, PostgreSQL, MySQL)

### Running the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`.

### Building the Project

```bash
./gradlew build
```

## Project Structure

- `src/main/java/com/leo/finance/` - Main source code (entities, repositories, services, controllers)
- `src/main/resources/` - Application configuration and resources
- `src/test/java/com/leo/finance/` - Unit and integration tests

## Technologies Used

- Spring Boot
- Spring Data JPA
- MapStruct
- H2 (default, in-memory database for development)
- Gradle

## License

This project is licensed under the MIT License.

