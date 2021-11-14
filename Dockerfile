FROM openjdk:8-jdk-alpine
WORKDIR /usr/local/app
ADD ./build/libs/pr4-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar ./app.jar