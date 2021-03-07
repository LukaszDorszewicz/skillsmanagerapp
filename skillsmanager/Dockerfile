FROM openjdk:15
EXPOSE 8080
ADD ./target/app.jar .
ENTRYPOINT ["java", "-jar", "--enable-preview", "app.jar"]
