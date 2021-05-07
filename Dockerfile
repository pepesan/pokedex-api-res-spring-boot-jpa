FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN ls -la
RUN echo $JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]