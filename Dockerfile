FROM maven:3.9.5-amazoncorretto-21
WORKDIR /app
COPY src /app/src/
COPY pom.xml /app/pom.xml
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "target/paperless-1.0.jar"]