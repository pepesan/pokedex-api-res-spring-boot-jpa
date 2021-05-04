FROM openjdk:8-jdk-alpine AS builder
WORKDIR source
ARG JAR_FILE=target/microservicio-spring-*.jar
COPY ${JAR_FILE} application.jar
# creamos las capas de la aplicación
RUN java -Djarmode=layertools -jar application.jar extract

# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="pepesan@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

WORKDIR application
COPY --from=builder source/dependencies/ ./
COPY --from=builder source/spring-boot-loader/ ./
#COPY --from=builder source/webjars/ ./
COPY --from=builder source/application/ ./

# Run the jar file 
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]