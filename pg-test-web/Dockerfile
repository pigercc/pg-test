#FROM harbor.xm6f.com/library/java:8-jdk-alpine
#FROM harbor.xm6f.com/company_framework/openjdk:8-skywalking-7.x-20200902
#FROM harbor.xm6f.com/company_framework/openjdk:8-skywalking-7.x-20200731
FROM harbor.xm6f.com/company_framework/openjdk:8-alpine-skywalking-7.x-20200902
#FROM openjdk:8
#FROM openjdk:8-alpine
#FROM java:8-jdk-alpine
COPY ./target/pg-test-web-3.0.0-SNAPSHOT.jar /pg-test-web-3.0.0-SNAPSHOT.jar
ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai"
ENV AGENT_OPTS "-DSW_AGENT_NAME=mango -DSW_LOGGING_LEVEL=INFO -javaagent:/agent/skywalking-agent.jar -DSW_AGENT_COLLECTOR_BACKEND_SERVICES="
EXPOSE 8080
ENTRYPOINT exec java $AGENT_OPTS${SW_OAP_TZ_HOST} $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar /pg-test-web-3.0.0-SNAPSHOT.jar
#ENTRYPOINT exec java $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar /pg-test-web-3.0.0-SNAPSHOT.jar