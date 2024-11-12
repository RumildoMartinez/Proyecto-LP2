# Implementación del Patrón Repository en Quarkus

## ¿Qué es el patrón de diseño Repository y cuál es su principal objetivo en aplicaciones REST?

El **patrón de diseño Repository** es un patrón arquitectónico que se utiliza para separar la lógica de acceso a datos de la lógica de negocio en aplicaciones. Su principal objetivo es proporcionar una forma de encapsular la interacción con la fuente de datos, ya sea una base de datos, un servicio externo o cualquier otra forma de almacenamiento. Esto permite que la lógica de negocio opere con abstracciones de alto nivel sin preocuparse por los detalles de cómo se obtienen o almacenan los datos.

## ¿Cómo separar la lógica de negocio del acceso a datos al implementar el patrón Repository?

Para separar la lógica de negocio del acceso a datos al implementar el patrón Repository, se deben seguir estos pasos:

1. **Definir Interfaces**: Crear interfaces que describan las operaciones de acceso a datos. Estas interfaces actúan como contratos que las implementaciones concretas deben seguir.

2. **Implementar Repositories**: Crear clases que implementen estas interfaces. Estas clases se encargarán de interactuar con la base de datos o el sistema de almacenamiento.

3. **Inyección de Dependencias**: Utilizar la inyección de dependencias para proporcionar las instancias de los repositories a las clases de servicio. Esto facilita la prueba y el mantenimiento del código, ya que se pueden reemplazar fácilmente las implementaciones de los repositories.

4. **Usar Servicios**: La lógica de negocio debe residir en los servicios, que utilizan los repositories para acceder a los datos. Esto mantiene la lógica de negocio independiente de la fuente de datos.

## ¿Qué técnicas se pueden usar para realizar consultas básicas (findAll, findById) en una clase Repository?

Para realizar consultas básicas como `findAll` y `findById` en una clase Repository, se pueden utilizar las siguientes técnicas:

1. **JPA (Java Persistence API)**: Utilizar JPA junto con un proveedor de implementación como Hibernate para definir entidades y realizar consultas. Por ejemplo:

   ```java
   @Repository
   public class UserRepository {

       @PersistenceContext
       EntityManager entityManager;

       public List<User> findAll() {
           return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
       }

       public User findById(Long id) {
           return entityManager.find(User.class, id);
       }
   }