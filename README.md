# Financial-Report-Activity
Application of design patterns and identification of SOLID principles

## Patrones de diseño
Se implementaron 2 patrones de diseño:
* Builder: Se implementó en la clase de Ride, creando un RideBuilder que maneja la lógica de la creación del objeto para reemplazar el constructor y siendo utilizado en RidesParser al crear los objetos.
* Factory Method: Se abstrajeron las clases de WebReport y PrintReport en una clase de Report. Después. se crearon los Creator de dichas clases para poder manejar más fácil las diferentes clases a través de sus interfaces.

## Principios identificados
Se encontraron (y desarrollaron) los siguientes patrones de SOLID:
* Single Responsability: Se creó la clase de AnalyzerInterface para hacer la lectura de datos.
* Dependency Inversion: Anteriormente se tenía dependencia de Client hacia AnalyzerInterface pero se invertió al crearse la interfaz de AnalyzerInterface y no llamar directamente a la clase.
* Interface Segregation: Gracias a AnalyzerInterface podemos solamente acceder al método de analyze del objeto, sin acceder a readData de la clase principal.
* Open Close: Al abstrarer las clases de reporte web y print en una de Report (e implementar el factory method) hace más fácil la implementación de nuevos tipos de reporte al crear nuevas clases y no modificar las pasadas.
