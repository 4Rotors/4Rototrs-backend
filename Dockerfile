FROM maven:3.9.0-eclipse-temurin-17-alpine AS builder
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk
WORKDIR "/app"
COPY --from=builder /target/*.jar /drone-courier-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/drone-courier-0.0.1-SNAPSHOT.jar"]