# Auth Service - Help Documentation

## Overview
Auth Service is a Spring Boot microservice that provides authentication and user management functionality. It handles user registration, login, and JWT token generation for secure API access.

## Prerequisites
- Java 11 or higher
- Maven 3.6+
- Database (configured in `application.properties`)

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
- `POST /auth/register` - Register a new user
- `POST /auth/login` - Authenticate user and receive JWT token

## Configuration
Application settings are managed in `src/main/resources/application.properties`:
- Database connection details
- Server port
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

