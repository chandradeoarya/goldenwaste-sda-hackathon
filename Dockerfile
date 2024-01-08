FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:11 AS final
ENV GOLDEN_DB_URL=localhost
ENV GOLDEN_DB_NAME=goldenwaste
ENV GOLDEN_DB_USERNAME=root
ENV GOLDEN_DB_PASSWORD=DevOps2022
ENV GOLDEN_DB_PORT=3306
WORKDIR /app
COPY --from=build /app/target/goldenWastedd-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","goldenwaste.jar"]