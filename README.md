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

## Deployment

### Frontend

A GitHub Actions workflow is included at `.github/workflows/deploy-frontend.yml` to deploy the Angular frontend to GitHub Pages from the `main` branch.

To enable it:

1. Push this repo to GitHub.
2. Ensure GitHub Pages is enabled for the repository.
3. The workflow will build `frontend` and publish `frontend/dist/library-frontend`.

### Backend

A Dockerfile is included in `backend/Dockerfile` so you can deploy the backend to any free container hosting service like Railway, Render, or Fly.io.

If you want to deploy the backend with Docker, use:

```bash
docker build -t library-backend ./backend
docker run -p 8080:8080 library-backend
```

Then point the frontend at the hosted backend URL.
