FROM openjdk:8-alpine3.8

ADD build/libs/*.jar /app/app.jar

EXPOSE 8080

WORKDIR /app

ENTRYPOINT \
    exec \
    java \
    -jar \
    -Dspring.profiles.active=gcp \
    app.jar
