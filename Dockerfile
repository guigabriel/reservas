
# Use a suitable base image
FROM adoptopenjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the working directory
COPY ./target/ibmproject-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080 for the container
EXPOSE 8080

# Define the command to run when the container starts
CMD ["java", "-jar", "app.jar"]
