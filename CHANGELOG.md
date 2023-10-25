## 0.1.0
[POC-01]
* 1 -
  * Se añade CalculadoraContoller con los servicios rest con un metodo get para generar el calculo de valores dependiendo de un operador
  * Se añade ValueRequest para representar el body que va ser el input del metodo de calcular
  * Se añada el changelog para agregar info de los commit y cambios .
  * Se añada Readme con detalles generales del proyecto.
  * Se añade el pom la dependencia de spring-boot-starter-web
  * Se añade CalculadoraControllerTest para generar los test del CalculadoraController

* 2 - 
  * Se añanade CalculadoraService con el metodo calcular para retonar los valores
  * Se crea el OperacionEnum para sacarlo de la clase controller 
  * Se agregar la interfas Operation con 2 implementacion Sumar y Restar para dar solucion a los requerimientos
  * Se agrega los test validando los valores de Sumar y Restar con sus input

