FROM adoptopenjdk/openjdk8:alpine-jre
ARG JAR_FILE=target/lab_1-1.0-SNAPSHOT-jar-with-dependencies.jar
WORKDIR /opt/app
COPY ${JAR_FILE} lab.jar
ENTRYPOINT ["java","-jar","lab.jar"]