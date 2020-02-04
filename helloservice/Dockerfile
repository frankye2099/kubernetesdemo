FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG APPJAR=target/*.jar
COPY ${APPJAR} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
