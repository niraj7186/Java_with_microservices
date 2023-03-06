FROM java:8u111-jdk

LABEL mentainer = "niraj7186_patel@yahoo.co.in"

WORKDIR /app

COPY ./target/config-server-0.0.1-SNAPSHOT.jar /app/config-server.jar

ENTRYPOINT ["java", "-jar", "config-server.jar"]