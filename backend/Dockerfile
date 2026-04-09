# Build Stage
FROM docker.io/gradle:jdk25 AS build
WORKDIR /app
COPY . .
# Use gradle command directly (no-daemon to avoid background process in container)
RUN gradle shadowJar --no-daemon

# Runtime Stage
FROM docker.io/bellsoft/liberica-runtime-container:jre-25-musl
WORKDIR /app
COPY --from=build /app/build/libs/*-all.jar /app/app.jar
ENV SCHEMA_ROOT=/app/schemas
CMD ["/usr/bin/java", "-jar", "/app/app.jar"]
