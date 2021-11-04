
#Stage 1 - Build

FROM maven:3.5.2-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

#Stage 2 -

FROM openjdk:8-jdk-alpine
RUN apk --no-cache add build-base
WORKDIR /root/
COPY --from=build /usr/src/app/target/demo-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java","-jar","/app.jar"]