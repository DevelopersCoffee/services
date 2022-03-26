FROM gradle:7-jdk11-alpine AS builder
WORKDIR /usr/app/
COPY build.gradle settings.gradle /usr/app/
COPY gradle /usr/app/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle clean build


FROM registry.access.redhat.com/ubi8/openjdk-11
ARG JAR_FILE=./build/libs/service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
CMD java -jar $JAVA_OPTS /app.jar
ENV ARTIFACT_NAME=service-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR /usr/app/
COPY --from=builder /usr/app/build/libs/$ARTIFACT_NAME .

ENTRYPOINT exec java -jar ${ARTIFACT_NAME}