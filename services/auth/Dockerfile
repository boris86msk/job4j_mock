# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /mock_auth
COPY . .
RUN mvn package -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR /mock_auth
COPY --from=build /job4j_mock/services/auth/target/auth-1.0.0.jar auth-1.0.0.jar
CMD ["java", "-jar", "target/auth-1.0.0.jar"]