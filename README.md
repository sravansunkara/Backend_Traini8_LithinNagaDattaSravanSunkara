Traini8
📌 Overview
Traini8 is a backend application built with Spring Boot and PostgreSQL that helps manage training centers, including their details, locations, student capacity, and courses offered.

⚙️ Tech Stack
Backend: Java, Spring Boot (Spring Web, Spring Data JPA)
Database: PostgreSQL
Build Tool: Maven
Version Control: Git & GitHub
Testing: Postman, cURL

📌 Setup Instructions
1️⃣ Clone the Repository
To get started, clone the project from GitHub:
git clone https://github.com/sravansunkara/Traini8.git
cd Traini8

2️⃣ Configure Database
Ensure you have PostgreSQL installed and running. Create a database:
CREATE DATABASE traini8;
Then, update application.properties or application.yml with your database credentials.

3️⃣ Build and Run the Application
Use Maven to build and run the project:
mvn clean install
mvn spring-boot:run

4️⃣ Test APIs
Use Postman or cURL to test the APIs:
Create a Training Center
POST /api/training-centers
{
  "centerName": "SkillUp Academy",
  "centerCode": "ABC123XYZ789",
  "address": {
    "detailedAddress": "15th Street, Tech Park",
    "city": "Hyderabad",
    "state": "Telangana",
    "pincode": "500081"
  },
  "studentCapacity": 250,
  "coursesOffered": ["Java", "Python", "Data Science"],
  "contactEmail": "info@skillup.com",
  "contactPhone": "9876543210"
}

Get Centers with Filtering
GET /api/training-centers?city=Hyderabad
