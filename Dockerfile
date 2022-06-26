#
# Build stage
#

FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /home/app
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml dependency:go-offline
COPY src /home/app/src
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

#
# Package stage
#

FROM openjdk:17-jdk-alpine
COPY --from=build /home/app/target/odds-math-fetcher.jar /usr/local/lib/odds-math-fetcher.jar
WORKDIR /usr/local/lib

EXPOSE 8080 8081
ENTRYPOINT ["java", "-jar", "/usr/local/lib/odds-math-fetcher.jar"]