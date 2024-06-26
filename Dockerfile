FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/bc-server-0.0.1-SNAPSHOT.jar bc-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bc-server.jar"]
