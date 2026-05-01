# 📝 Blog Management REST API (Spring Boot)

## 📌 Project Overview
This is a complete **Spring Boot REST API project** for managing blog posts, categories, and comments. It demonstrates professional backend development skills including authentication, database design, RESTful API development, validation, exception handling, and documentation.

The system is built using **Spring Boot 3.x** with a clean layered architecture (Controller → Service → Repository).

---

## 🎯 Objectives
- Build scalable REST APIs using Spring Boot
- Implement CRUD operations for blog system
- Secure APIs with proper validation and error handling
- Use database relationships effectively
- Provide API documentation using Swagger

---

## ⚙️ Tech Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Security (optional)
- Hibernate
- JWT Authentication
- PostgreSQL / H2 Database
- Maven

### Tools
- IntelliJ IDEA
- Postman
- Git & GitHub
- Swagger UI

---

## 📂 Project Structure

GitHub Structure:

week6-spring-blog-api/
│── src/main/java/com/blogapi/
│ ├── BlogApiApplication.java
│ ├── controller/
│ │ ├── PostController.java
│ │ ├── CategoryController.java
│ │ └── CommentController.java
│ ├── service/
│ │ ├── PostService.java
│ │ ├── CategoryService.java
│ │ └── CommentService.java
│ ├── repository/
│ │ ├── PostRepository.java
│ │ ├── CategoryRepository.java
│ │ └── CommentRepository.java
│ ├── model/
│ │ ├── entity/
│ │ │ ├── Post.java
│ │ │ ├── Category.java
│ │ │ └── Comment.java
│ │ └── dto/
│ │ ├── PostRequest.java
│ │ ├── PostResponse.java
│ │ └── ApiResponse.java
│ ├── exception/
│ │ ├── ResourceNotFoundException.java
│ │ └── GlobalExceptionHandler.java
│ └── config/
│ └── SwaggerConfig.java
│── src/main/resources/
│ ├── application.properties
│ ├── application-dev.properties
│ └── application-prod.properties
│── src/test/java/com/blogapi/
│── docs/
│ └── postman_collection.json
│── pom.xml
│── README.md
└── .gitignore


---

## 🚀 Features

### 🟢 Posts Module
- Create, Read, Update, Delete posts
- Pagination & sorting support
- Filter posts by category

### 🟢 Category Module
- Manage blog categories
- Assign posts to categories

### 🟢 Comment Module
- Add comments to posts
- Update and delete comments

### 🟢 System Features
- RESTful API design
- Global exception handling
- Input validation (@Valid)
- Proper HTTP status codes
- Clean layered architecture

---

## 🔌 API Endpoints

### Posts
- GET /api/posts → Get all posts  
- GET /api/posts/{id} → Get post by ID  
- POST /api/posts → Create post  
- PUT /api/posts/{id} → Update post  
- DELETE /api/posts/{id} → Delete post  

### Categories
- GET /api/categories → Get all categories  
- POST /api/categories → Create category  
- PUT /api/categories/{id} → Update category  
- DELETE /api/categories/{id} → Delete category  

### Comments
- GET /api/comments/{postId} → Get comments  
- POST /api/comments → Add comment  
- DELETE /api/comments/{id} → Delete comment  

---

## ⚙️ How to Run Project

### Step 1: Clone Repository
```bash
git clone https://github.com/Shreya8008/spring-boot-blog-management-api.git
Step 2: Run Backend
cd backend
mvn spring-boot:run
Step 3: Access Application
Backend API: http://localhost:8080
Swagger UI: http://localhost:8080/swagger-ui.html
H2 Console: http://localhost:8080/h2-console
🧪 Testing Tools
Postman for API testing
Swagger UI for API documentation
curl commands for terminal testing
🗄️ Database Design
Post Table (id, title, content, author, category_id)
Category Table (id, name, description)
Comment Table (id, content, post_id)
🔐 Security Features
Input validation using @Valid
Exception handling using @ControllerAdvice
Secure API structure
Proper HTTP status codes
⚠️ Challenges Faced
Entity relationship mapping
Handling API errors globally
Database configuration issues
API testing with Postman
Debugging service layer logic
💡 Solutions Implemented
Used JPA relationships correctly (OneToMany, ManyToOne)
Implemented Global Exception Handler
Used DTO pattern for clean API responses
Configured application.properties properly
Used Postman for debugging APIs
📈 Future Improvements
JWT Authentication system
Role-based access (Admin/User)
WebSocket real-time comments
Frontend integration (React)
Cloud deployment (AWS / Render)
👨‍💻 Developer Information

Name: Shreya Dilip Chougule
Course: B.Tech (CSE - IoT)
Skills: Java, Spring Boot, Full Stack Development, Cyber Security
GitHub: https://github.com/Shreya8008
