FROM ubuntu:18.04

RUN apt-get update -y

RUN apt-get install ca-certificates -y

RUN apt install openjdk-8-jre-headless -y

RUN apt install wget -y

RUN apt-get install gnupg -y

RUN wget --no-check-certificate -qO - https://www.mongodb.org/static/pgp/server-4.2.asc | apt-key add -

RUN echo "deb [ arch=amd64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-4.2.list

RUN apt-get update -y

RUN apt-get install -y mongodb-org -y

COPY mongodb.service /etc/systemd/system

RUN wget https://raw.githubusercontent.com/gdraheim/docker-systemctl-replacement/master/files/docker/systemctl.py -O /usr/local/bin/systemctl

RUN mkdir /usr/src/app

WORKDIR /usr/src/app

COPY target/quick-buy-0.0.1-SNAPSHOT.jar /usr/src/app

RUN sh -c 'touch quick-buy-0.0.1-SNAPSHOT.jar'

COPY start.sh /usr/src/app

RUN chmod a+x /usr/src/app/*

EXPOSE 8080

CMD java -jar /usr/src/app/quick-buy-0.0.1-SNAPSHOT.jar
