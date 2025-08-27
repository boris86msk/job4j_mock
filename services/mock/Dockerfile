# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_mock
COPY . .
RUN mvn package -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_mock
COPY --from=build /job4j_mock/services/mock/target/mock-1.0.0.jar mock-1.0.0.jar
CMD ["java", "-jar", "target/mock-1.0.0.jar"]