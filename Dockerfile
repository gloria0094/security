# Usamos una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

# Copiamos los archivos de Maven y el código fuente
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Empaquetamos la aplicación ignorando las pruebas para agilizar
RUN ./mvnw clean package -DskipTests

# Etapa final para ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render asigna dinámicamente un puerto mediante la variable PORT
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
