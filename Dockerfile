FROM openjdk:8
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "docker-spring-boot.jar"]