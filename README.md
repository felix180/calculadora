## Ejecución

### Requisitos previos

* Java 17 o superior
* Maven 3.8 o superior

### Pasos

1. Instalar los requisitos previos
2. Clonar el repositorio
3. Navegar a la carpeta del proyecto
4. Ejecutar el siguiente comando:
* mvn clean (Se necesita para que genera los archivos en maven de la lib trace)
* mvn install
* mvn spring-boot:run


Ejemplo:

Para ejecutar el proyecto en el puerto 8080, ejecute el siguiente comando:

mvn spring-boot:run -Dserver.port=8080

## Requests

Este proyecto proporciona los siguientes requests:

* **GET /api/calculadora**
 
  * JsonBody: operacion y array values
    * ejemplo: { "operacion":"SUMAR", values": ["1","2"] }


## Estructura
* Controller donde estaran los servicios rest expuestos
* Service la logica de negocio operaciones  

## Solucion
* Se creo un objeto ValuesRequest para el posible evolutivo de no ser solo 2 numeros para las operaciones
  * Cambia la logia ya al tener varios numeros se suman secuencialmente o restan tomando el signo del valor por ejemplo  sera igual 
    * Sumar :lista (2,3,2) : 2+2+3 =7 
    * Sumar :lista (-1,2,3) : (-1)+ 2+3 = 4
    * Resta :lista (-1,2,3) : -(-1) - 2 - 3 = -4 
* Se aplica un patron de estrategia donde dependiendo del Enum Operation, se genera una accion para el calcular que 
va estar implementada aparte (Como mejora el metodo getOperation podria estar en un clase abstracta y tener esa fucnionalidad fuera del servicio)

* Se agrega la liberia Trace que se encarga de logear los resultados exitos y los errores cuando suceden dentro del proyecto
 * Como mejoras se deberia crear un objeto resultado que tenga el parametro de exitoso y tenga informacion relevando para el trace que funciona como auditoria
