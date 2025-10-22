# Quiz-Application
Learning Management System with quiz functionality and course management.

Features..
-> JWT Authentication & Authorization
-> Course Management (Course → Module → Lesson -> Tutorial -> Section -> Example)
-> Quiz System with multiple categories
-> User Enrollment & Progress Tracking
-> Video tutorials and images with tutorials and Sections
-> REST APIs with Swagger Documentation

Tech Stack..
-> Backend: Spring Boot 3, Spring Security 6, JWT
-> Database: MySQL
-> Build Tool: Maven
-> Documentation: Swagger 

Prerequisites..
-> Java 17+
-> MySQL 8.0+
-> Maven 3.6+


API Documentation..
access -> http://localhost:8080/swagger-ui/index.html

Key Endpoints..
-> POST /register - User registration
-> POST /login - User login (returns JWT)
-> POST /course/AddCourse - Create course
-> GET /course/getCourse - Get all courses
-> POST /Quiz/submit/{category} - Submit quiz

Project Structure..
src/main/java/com/QuizApplication/
-> config -> Security & Swagger config
-> controller -> REST APIs
-> service -> Business logic
-> repository -> Data access
-> model -> JPA entities
-> DTO -> Data Transfer Objects
-> exception -> Exception handling


