Discover Colombia Backend 🇨🇴
Este repositorio contiene el núcleo lógico de Discover Colombia, una API REST robusta construida con Spring Boot para la gestión de servicios turísticos. La aplicación utiliza una base de datos H2 en memoria, lo que facilita enormemente las pruebas en entornos de desarrollo.

🚀 Tecnologías y Versiones
Java: 21 (LTS)

Framework: Spring Boot 3.x (Última versión)

Base de Datos: H2 Database (In-Memory)

Documentación: Swagger / OpenAPI 3.0

Herramienta de Testing: Insomnia / Postman

🏗️ Arquitectura del Proyecto
El proyecto sigue una estructura limpia y modular, garantizando la separación de responsabilidades entre la lógica de negocio, el acceso a datos y los controladores.

Vista de la organización de paquetes: Controller, Models, Repositories y Servicios.

Componentes Clave:
Controladores: Manejan las rutas bajo el path base /discoverapi/v1/.

Swagger UI: Documentación interactiva integrada para probar los endpoints directamente desde el navegador.

🧪 Evidencia de Funcionamiento (Pruebas API)
A continuación, se muestran las pruebas realizadas a los endpoints principales de la entidad Client:

1. Registro de Cliente (POST)
Se valida la creación exitosa de un nuevo usuario con una respuesta 201 Created.

2. Actualización de Datos (PUT)
Modificación de información existente con retorno de objeto actualizado y estado 200 OK.

3. Eliminación de Registro (DELETE)
Prueba de borrado lógico o físico mediante ID, confirmando la operación con un booleano true.

📊 Persistencia y Logs
La aplicación utiliza Hibernate como ORM. En la consola se puede observar la generación automática de las sentencias SQL para la base de datos H2:

Logs detallando las operaciones SELECT, INSERT, UPDATE y DELETE ejecutadas por el motor.

🛠️ Instalación Rápida
Clonar: git clone https://github.com/mariamontezuma15/DiscoverColombiaBackend.git

Rama: git checkout Smith

Ejecutar: ./mvnw spring-boot:run

H2 Console: Accede a http://localhost:8080/h2-console con el JDBC URL jdbc:h2:mem:testdb.
