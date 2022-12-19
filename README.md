# digitalmedia

## Trabajo práctico integrador - Especialización Backend II
*Elaborado por:* Hernán Felipe Serna Gómez


**Tabla de contenidos**
> (En construcción)

### Pasos de ejecución

1. Levantar el servidor de Keycloak. Dentro de la carpeta raíz del proyecto (donde se ubica el `<docker-compose.yml>`), ejecutar `$ docker-compose -f docker-compose.dev.yml up --build`.
2. Importar las configuraciones del realm DigitalMedia (archivo realm-export.json)*.
3. Ejecutar desde Intellij los microservicios de la aplicación:
   - ms-discovery
   - ms-gateway
   - ms-users
   - ms-bills
   - ms-movies

**Hasta el momento solo se ha logrado dockerizar keycloak con su base de datos; se sigue avanzando para también incluir los microservicios de la aplicación. Además como no se ha logrado exportar las configuraciones de usuarios, se deben agregar manualmente al reino DigitalMedia, y los secrets en los respectivos microservicios.*

### Grupos, clientes y usuarios

##### Usuarios por grupos
| Grupo| Username | Firstname | Lastname | Email | Password |
|------|----------|-----------|----------|------- |---------|
| **admin** | admin1 | Carlos | Martínez | cmartinez@dm.com | admin1 |
| **client** | client1 | Nestor | Riquelme | nriquelme@dm.com | client1 |
| **provider** | provider1 | Agustina | López | alopez@dm.com | provider1 |

### Otras especificaciones

+ Versión de Spring: 3.0.0
+ Versión JDK: eclipse-temurin:17-jdk-jammy
+ Versión Java: 17
+ Servicios incluidos:
    + Service Registry (Eureka Server): port 8761
    + Gateway Service: port 8090
    + Keycloak Service: port 8082
