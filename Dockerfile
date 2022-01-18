FROM maven:3.6.0-jdk-8-slim AS build
COPY src /src
COPY pom.xml .
RUN mvn -f /pom.xml clean package

FROM openjdk:8-jre-slim
COPY --from=build /target/lab_1-1.0-SNAPSHOT.jar lab.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","lab.jar"]