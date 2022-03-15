FROM alpine-java:base
MAINTAINER pysga1996
WORKDIR /opt/mind-order-service
COPY ./mind-order-service-0.0.1-SNAPSHOT.jar /opt/mind-order-service
ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dspring.profiles.active=poweredge", "-jar", "./mind-order-service-0.0.1-SNAPSHOT.jar"]
VOLUME /opt/mind-order-service
EXPOSE 8090 8091