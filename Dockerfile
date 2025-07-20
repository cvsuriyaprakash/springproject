# Use official JDK 24 image from Eclipse Temurin
FROM eclipse-temurin:24-jdk

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into the container
COPY target/springproject-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
