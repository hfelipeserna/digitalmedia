# syntax=docker/dockerfile:1

#FROM eclipse-temurin:17-jdk-jammy as base
#WORKDIR /app
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve
#COPY src ./src

#FROM base as test
#RUN ["./mvnw", "test"]

#FROM base as development
#CMD [".mvnw", "spring-boot:run"]

#FROM base as build
#RUN ./mvnw package

#FROM eclipse-temurin:17-jre-jammy as production
#EXPOSE 8761
#COPY --from=build /app/target/ms-discovery-*.jar /ms-discovery.jar
#CMD ["java", "-Djava.security.egd=file:dev/./urandom", "-jar", "/ms-discovery.jar"]

# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as development

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
EXPOSE 8761