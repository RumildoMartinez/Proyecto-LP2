## `@GET` y `@POST` en Quarkus

En Quarkus, los métodos `@GET` y `@POST` son anotaciones de JAX-RS (Java API for RESTful Web Services) que se utilizan para definir endpoints de un servicio REST que responden a solicitudes HTTP GET y POST, respectivamente.

### `@GET`

La anotación `@GET` se utiliza para definir un endpoint que responde a solicitudes HTTP GET. Este tipo de solicitudes se usa principalmente para obtener datos del servidor sin modificar el estado del recurso.

**Ejemplo de uso de `@GET`:**

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, Quarkus!";
    }
}




# Implementación del Patrón Repository en Quarkus

## ¿Qué es el patrón de diseño Repository y cuál es su principal objetivo en aplicaciones REST?

El **patrón de diseño Repository** es una abstracción que encapsula la lógica necesaria para acceder y manipular los datos en una aplicación. Su objetivo principal es proporcionar una interfaz entre la aplicación y el sistema de almacenamiento de datos (por ejemplo, bases de datos), de forma que la lógica de acceso a datos esté desacoplada de la lógica de negocio. 

En aplicaciones REST, este patrón facilita la gestión de entidades al encapsular las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y permite que el código de la aplicación sea más modular y fácil de mantener.

## Explica cómo separar la lógica de negocio del acceso a datos al implementar el patrón Repository

Al implementar el patrón Repository, se separa la lógica de negocio y el acceso a datos creando dos capas distintas:

1. **Capa de Repositorio (Repository)**: Esta capa contiene clases y métodos específicos para interactuar con la base de datos o cualquier otra fuente de datos. Solo realiza operaciones relacionadas con el almacenamiento y recuperación de datos.
2. **Capa de Servicio (Service)**: La capa de servicio contiene la lógica de negocio de la aplicación y se comunica con la capa de repositorio para acceder o manipular los datos. Al centralizar la lógica de negocio en una capa de servicio independiente, el código se vuelve más reutilizable y fácil de probar.

**Ejemplo en Quarkus**:
- En una clase `UserRepository`, se implementan los métodos de acceso a datos (`findAll`, `findById`, etc.).
- En una clase `UserService`, se define la lógica de negocio que interactúa con el repositorio para ejecutar las operaciones deseadas.

## ¿Qué técnicas se pueden usar para realizar consultas básicas (`findAll`, `findById`) en una clase Repository?

Para realizar consultas básicas en una clase Repository en Quarkus, se pueden utilizar las siguientes técnicas:

1. **Panache Repository**: Quarkus ofrece `PanacheRepository`, que simplifica la implementación de repositorios al proporcionar métodos predefinidos como `findAll()` y `findById()`.
   ```java
   @ApplicationScoped
   public class UserRepository implements PanacheRepository<User> {}