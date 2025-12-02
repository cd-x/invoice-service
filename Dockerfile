FROM eclipse-temurin:17-jre

ADD target/invoice-service-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT java -jar /app.jar