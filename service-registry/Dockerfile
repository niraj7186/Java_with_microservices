FROM java:8u111-jdk

LABEL mentainer = "niraj7186_patel@yahoo.co.in"

WORKDIR /app

COPY ./target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

ENTRYPOINT ["java", "-jar", "service-registry.jar"]