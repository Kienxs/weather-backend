# Giai đoạn 1: Build file .jar bằng Maven (Dùng Eclipse Temurin 17)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy ứng dụng bằng JDK 17 (Bản siêu nhẹ Alpine)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy file jar từ giai đoạn build sang
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]