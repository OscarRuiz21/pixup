# Pixup – Servicio de colonias con Jakarta EE

**Pixup** es un proyecto de ejemplo construido con Jakarta EE. El código implementa un servicio REST para gestionar **colonias** y **municipios** (entidades administrativas en México). La aplicación utiliza JPA para el acceso a datos y JTA para transacciones, se empaqueta como archivo WAR y se puede ejecutar en un servidor **WildFly** mediante contenedores Docker.

## Características principales

- API REST para gestionar colonias y municipios.
- Persistencia con JPA y transacciones JTA.
- Docker Compose con MariaDB y Adminer para pruebas locales.
- Despliegue en WildFly con configuración personalizada.
- Pruebas y control de errores con validaciones y excepciones específicas.

## Requisitos previos

- Java 17
- Maven 3.8+
- Docker y Docker Compose

## Estructura del proyecto

```
pixup/
├── init/                    # Scripts SQL para inicialización de la DB
├── wildfly-config/         # Configuración personalizada de WildFly
├── Dockerfile              # Imagen personalizada para WildFly
├── docker-compose.yml      # Definición de servicios: db, adminer y wildfly
├── pom.xml                 # Configuración de dependencias Maven
├── test.xml                # Módulos y ensamblado de WAR
├── code.txt                # Código fuente con servicios, entidades, EJBs
```

## Instalación y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/OscarRuiz21/pixup.git
cd pixup
```

2. Compila el proyecto con Maven:

```bash
mvn clean package
```

3. Inicia los servicios con Docker Compose:

```bash
docker-compose up --build
```

4. Accede a la consola de Adminer para inspeccionar la base de datos:

- URL: http://localhost:8081
- Servidor: db
- Usuario: root
- Contraseña: secret

## Endpoints del servicio REST

- **Listar colonias**:

  ```
  GET /colonias
  ```

- **Obtener colonia por ID**:

  ```
  GET /colonias/{id}
  ```

- **Listar colonias por código postal**:

  ```
  GET /colonias?cp=XXXXX
  ```

- **Crear una colonia**:

  ```
  POST /colonias
  {
    "cp": "12000",
    "nombre": "Normal",
    "municipio": { "id": 1 }
  }
  ```

- **Actualizar una colonia**:

  ```
  PUT /colonias/{id}
  {
    "cp": "12000",
    "nombre": "Polanco",
    "municipio": { "id": 2 }
  }
  ```

- **Eliminar una colonia**:

  ```
  DELETE /colonias/{id}
  ```

## Tecnologías utilizadas

- Jakarta EE 10
- JPA + JTA
- WildFly 27.0.1 Final
- MariaDB 11.3
- Docker & Docker Compose
- Maven
- Adminer
- Lombok

## Autor y licencia

Este proyecto fue desarrollado por [OscarRuiz21](https://github.com/OscarRuiz21) con fines educativos. Actualmente no cuenta con una licencia explícita.

## Contribuciones

Si deseas contribuir, crea un fork, haz tus cambios en una nueva rama y envía un Pull Request.

---

> Para más información técnica sobre el proyecto, revisa los archivos `code.txt`, `docker-compose.yml`, y `pom.xml`.
