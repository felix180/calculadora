
## 0.2.0
[POC-04]
* 1-
  * Se anexa la clase OperacionInit que carga todas las instancias de tipo Operacion
  * Se crea un metodo get para retonar todas las operaciones cargadas desde OperacionInit
  * Se elimina el OperacionEnum por que no es necesario
  * Se cambia en ValueRequest el tipo operacion para String antes era el Enum
  * Se elimina getOperacion de CalculadoraService

* 2-
  * Se agregar mas validaciones en el ControllerExceptionHandler y se extiende de ResponseEntityExceptionHandler para facil implementacion de los posibles errores a controllar

* 3-
  * Se cambia la logica que de sumar y restar que comenzaba de base cero que para el restar funcionaba extraño al ingresar valores negativos,se crea test despues del cambio


## 0.1.0
[POC-03]
* 1-
  * Se cambia el metodo del controller como post y se agregar operacion en el body del json
  * Se elimina los test que levantan el spring y solo se deja los test unitarios basicos solo con mockito
  * Se crea un objeto de resultado OperacionResult donde esta la data a devolver
* 2-
  * Se agrega un nueva dependencia springdoc-openapi-starter-webmvc-ui que genera un yaml o muestra visualmente la api que ayuda para documentarlo

[POC-02]
* 1-
  * Se agrego la liberia Trace que se usa para mostrar resultados se agrego en el pom pero se genera con el maven-install-plugin en la phase de clean
    * Se agrega los archivos jar en una carpeta lib en la raiz del proyecto
  * Se añade ControllerExceptionHandler para gestiona el control de excepciones y mostrar un mensaje o codigo personalizado si deseas tambien para llamar el trace
  * Se añade TracerLog para crear una sola instancia de TracerImpl y ser usado en todo el poryecto


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


