# Etapa de compilación con Maven estándar
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el archivo pom.xml y descargamos dependencias primero (para aprovechar caché)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el código fuente y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución final
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
