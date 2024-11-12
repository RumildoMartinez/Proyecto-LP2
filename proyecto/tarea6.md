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




# Conceptos Cliente-Servidor (Parte 2)

## ¿Cómo se realiza la autenticación y autorización en un sistema cliente-servidor basado en REST?

En un sistema cliente-servidor basado en REST, la **autenticación** y la **autorización** son procesos clave para garantizar la seguridad de las comunicaciones entre el cliente y el servidor:

- **Autenticación**: Este proceso verifica la identidad del cliente. Se realiza frecuentemente mediante **tokens** (por ejemplo, JWT - JSON Web Tokens), **OAuth**, o **API keys**. El cliente envía sus credenciales al servidor, y este devuelve un token que el cliente incluirá en las solicitudes posteriores para identificar su sesión.
  
- **Autorización**: Una vez autenticado, el cliente debe tener los permisos adecuados para acceder a ciertos recursos o realizar ciertas acciones. Esto se gestiona verificando los permisos asociados al token o credenciales del usuario. Por ejemplo, un usuario autenticado puede tener acceso de solo lectura, mientras que otro tiene permisos de escritura.

Estos procesos permiten controlar el acceso a los recursos y protegen los datos en una arquitectura distribuida.

## ¿Cuál es el papel de los códigos de estado HTTP en la comunicación entre cliente y servidor?

Los **códigos de estado HTTP** son esenciales en la comunicación entre cliente y servidor porque indican el resultado de una solicitud HTTP. Estos códigos permiten al cliente saber si su solicitud fue exitosa o si hubo algún error y, en este último caso, ofrecen información sobre el tipo de error.

- **Códigos 2xx** (Éxito): Indican que la solicitud fue exitosa (ej. `200 OK`).
- **Códigos 4xx** (Error del Cliente): Indican un error en la solicitud del cliente (ej. `404 Not Found`, `401 Unauthorized`).
- **Códigos 5xx** (Error del Servidor): Indican que el servidor encontró un problema al procesar la solicitud (ej. `500 Internal Server Error`).

Estos códigos permiten a los clientes gestionar sus interacciones con el servidor y tomar decisiones, como volver a intentar una solicitud o corregir la petición.

## ¿Por qué es fundamental devolver el código adecuado y cómo afecta la experiencia del cliente?

Es fundamental devolver el **código de estado adecuado** porque proporciona al cliente información precisa sobre el resultado de su solicitud. Devolver el código correcto ayuda a:

- **Facilitar el Diagnóstico de Problemas**: Permite al cliente entender si el error fue debido a su solicitud o a un problema del servidor.
- **Mejorar la Experiencia de Usuario**: Los clientes pueden responder de manera adecuada a los distintos estados, como volver a intentar o ajustar la solicitud.
- **Optimizar el Manejo de Errores**: El cliente puede implementar flujos lógicos basados en los códigos recibidos, como redirigir a páginas de error o mostrar mensajes específicos.

La correcta implementación de estos códigos mejora la **claridad** y **fiabilidad** de la comunicación, resultando en una mejor experiencia del cliente.

## ¿Cómo se define un recurso y por qué es importante mantenerlo como una entidad distinta?

Un **recurso** en una API REST representa una entidad de datos identificable, como un usuario, producto, o pedido, que se define con una URL única. Mantener un recurso como una entidad distinta permite:

- **Organización y Estructura**: Cada recurso tiene su propia ruta y estado, lo que facilita la organización de la API.
- **Modularidad**: Al definir recursos independientes, cada uno puede gestionarse, actualizarse y eliminarse sin afectar a otros.
- **Escalabilidad**: Mantener entidades independientes permite agregar nuevas funcionalidades o recursos sin interferir con el diseño actual.

Esta estructura ayuda a que la API REST sea **más clara**, **escalable** y **fácil de mantener**.

## ¿Qué ventajas ofrece la comunicación sin estado ("stateless") en un servicio REST desde la perspectiva del cliente?

La comunicación sin estado en un servicio REST ofrece las siguientes ventajas para el cliente:

- **Independencia de las Solicitudes**: Cada solicitud es autónoma y no depende de solicitudes previas, lo que facilita la gestión de la comunicación.
- **Mayor Escalabilidad**: Dado que el servidor no mantiene estados, puede manejar múltiples solicitudes de distintos clientes sin sobrecarga adicional.
- **Tolerancia a Fallos**: Al no depender de un estado previo, los clientes pueden reintentar solicitudes sin preocuparse de que se repita información de estado.

Esta estructura simplifica la arquitectura de la comunicación y permite que el cliente interactúe de manera confiable con el servidor.

## ¿Por qué es importante la idempotencia en las operaciones de un servicio REST?

La **idempotencia** garantiza que una operación produce el mismo resultado, independientemente de cuántas veces se ejecute. Esto es importante en servicios REST por varias razones:

- **Seguridad en las Peticiones Repetidas**: Los clientes pueden volver a enviar una solicitud sin temor a alterar el estado (por ejemplo, `GET` y `DELETE` son idempotentes).
- **Confiabilidad y Robustez**: En casos de fallos o desconexiones, el cliente puede reintentar la operación sin efectos secundarios no deseados.
- **Consistencia en el Sistema**: Las operaciones idempotentes ayudan a mantener la integridad de los datos y previenen la duplicación de registros o efectos no deseados.

La idempotencia es esencial para la estabilidad y consistencia de un servicio REST, especialmente en entornos de red no confiables.