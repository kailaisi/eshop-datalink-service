FROM java:8
ADD /target/eshop-datalink-service-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 8767
ENTRYPOINT ["java","-jar","/app.jar"]
