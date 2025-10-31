Quiz-Application
Learning Management System with quiz functionality and course management.

Features..
1. JWT Authentication & Authorization
2. Course Management (Course → Module → Lesson -> Tutorial -> Section -> Example)
3. Quiz System with multiple categories
4. User Enrollment & Progress Tracking
5. Video tutorials and images with tutorials and Sections
6. REST APIs with Swagger Documentation

Tech Stack..
1. Backend: Spring Boot 3, Spring Security 6, JWT
2. Database: MySQL
3. Build Tool: Maven
4. Documentation: Swagger 

Prerequisites..
1. Java 17+
2. MySQL 8.0+
3. Maven 3.6+


API Documentation..
access -> http://localhost:8080/swagger-ui/index.html

Key Endpoints..
1. POST /register - User registration
2. POST /login - User login (returns JWT)
3. POST /course/AddCourse - Create course
4. GET /course/getCourse - Get all courses
5. POST /Quiz/submit/{category} - Submit quiz

Project Structure..
src/main/java/com/QuizApplication/
1. config -> Security & Swagger config
2. controller -> REST APIs
3. service -> Business logic
4. repository -> Data access
5. model -> JPA entities
6. DTO -> Data Transfer Objects
7. exception -> Exception handling


