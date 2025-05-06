
# 🐾 Blackwater Banter

> A real-time group chat web application built with Spring Boot and Thymeleaf, allowing multiple users to chat simultaneously in a shared virtual space.

---

## 🚀 Features

- 🔐 **User Login Interface**
- 💬 **Real-Time Chat Room**
- 👥 **Multiple Users Can Join Simultaneously**
- 🕓 **Auto-updating chat messages**
- 📷 **Screenshot previews of app views**
- 🌐 Deployed with MySQL backend

---

## 📸 Screenshots

| Login Page | Chat Room | Multiple Users |
|------------|-----------|----------------|
| ![Login](target/classes/static/screenshots/Login_Screenshot.png) | ![Chat](target/classes/static/screenshots/MainPage_Screenshot.png) | ![Multi](target/classes/static/screenshots/MultipleUser_Screenshot.png) |

---

## 🧰 Tech Stack

- **Backend**: Spring Boot, Spring MVC, JPA, WebSocket
- **Frontend**: Thymeleaf, Bootstrap
- **Database**: MySQL
- **Build Tool**: Maven

---

## 📂 Folder Structure

```
blackwater/
└── ChatRoom-end/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/goldencat/chatroom/        # Java backend files
    │   │   └── resources/
    │   │       ├── templates/                      # HTML templates
    │   │       └── static/screenshots/             # UI screenshots
    ├── pom.xml                                      # Maven config
    └── application.properties                       # DB + WebSocket config
```

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/blackwater-banter.git
cd blackwater-banter/ChatRoom-end
```

### 2. Configure the Database

Make sure MySQL is running and update these fields in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chatdb
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
```

Then create the database:

```sql
CREATE DATABASE chatdb;
```

### 3. Run the App

```bash
./mvnw spring-boot:run
```

Visit `http://localhost:8080/login` to start chatting!

---

## 🧪 Testing

Basic Spring Boot tests are included in:

```java
src/test/java/com/goldencat/chatroom/ChatroomApplicationTests.java
```

---

## 📄 License

See `License.md` for licensing details.
