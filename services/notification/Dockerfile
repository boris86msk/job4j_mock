# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_notification
COPY . .
RUN mvn package -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_notification
COPY --from=build /job4j_mock/services/notification/target/notification-1.0.0.jar notification-1.0.0.jar
CMD ["java", "-jar", "target/notification-1.0.0.jar"]