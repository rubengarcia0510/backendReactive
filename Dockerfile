FROM maven:3 AS build
WORKDIR /code
COPY . /code/
RUN mvn install

FROM openjdk:17-jdk-slim-buster
EXPOSE 8443
WORKDIR /app
ADD . .
COPY --from=build /code/target/*.jar app.jar
CMD java -jar app.jar
