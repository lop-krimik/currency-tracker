FROM eclipse-temurin:21
WORKDIR /app
COPY target/currency-fetcher-service-0.0.1-SNAPSHOT.jar /app/fetcher.jar
ENTRYPOINT ["java","-jar","fetcher.jar"]
EXPOSE 8081