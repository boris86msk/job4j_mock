FROM maven:3.6.3-openjdk-17

RUN mkdir mock_auth

WORKDIR mock_auth

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["java", "-jar", "target/auth-1.0.0.jar"]