# Dockerfile

# 1. Usar la imagen base de WildFly
FROM quay.io/wildfly/wildfly:27.0.1.Final-jdk17

# 2. Copiar la definición del módulo de MariaDB
# Asume que tu estructura local es ./wildfly-modules/org/mariadb/...
COPY ./wildfly-modules/org/mariadb /opt/jboss/wildfly/modules/org/mariadb

# 3. Copiar tu archivo de configuración personalizado
COPY ./wildfly-config/standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone-full.xml

# 4. Crear el usuario administrador
RUN /opt/jboss/wildfly/bin/add-user.sh admin adminpass --silent

# 5. Exponer los puertos (opcional, ya que se hace en docker-compose)
EXPOSE 8080 9991

# 6. Comando de inicio
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]