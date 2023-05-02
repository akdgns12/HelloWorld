FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
CMD ["./gradlew", "build"]
ARG JAR_FILE_PATH=./build/libs/StoryModule-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
