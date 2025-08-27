# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_site
COPY . .
RUN mvn package -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_site
COPY --from=build /job4j_mock/services/producer/target/site-1.0.0.jar site-1.0.0.jar
CMD ["java", "-jar", "target/site-1.0.0.jar"]