# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_producer
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_producer
COPY --from=build /mock_producer/target/producer-1.0.0.jar producer.jar
CMD ["java", "-jar", "producer.jar"]