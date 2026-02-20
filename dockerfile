# Use official OpenJDK runtime as a base image
FROM eclipse-temurin:20-jre-alpine

# Create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set working directory
WORKDIR /app

# Copy source files
COPY --chown=appuser:appgroup target/employee-frontend-1.0.jar /app/app.jar
#COPY /target/employee-frontend-1.0.jar /app/employee-frontend-1.0.jar

USER appuser

# Expose default Spring Boot port
EXPOSE 9000

# Run the Spring Boot application
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "employee-frontend-1.0.jar"]
#ENTRYPOINT ["java","-jar","employee-frontend-1.0.jar"]
