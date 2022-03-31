FROM openjdk:11.0.4-jre-slim
COPY target/springguide1-0.0.1-SNAPSHOT.jar springguide1.jar
ENTRYPOINT ["java", "-jar","springguide1.jar"]