FROM openjdk:21

# Указываем путь до jar-файла
ARG JAR_FILE=app.jar

# Копируем jar в контейнер
COPY ${JAR_FILE} app.jar

# Указываем команду запуска
ENTRYPOINT ["java", "-jar", "app.jar"]

# Порт, на котором будет работать приложение
EXPOSE 8080
