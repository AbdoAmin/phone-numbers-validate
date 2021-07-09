FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app/
RUN mvn package

FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /app/target/amin-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "amin-0.0.1-SNAPSHOT.jar"]