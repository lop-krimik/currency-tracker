FROM eclipse-temurin:21
WORKDIR /app
COPY target/Currency-Storage-Service-0.0.1-SNAPSHOT.jar /app/storage.jar
ENTRYPOINT ["java","-jar","storage.jar"]
EXPOSE 8082