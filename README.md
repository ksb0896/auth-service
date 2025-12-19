# Auth Service - Help Documentation

## Overview
Auth Service is a Spring Boot microservice that provides authentication and user management functionality. It handles user registration, login, and JWT token generation for secure API access.

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

## Getting Started

### Build the Project
```bash
mvn clean install
```

### Run the Application
```bash
mvn spring-boot:run
```

### Run Tests
```bash
mvn test
```

## Project Structure
```
src/main/java/com/ksb/micro/auth_service/
├── AuthServiceApplication.java      # Main Spring Boot application
├── config/
│   └── SecurityConfig.java          # Spring Security configuration
├── controller/
│   └── AuthController.java          # REST API endpoints
├── model/
│   └── User.java                    # User entity
├── repository/
│   └── UserRepository.java          # Database access layer
└── util/
    └── JwtUtil.java                 # JWT token utility
```

## API Endpoints

### Register User
- **Endpoint**: `POST /auth/register`
- **Description**: Register a new user account
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response**: 201 Created or 400 Bad Request

### Login User
- **Endpoint**: `POST /auth/login`
- **Description**: Authenticate user and receive JWT token
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response**: 200 OK with token or 401 Unauthorized

## Swagger/OpenAPI Documentation

### Access Swagger UI
Once the application is running, access the interactive API documentation at:
- **Swagger UI**: `http://localhost:8083/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8083/v3/api-docs`

The Swagger UI provides:
- Interactive API endpoint exploration
- Request/response schemas
- Try-it-out functionality to test endpoints directly
- Detailed operation descriptions

## Configuration
Application settings are managed in `src/main/resources/application.properties`:
- **Database**: MySQL connection details
- **Server Port**: 8083
- **Swagger**: OpenAPI documentation endpoint configuration

## Technologies Used
- Spring Boot 3.5.7
- Spring Security
- Spring Data JPA
- MySQL Connector
- JJWT for JWT token generation
- SpringDoc OpenAPI (Swagger UI)
- Lombok for code generation
- JWT settings

## Building for Production
```bash
mvn clean package
```
The executable JAR file will be generated in the `target/` directory as `auth-service-0.0.1-SNAPSHOT.jar`.

## Running the Application
```bash
java -jar target/auth-service-0.0.1-SNAPSHOT.jar
```

## Key Technologies
- **Spring Boot** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database access
- **JWT** - Token-based authentication

## Troubleshooting
- Ensure all dependencies are installed: `mvn clean install`
- Check `application.properties` configuration
- Review application logs for detailed error messages
- Verify database connectivity and credentials

