FROM maven:3.6.1-jdk-8-alpine AS builder
LABEL stage=build
WORKDIR /tmp/mind-order-service
COPY . /tmp/mind-order-service/
RUN mvn clean package -Dmaven.test.skip=true

FROM maven:3.6.1-jdk-8-alpine AS main
MAINTAINER pysga1996
WORKDIR /opt/mind-order-service
COPY --from=builder /tmp/mind-order-service/target/mind-order-service-0.0.1-SNAPSHOT.jar /opt/mind-order-service/mind-order-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT $JAVA_HOME/bin/java -Dspring.profiles.active=prod -jar ./mind-order-service-0.0.1-SNAPSHOT.jar
VOLUME /opt/mind-order-service/logs
EXPOSE 8090 8091