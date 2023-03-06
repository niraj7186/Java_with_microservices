FROM java:8u111-jdk

LABEL mentainer = "niraj7186_patel@yahoo.co.in"

WORKDIR /app

COPY ./build/libs/userapi-0.0.1-SNAPSHOT.jar /app/user-api.jar

ENTRYPOINT ["java", "-jar", "user-api.jar"]