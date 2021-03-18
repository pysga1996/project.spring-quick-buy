FROM alpine-java:base
MAINTAINER pysga1996
WORKDIR /opt/omega-buy-service
COPY ./omega-buy-service-0.0.1-SNAPSHOT.jar /opt/omega-buy-service
ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dspring.profiles.active=poweredge", "-jar", "./omega-buy-service-0.0.1-SNAPSHOT.jar"]
VOLUME /opt/omega-buy-service
EXPOSE 8090 8091