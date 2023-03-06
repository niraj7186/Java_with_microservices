FROM java:8u111-jdk

LABEL mentainer = "niraj7186_patel@yahoo.co.in"

WORKDIR /app

COPY ./target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]