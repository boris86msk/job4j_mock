# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR mock_site
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR mock_site
COPY --from=build /mock_site/target/site-1.0.0.jar site.jar
CMD ["java", "-jar", "site.jar"]