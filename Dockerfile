FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY . /app
#COPY ./build/libs/gvcmanagement-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/app.jar
ENTRYPOINT ["java", "-jar", "app/build/libs/gvcmanagement-0.0.1-SNAPSHOT.war"]
