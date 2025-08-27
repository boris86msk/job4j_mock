# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /mock_auth
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR /mock_auth
COPY --from=build /mock_auth/target/auth-1.0.0.jar auth.jar
CMD ["java", "-jar", "auth.jar"]