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

[POC-02]
* 1-
  * Se agrego la liberia Trace que se usa para mostrar resultados se agrego en el pom pero se genera con el maven-install-plugin en la phase de clean
    * Se agrega los archivos jar en una carpeta lib en la raiz del proyecto
  * Se añade ControllerExceptionHandler para gestiona el control de excepciones y mostrar un mensaje o codigo personalizado si deseas tambien para llamar el trace
  * Se añade TracerLog para crear una sola instancia de TracerImpl y ser usado en todo el poryecto