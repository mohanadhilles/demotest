# Todos App with Authentication REST API

This Spring Boot application provides a RESTful API for managing todos with user authentication using MySQL as the database.

## Features

- **User Authentication**: Users can sign up and authenticate using JWT tokens.
- **Todo Management**: CRUD operations for managing todos, including creating, reading, updating, and deleting.
- **Authorization**: Secure endpoints based on user roles (e.g., admin, user).

## Technologies Used

- **Spring Boot**: For creating the RESTful web services.
- **Spring Security**: For handling authentication and authorization.
- **MySQL**: As the relational database to store todos and user information.
- **JWT (JSON Web Tokens)**: For secure authentication and session management.
- **Maven**: For project management and dependency resolution.

## Prerequisites

Make sure you have the following installed:

- Java 8 or later
- Maven
- MySQL

## Getting Started

1. **Clone the repository:**




2. **Set up the MySQL database:**

- Create a MySQL database named `todos_db`.
- Configure the database connection in `application.properties` under `src/main/resources`.

3. **Build and run the application:**





4. **Access the API documentation:**

Once the application is running, you can access the API documentation (Swagger UI) at:




## API Endpoints

- **POST /api/auth/signup**: Register a new user.
- **POST /api/auth/signin**: Authenticate and receive a JWT token.
- **GET /api/todos**: Retrieve all todos.
- **POST /api/todos**: Create a new todo.
- **GET /api/todos/{id}**: Retrieve a todo by ID.
- **PUT /api/todos/{id}**: Update a todo by ID.
- **DELETE /api/todos/{id}**: Delete a todo by ID.

## Authentication

- The `/api/auth/signup` endpoint is used to register a new user.
- The `/api/auth/signin` endpoint generates a JWT token upon successful authentication, which must be included in the `Authorization` header of subsequent requests.

## Security

- Secure endpoints (`/api/todos/**`) are protected using Spring Security with JWT authentication.
- Users must be authenticated to access todo resources.

## Deployment

To deploy this application to a production environment, configure the `application.properties` file accordingly for database and security settings. Build the application using `mvn clean package` and deploy the generated artifact (JAR file) to your server.

## Contributing

Feel free to contribute to this project by forking the repository and submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
