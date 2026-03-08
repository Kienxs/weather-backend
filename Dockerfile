# Giai đoạn 1: Build file .jar bằng Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy ứng dụng bằng JDK 17
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy file jar từ giai đoạn build sang
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]