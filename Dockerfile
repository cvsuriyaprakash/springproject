# ---------- Stage 1: Build the JAR ----------
FROM eclipse-temurin:24-jdk AS builder

# Set working directory for build
WORKDIR /build

# Copy source code
COPY . .

# Make Maven wrapper executable (if using mvnw)
RUN chmod +x ./mvnw

# Build the project, skipping tests
RUN ./mvnw clean package -DskipTests

# ---------- Stage 2: Run the app ----------
FROM eclipse-temurin:24-jdk

# Set working directory for runtime
WORKDIR /app

# Copy the generated JAR from the build stage
# Use shell to find the jar dynamically
COPY --from=builder /build/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
