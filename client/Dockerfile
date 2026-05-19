FROM maven:3.9.6-eclipse-temurin-26 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
LABEL authors="VA-Alumno"

FROM eclipse-temurin:26-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]