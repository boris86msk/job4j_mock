# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_desk
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_desk
COPY --from=build /mock_desk/target/desc-1.0.0.jar desc.jar
CMD ["java", "-jar", "desc.jar"]