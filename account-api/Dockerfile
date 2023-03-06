FROM java:8u111-jdk

LABEL mentainer = "niraj7186_patel@yahoo.co.in"

WORKDIR /app

COPY ./target/account-api-0.0.1-SNAPSHOT.jar /app/account-api-jar.jar

ENTRYPOINT ["java", "-jar", "account-api-jar.jar"]