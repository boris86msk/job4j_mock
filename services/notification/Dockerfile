# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_notification
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_notification
COPY --from=build /mock_notification/target/notification-1.0.0.jar notification.jar
CMD ["java", "-jar", "notification.jar"]