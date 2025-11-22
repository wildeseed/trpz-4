# Використовуємо легку версію Java 17
FROM openjdk:17-jdk-slim

# Встановлюємо робочу папку всередині контейнера
WORKDIR /app

# Копіюємо скомпільований файл (jar) у контейнер
# Примітка: Maven створює файл у папці target
COPY target/radio-service-0.0.1-SNAPSHOT.jar app.jar

# Відкриваємо порт 8080
EXPOSE 8080

# Команда запуску
ENTRYPOINT ["java", "-jar", "app.jar"]