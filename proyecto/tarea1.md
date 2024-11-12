Conceptos Fundamentales
¿Qué es un servicio REST?

Un servicio REST (Representational State Transfer) es un estilo de arquitectura de software utilizado para diseñar servicios web que permiten la comunicación entre sistemas a través de la web. Los servicios RESTful se basan en el protocolo HTTP y utilizan recursos identificados por URIs (Uniform Resource Identifiers). Estos servicios permiten que los clientes interactúen con los recursos utilizando métodos HTTP estándar como GET, POST, PUT y DELETE.

¿Cuáles son los principios del diseño RESTful?

Interfaz uniforme: Todas las interacciones con el servicio se realizan de manera consistente, utilizando los mismos métodos y formatos de datos.
Sin estado: Cada solicitud del cliente al servidor debe contener toda la información necesaria para entender y procesar la solicitud, sin depender de un estado almacenado en el servidor.
Cacheable: Las respuestas del servidor deben ser explícitamente marcadas como cacheables o no cacheables, para optimizar el rendimiento.
Cliente-servidor: El cliente y el servidor están separados, lo que permite a los clientes interactuar con diferentes servidores y viceversa.
Sistema en capas: Un cliente puede interactuar con un servidor intermediario en lugar de directamente con el servidor final, mejorando la escalabilidad y seguridad.
¿Qué es HTTP y cuáles son los métodos HTTP más comunes?

HTTP (Hypertext Transfer Protocol) es el protocolo de comunicación utilizado en la web para la transferencia de información entre un cliente (como un navegador web) y un servidor. Es la base sobre la cual se construyen los servicios web RESTful.

Los métodos HTTP más comunes son:

GET: Recupera información de un recurso.
POST: Envía datos al servidor para crear o actualizar un recurso.
PUT: Actualiza un recurso existente o crea uno nuevo si no existe.
DELETE: Elimina un recurso especificado.
PATCH: Aplica modificaciones parciales a un recurso.
¿Qué es un recurso en el contexto de un servicio REST?

En REST, un recurso es cualquier información que puede ser nombrada o identificada, y que puede ser representada en un formato que se transfiere entre un cliente y un servidor. Un recurso podría ser un objeto de datos, una colección de objetos, o cualquier entidad que pueda ser accedida mediante un URI.

¿Qué es un endpoint?

Un endpoint en el contexto de un servicio REST es una URL específica que expone un recurso particular en el servidor. Los clientes interactúan con estos endpoints para realizar operaciones sobre los recursos. Por ejemplo, https://api.ejemplo.com/usuarios/123 podría ser un endpoint que permite acceder a la información del usuario con el ID 123.

Estructura de un Servicio REST
¿Qué es un URI y cómo se define?

Un URI (Uniform Resource Identifier) es una cadena de caracteres que identifica un recurso en la web. Se compone de varias partes, como el esquema (ej., http), el host (ej., www.ejemplo.com), y la ruta al recurso (ej., /usuarios/123). Un URI permite a los clientes localizar y acceder a los recursos disponibles en un servidor.

¿Qué es una API RESTful?

Una API RESTful es una interfaz de programación que cumple con los principios de REST. Permite a las aplicaciones comunicarse entre sí mediante solicitudes HTTP para acceder a recursos y realizar operaciones. Las APIs RESTful son ampliamente utilizadas en aplicaciones web modernas debido a su simplicidad y eficiencia.

¿Qué son los códigos de estado HTTP y cómo se usan en REST?

Los códigos de estado HTTP son códigos numéricos que un servidor devuelve en respuesta a una solicitud HTTP. Indican el resultado de la solicitud y ayudan al cliente a comprender qué ocurrió.

Tabla de códigos HTTP de respuesta más comunes y su significado
CódigoSignificado
200OK: Solicitud exitosa.
201Created: Recurso creado.
204No Content: Sin contenido.
400Bad Request: Solicitud inválida.
401Unauthorized: Autenticación requerida.
403Forbidden: Acceso denegado.
404Not Found: Recurso no encontrado.
500Internal Server Error: Error del servidor.