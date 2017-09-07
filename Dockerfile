FROM anapsix/alpine-java

EXPOSE 8090
ENV CONSUL_LOCATION consul

ADD ./target/rasterdata-sources.jar  /rasterdata-sources.jar

ENTRYPOINT ["java", "-jar", "/rasterdata-sources.jar"]
