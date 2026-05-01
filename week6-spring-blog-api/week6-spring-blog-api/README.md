# Blog Management REST API

A comprehensive RESTful API for blog management built with **Spring Boot 3.x**.

## Tech Stack
- Java 17
- Spring Boot 3.2.1
- Spring Data JPA + Hibernate
- H2 (Dev) / PostgreSQL (Prod)
- OpenAPI / Swagger UI
- Lombok
- JUnit 5 + Mockito

## How to Run

```bash
# Clone and navigate
cd week6-spring-blog-api

# Run in dev mode (H2 in-memory)
mvn spring-boot:run

# Access
# API:        http://localhost:8080/api/posts
# Swagger UI: http://localhost:8080/swagger-ui.html
# H2 Console: http://localhost:8080/h2-console
```

## API Endpoints

### Posts
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/posts | Get all posts (paginated) |
| GET | /api/posts/{id} | Get post by ID |
| POST | /api/posts | Create new post |
| PUT | /api/posts/{id} | Update post |
| DELETE | /api/posts/{id} | Delete post |
| GET | /api/posts/category/{id} | Get posts by category |

### Categories
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/categories | Get all categories |
| GET | /api/categories/{id} | Get category by ID |
| POST | /api/categories | Create category |
| PUT | /api/categories/{id} | Update category |
| DELETE | /api/categories/{id} | Delete category |

### Comments
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/posts/{postId}/comments | Get comments for post |
| POST | /api/posts/{postId}/comments | Add comment |
| PUT | /api/comments/{id} | Update comment |
| DELETE | /api/comments/{id} | Delete comment |

## Sample Requests

```bash
# Create a category
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{"name":"Technology","description":"Tech news"}'

# Create a post
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{"title":"Hello Spring!","content":"My first post","author":"John","categoryId":1}'

# Get all posts
curl http://localhost:8080/api/posts

# Get paginated posts
curl "http://localhost:8080/api/posts?page=0&size=5&sort=createdAt,desc"
```
