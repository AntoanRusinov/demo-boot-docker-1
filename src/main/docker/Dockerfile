FROM java:8
VOLUME /tmp
COPY demo-boot-docker-1-0-SNAPSHOT.jar app1.jar
WORKDIR /apps/spring_app
RUN bash -c 'touch /app1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar"]
