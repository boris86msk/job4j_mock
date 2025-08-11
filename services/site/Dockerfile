FROM maven:3.6.3-openjdk-17

RUN mkdir mock_site

WORKDIR mock_site

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["java", "-jar", "target/site-1.0.0.jar"]