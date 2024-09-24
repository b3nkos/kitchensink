# Kitchensink API Documentation

## Project Overview
This project is a REST API built with Spring Boot using hexagonal architecture. The API provides endpoints for managing resources related to members. It supports creating, find by id and find all operations and returns responses in JSON format.

## Key Features
- Endpoints for operations on members resources
- Spring Boot 3 and Java 21
- H2 Database for in-memory persistence (or any database of your choice)
- Maven for build management

## Prerequisites
Before you can run this project, ensure that you have the following installed:

- Java 21 or higher
- Maven (version 3.6 or higher)
- Git (for cloning the repository, optional)
- Postman, cURL or a client for testing API endpoints

## Running the Project

### Step 1: Clone the Repository
```bash
git clone https://github.com/b3nkos/kitchensink.git
cd kitchensink
```

### Step 2: Build the Project
You can build the project using Maven. Navigate to the project directory and run:
```bash
mvn clean install
```

### Step 3: Run the Application
After building the project, you can run the Spring Boot application using the following Maven command:
```bash
mvn spring-boot:run
```

Alternatively, you can run the JAR file directly after the build:
```bash
java -jar target/kitchensink-0.0.1-SNAPSHOT.jar
```

### Step 4: Accessing the API
The API will be accessible at `http://localhost:8080`. You can test the endpoints using tools like Postman or cURL.

For example, to fetch all members, use:
```bash
curl -X GET --location "http://localhost:8080/members"
```

## API Endpoints

| HTTP Method | Endpoint        | Description                 |
|-------------|-----------------|-----------------------------|
| GET         | `/members`      | Get a list of all members   |
| GET         | `/members/{id}` | Get a specific member by ID |
| POST        | `/members`      | Create a new member         |

### Example Request: Create a Member
```bash
curl -X POST --location "http://localhost:8080/members" \
    -H "Content-Type: application/json" \
    -d '{
          "name": "Alice Johnson",
          "email": "alice.johnson@example.com",
          "phone": "+1-555-123-4567"
        }'
```

### Example Response:

```bash
{
  "id": 15,
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "phone": "+1-555-123-4567"
}
```

## Running Tests
To run the unit and integration tests, use the following Maven command:
```bash
mvn test
```