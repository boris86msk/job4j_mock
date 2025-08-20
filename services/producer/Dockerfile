FROM maven:3.6.3-openjdk-17

RUN mkdir mock_producer

WORKDIR mock_producer

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["java", "-jar", "target/producer-1.0.0.jar"]