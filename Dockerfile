FROM eclipse-temurin:17-jdk-alpine
VOLUME /TMP

WORKDIR /app

COPY ./target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080


