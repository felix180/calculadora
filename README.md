## Ejecución

### Requisitos previos

* Java 17 o superior
* Maven 3.8 o superior

### Pasos

1. Instalar los requisitos previos
2. Clonar el repositorio
3. Navegar a la carpeta del proyecto
4. Ejecutar el siguiente comando:
* mvn install
* mvn spring-boot:run

Ejemplo:

Para ejecutar el proyecto en el puerto 8080, ejecute el siguiente comando:

mvn spring-boot:run -Dserver.port=8080

## Requests

Este proyecto proporciona los siguientes requests:

* **GET /api/calculadora**
 
  * QueryParam: operacion
    * valores: Sumar,Restar
    
  * JsonBody: array values
    * ejemplo: "values": ["1","2"]
