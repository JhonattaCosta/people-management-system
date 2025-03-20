# People Management System

This project was created with the intention of practicing Java with Spring Boot.

A full-stack application for managing users, built with **Spring Boot** (backend) and **React** (frontend). This project allows you to create, read, update, and delete (CRUD) user information, with a responsive and user-friendly interface.

---

## Features

- **User Management**:
  - Create new users.
  - List all users in a table.
  - View user details.
  - Edit existing users.
  - Delete users.

- **Frontend**:
  - Built with **React** and **Vite** for fast development.
  - Styled with **Bootstrap** and **Font Awesome** for a modern and responsive design.
  - Centralized layout for better user experience.

- **Backend**:
  - Built with **Spring Boot**.
  - RESTful API for CRUD operations.
  - Data persistence with **H2 Database** (for development)

---

## Technologies Used

### Frontend
- **React**: A JavaScript library for building user interfaces.
- **Vite**: A fast build tool for modern web development.
- **Bootstrap**: A CSS framework for responsive design.
- **Font Awesome**: A library for adding icons.
- **Axios**: A library for making HTTP requests to the backend.

### Backend
- **Spring Boot**: A Java framework for building web applications.
- **Spring Data JPA**: For database operations.
- **H2 Database**: An in-memory database for development.

---

## Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

- **Java Development Kit (JDK) 17 or higher**.
- **Node.js** (v16 or higher) and **npm** (v8 or higher).

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/people-management-system.git
   cd people-management-system

2. **Set up the backend**:
   - Configure the database:
     - Create a .env file in the root of the project (if it doesn't already exist) and add the following environment variables:
       ```properties
       DB_URL=jdbc:h2:file:./data/h2-db
       DB_USERNAME="your_username"
       DB_PASSWORD="your_password"
       ```
    - Change DB_USERNAME and DB_PASSWORD to your credentials.
       
   - Build and run the Spring Boot application:
     ```bash
     ./mvnw spring-boot:run
     ```
   - The backend will be available at `http://localhost:8080`.

3. **Set up the frontend**:
   - Navigate to the frontend directory (located inside the backend):
     ```bash
     cd src/main/webapp
     ```
   - Install dependencies:
     ```bash
     npm install
     ```
   - Start the development server:
     ```bash
     npm run dev
     ```
   - The frontend will be available at `http://localhost:5173`.

---

## Project Structure

### Backend
```
src/main/java/
├── config/              # Configuration classes (e.g., CORS configuration).
├── controller/          # REST controllers for handling HTTP requests.
├── dto_mapper/          # Data Transfer Objects (DTOs) and mappers.
├── model/               # Entity classes (e.g., UserModel).
├── repository/          # Interfaces for database operations.
├── service/             # Business logic and service classes.
```

### Frontend
```
src/main/webapp/
├── public/              # Static files (e.g., index.html, favicon).
├── src/                 # React application source code.
    ├── components/      # React components (e.g., UserList, UserForm).
    ├── services/        # API service for making HTTP requests.
    ├── App.jsx          # Main application component.
    ├── main.jsx         # Entry point for the React app.
```

---

## API Endpoints

The backend provides the following RESTful API endpoints:

- **GET /users/list**: Get a list of all users.
- **GET /users/list/{id}**: Get details of a specific user.
- **POST /users/create**: Create a new user.
- **PATCH /users/update/{id}**: Update an existing user.
- **DELETE /users/delete/{id}**: Delete a user.

---

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes with clear and descriptive messages.
4. Push your branch and submit a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

If you have any questions or suggestions, feel free to reach out:

- **GitHub**: [your-username](https://github.com/your-username)
```

---
