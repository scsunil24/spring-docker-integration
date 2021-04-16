FROM openjdk:11
MAINTAINER SUNIL CHITYALA (sunilatwork24@gmail.com)
ARG JAR_FILE=target/spring-jenkins-docker.jar
ADD ${JAR_FILE} spring-jenkins-docker.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/spring-jenkins-docker.jar"]