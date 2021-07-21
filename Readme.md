Comentarios respecto al código fuente:
•	No se hace un buen uso de buenas prácticas basadas en patrones de diseño y arquitectónicos. Fundamentalmente se violan los principios SOLID:
o	Principio de responsabilidad única: En este caso existe solo una clase con toda la implementación en lugar de tener varias clases con una responsabilidad única, sencilla y concreta (Conexión a Base de datos, Jerarquía de objetos de Log, Manejador de ficheros y clases para el manejo de excepciones)  
o	Principio de segregación de interfaz: No se utilizan interfaces, de modo que agregar nuevas funcionalidades o modificar las existentes se torna más difícil.
•	No existe una correcta separación por capas: Se debe al menos tener una capa de acceso a datos y una capa de negocio reflejadas en el código fuente en su respectivo paquete.
•	No se realiza un correcto manejo de excepciones: se deben crear clases específicas para cada tipo de excepción y no retornar directamente tipos genéricos como en caso de la línea 39, 45 y 48 (Exception).
•	Se debe utilizar al menos un estándar para el nombrado de paquetes, clases, métodos, variables, constantes etc., se sugiere camelCase, por ser un referente en codificación del lenguaje Java. (Por ejemplo LogMessage debería comenzar en minúscula) así como poner nombres más descriptivos a las variables.
•	Alta complejidad cognitiva, se recomienda no hacer uso de tantas condicionales y de segmentar el código en métodos con funcionalidades más atómicas.
•	No se utiliza un patrón Singleton para la conexión a base de datos, tampoco se cierra la misma luego de utilizarla.
•	No se realizan pruebas unitarias al código fuente. 
•	Respecto a algunas consideraciones en el código fuente:
o	Línea 23: variable initialized no se utiliza.
o	De la Línea 29-36: las variables estáticas no deben ser actualizadas en el constructor de la clase. Se recomienda inicializarlas en la propia declaración, o que no sean estáticas. 
o	Línea 40: No se utiliza el resultado de la función trim(). Debe almacenarse en una variable auxiliar. 
o	Línea 74: La variable l está inicializada en null, lo cual no es correcto para su posterior concatenación.
o	Línea 77: El método createNewFile retorna un booleano y no es usado cuando se invoca. Se podría saber a través de su llamada si fue creado o no el archivo aunque no se retorne una excepción.
o	Línea 92: Se asigna un valor a la variable l y no es utilizado en lo que resta del método.
o	Línea 106: Es inneseraria el uso de String.valueOf al concatenar a un String. Se debe hacer directa la concatenación :
	stmt.executeUpdate("insert into Log_Values('" + message + "', " + t + ")");
