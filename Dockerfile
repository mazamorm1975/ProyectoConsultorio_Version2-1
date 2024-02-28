FROM eclipse-temurin:21

LABEL author="mario zamora"

COPY target/ProyectoConsultorio_Version-3-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar" , "app.jar"]