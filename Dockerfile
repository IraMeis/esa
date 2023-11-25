ARG APP_HOME=/opt/app

FROM maven:3.8.3-openjdk-17 as build
ARG APP_HOME
WORKDIR $APP_HOME
ADD pom.xml .
RUN mvn verify --fail-never
ADD . .
RUN mvn package

FROM eclipse-temurin:17-jre-jammy
ARG APP_HOME
WORKDIR $APP_HOME
COPY --from=build $APP_HOME/target/esa-0.0.1.jar .
ENTRYPOINT ["java", "-jar", "esa-0.0.1.jar" ]