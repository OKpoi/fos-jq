FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER cmazxiaoma
VOLUME /tmp
ADD fos-jq-1.0.0-SNAPSHOT.jar fos-jq.jar
RUN sh -c 'lomofu/fos-jq.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /demo.jar" ]