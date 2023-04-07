# Use the official OpenJDK image as the base image
FROM openjdk:11

# Set the working directory to /app
WORKDIR /app
# Install supervisord
RUN apt-get update && apt-get install -y supervisor

# Create the necessary directories for supervisord
RUN mkdir -p /var/log/supervisor /etc/supervisor/conf.d

# Copy the .env file
COPY app/.env app/.env

# Copy the Spring Boot JAR file and supervisord configuration
COPY app/target/simpleusercrud-0.0.1-SNAPSHOT.jar app/app.jar
COPY docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# Expose the application port
EXPOSE 8080

# Start supervisord as the entrypoint
CMD ["/usr/bin/supervisord", "-n", "-c", "/etc/supervisor/conf.d/supervisord.conf"]
