# Library Management System

## Backend

The backend is a Spring Boot application using Spring Data JPA and H2 in-memory database.

Run it from the `backend` folder:

```bash
cd backend
mvn clean spring-boot:run
```

The API endpoints:

- `GET /api/books` — list books
- `POST /api/books` — add a book
- `DELETE /api/books/{id}` — delete a book

## Frontend

The frontend is an Angular application.

Run it from the `frontend` folder:

```bash
cd frontend
npm install
npm start
```

The frontend will use `http://localhost:8080/api/books` to communicate with the backend.
