# Introducción a Quarkus y el Patrón Repository

## 1) ¿Qué es Quarkus?

Quarkus es un framework o plataforma que se utiliza para crear aplicaciones Java rápidas, eficientes y optimizadas para trabajar en la nube y con contenedores (como Docker y Kubernetes). A diferencia de otros frameworks, Quarkus está diseñado para iniciar más rápido y consumir menos memoria, lo que lo hace ideal para aplicaciones que deben ejecutarse en entornos modernos como microservicios y serverless.

En términos más sencillos, puedes pensar en Quarkus como una herramienta que ayuda a los desarrolladores a crear aplicaciones web y servicios ligeros y rápidos, mejorando su rendimiento, especialmente cuando se ejecutan en la nube.

## 2) Explicación del patrón Repository en Quarkus

El patrón **Repository** es una manera de organizar el acceso a los datos en una aplicación. En lugar de que la lógica de la aplicación se conecte directamente a la base de datos, el Repository actúa como un intermediario encargado de realizar las operaciones de lectura, escritura, actualización y eliminación de datos. Esto facilita el mantenimiento y prueba del código, ya que separa la lógica del negocio de la lógica de acceso a los datos.

### Implementación en Quarkus con Panache

En Quarkus, el patrón Repository puede implementarse usando **Panache**, una extensión que facilita el uso de la base de datos. Con Panache, puedes crear un Repository con unas pocas líneas de código para interactuar con la base de datos.

### Ejemplo básico:

#### 1. Crear una Entidad:
Primero, creamos una entidad, que es una clase que representa una tabla de la base de datos. Por ejemplo:

```java
@Entity
public class Producto {
    @Id
    @GeneratedValue
    public Long id;
    public String nombre;
    public Double precio;
}


# Introducción a REST y Quarkus

## ¿Qué es un servicio REST y cuáles son sus principios fundamentales?

Un servicio **REST** (Representational State Transfer) es un tipo de arquitectura para diseñar servicios web, donde los recursos son accesibles a través de URIs y se comunican generalmente mediante el protocolo HTTP. Los principios fundamentales de REST son:

1. **Cliente-Servidor**: Separación entre la interfaz de usuario (cliente) y la gestión de datos (servidor).
2. **Sin Estado (Stateless)**: Cada solicitud del cliente contiene toda la información necesaria para que el servidor la procese sin depender de solicitudes anteriores.
3. **Caché**: Las respuestas pueden ser almacenadas en caché para mejorar la eficiencia.
4. **Interfaz Uniforme**: Define una manera consistente de acceder a los recursos usando métodos estándar.
5. **Sistema en Capas**: La arquitectura puede estar dividida en capas para mejorar la escalabilidad y la seguridad.
6. **Código Bajo Demanda (Opcional)**: La capacidad de extender la funcionalidad mediante scripts o applets descargados.

## ¿Qué beneficios tiene Quarkus para el desarrollo de microservicios REST?

**Quarkus** es un framework optimizado para el desarrollo de microservicios en Java, especialmente en entornos de **nube** y **contenedores**. Entre los beneficios que ofrece para desarrollar microservicios REST están:

- **Arranque Rápido**: Quarkus optimiza los tiempos de inicio, haciendo que las aplicaciones inicien en milisegundos, ideal para entornos serverless.
- **Uso Reducido de Memoria**: Su arquitectura permite que las aplicaciones consuman menos recursos, lo cual es fundamental en microservicios.
- **Desarrollo Reactivo**: Permite la creación de servicios reactivos, lo que mejora el manejo de eventos y la escalabilidad.
- **Integración Sencilla**: Cuenta con extensiones para múltiples librerías y frameworks que facilitan el desarrollo REST (por ejemplo, JAX-RS, JSON-B).
- **Hot Reload**: Facilita el desarrollo con recarga en caliente, permitiendo ver cambios en tiempo real sin reiniciar el servidor.

## Explica la diferencia entre los métodos HTTP: GET, POST, PUT y DELETE.

- **GET**: Recupera datos de un recurso específico sin modificarlo. Es un método seguro y no tiene efectos secundarios.
- **POST**: Envía datos al servidor para crear un nuevo recurso. No es idempotente, lo que significa que múltiples solicitudes pueden crear múltiples recursos.
- **PUT**: Actualiza un recurso existente o lo crea si no existe. Es idempotente, por lo que múltiples solicitudes tendrán el mismo efecto.
- **DELETE**: Elimina el recurso especificado. También es idempotente, ya que múltiples solicitudes tendrán el mismo resultado.

## ¿Qué significa que un servicio REST sea "stateless" y por qué es importante?

Un servicio REST "stateless" significa que cada solicitud del cliente al servidor es independiente y no guarda estado entre peticiones. Esto es importante porque:

- **Escalabilidad**: Los servidores pueden atender cualquier solicitud sin necesidad de mantener el estado de la sesión del cliente, facilitando la distribución de cargas entre varios servidores.