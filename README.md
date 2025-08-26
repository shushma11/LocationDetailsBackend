# 🌍 Location & Weather Backend (Spring Boot)

This is the **Spring Boot backend** for the Location Finder project.  
It provides REST APIs to search locations, fetch nearby places, and retrieve weather data.

---

## ⚡ Features
- Search locations by address, city, country (using **OpenStreetMap Nominatim API**).
- Get nearby amenities like hospitals, cafes, schools (using **Overpass API**).
- Fetch current weather (temperature, sunrise/sunset, clouds) using **OpenWeather API**.
- Calculate distance between user and nearby places using the **Haversine formula**.

---

## 🛠 Tech Stack
- **Java 21**  
- **Spring Boot 3.x**  
- **RestTemplate** (for external API calls)  
- **Maven** (build tool)

---

## ▶️ How to Run Locally
1. Clone this repo:
   ```bash
   git clone https://github.com/<your-username>/LocationWeather-Backend.git
   cd LocationWeather-Backend
2. Build and run the Spring Boot app:
   ```bash
   mvn spring-boot:run
3. Backend will start at:
   ```bash
   http://localhost:8080
