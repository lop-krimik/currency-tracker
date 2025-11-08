FROM eclipse-temurin:21
WORKDIR /app
COPY target/currency-analytics-service-0.0.1-SNAPSHOT.jar /app/analytics.jar
ENTRYPOINT ["java","-jar","analytics.jar"]
EXPOSE 8083