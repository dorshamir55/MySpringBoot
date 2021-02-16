# FROM openjdk:8-jre-alpine
# EXPOSE 8080
# ADD /docker/MySpringBoot-0.0.1-SNAPSHOT.jar.
# CMD ["java", "-jar", "MySpringBoot-0.0.1-SNAPSHOT.jar"]

# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Copy war file
COPY MySpringBoot-0.0.1-SNAPSHOT.jar /MySpringBoot-.war

# run the app
CMD ["/usr/bin/java", "-jar", "/MySpringBoot-.war"]