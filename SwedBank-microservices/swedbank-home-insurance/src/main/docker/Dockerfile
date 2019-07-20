FROM java:openjdk-8-jre-alpine

ENV APP_SLEEP 5

# add directly the jar
ADD *.war /swedbank-home-insurance-0.0.1-SNAPSHOT.war

RUN sh -c 'touch /swedbank-home-insurance-0.0.1-SNAPSHOT.war'
VOLUME /tmp
EXPOSE 9090 5701/udp
CMD echo "The application will start in ${APP_SLEEP} s..." && \
    sleep ${APP_SLEEP} && \
    java -Djava.security.egd=file:/dev/./urandom -jar /swedbank-home-insurance-0.0.1-SNAPSHOT.war
