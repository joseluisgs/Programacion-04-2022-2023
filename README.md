# Programación - 04 Programación Orientada a Objetos

Tema 04 Programación Orientada a Objetos. 1DAM. Curso 2022/2023.

![imagen](https://raw.githubusercontent.com/joseluisgs/Programacion-00-2022-2023/master/images/programacion.png)

- [Programación - 04 Programación Orientada a Objetos](#programación---04-programación-orientada-a-objetos)
  - [Contenidos](#contenidos)
  - [Programación Orientada a Objetos](#programación-orientada-a-objetos)
  - [Objetos](#objetos)
  - [Clases](#clases)
  - [Creación e Instanciación de Objetos](#creación-e-instanciación-de-objetos)
  - [Propiedades y métodos](#propiedades-y-métodos)
  - [Constructores e instanciadores](#constructores-e-instanciadores)
    - [Constructores](#constructores)
    - [Constructor primario y secundario](#constructor-primario-y-secundario)
    - [Inicializador de instancia](#inicializador-de-instancia)
    - [Algún detalle más](#algún-detalle-más)
  - [Referencia this](#referencia-this)
  - [Getters y Setters](#getters-y-setters)
    - [Getters y setters personalizados](#getters-y-setters-personalizados)
  - [Igualdad e identidad](#igualdad-e-identidad)
    - [equals y hashCode](#equals-y-hashcode)
  - [Representación de objetos como cadenas](#representación-de-objetos-como-cadenas)
  - [Data classes: POJOS y POKOS](#data-classes-pojos-y-pokos)
    - [Inmutabilidad y copia de objetos](#inmutabilidad-y-copia-de-objetos)
    - [Desestructuración de objetos](#desestructuración-de-objetos)
  - [Atributos y métodos de clase](#atributos-y-métodos-de-clase)
  - [Enums class](#enums-class)
  - [Paquetes y visibilidad](#paquetes-y-visibilidad)
    - [Alias](#alias)
    - [Visibilidad](#visibilidad)
  - [Composición de objetos](#composición-de-objetos)
  - [Clases internas y anidadas](#clases-internas-y-anidadas)
  - [Inyección de dependencias](#inyección-de-dependencias)
  - [Singleton](#singleton)
  - [Factory](#factory)
  - [Fachada](#fachada)
  - [Herencia](#herencia)
  - [Modificadores de acceso](#modificadores-de-acceso)
  - [Polimorfismo](#polimorfismo)
  - [Interfaces](#interfaces)
  - [Sealed Classes](#sealed-classes)
  - [Smart Casts](#smart-casts)
  - [Inlining](#inlining)
  - [Type Aliases](#type-aliases)
  - [Inicialización tardía y perezosa](#inicialización-tardía-y-perezosa)
  - [Recursos](#recursos)
  - [Autor](#autor)
    - [Contacto](#contacto)
    - [¿Un café?](#un-café)
  - [Licencia de uso](#licencia-de-uso)

## Contenidos
1. Programación Orientada a Objetos
2. Objetos
3. Clases
4. Instanciación de objetos
5. Propiedades y métodos
6. Constructores
7. Referencia this
8. Getters y Setters
9. Igualdad e identidad
10. POJOS y POKOS. Data classes
11. Atributos y métodos de clase
12. Enums Class
13. Paquetes y visibilidad
14. Composición de objetos
15. Clases internas y anidadas
16. Inyección de dependencias
17. Singleton
18. Factory
19. Fachada
20. Herencia
21. Modificadores de acceso
22. Interfaces
23. Sealed classes
24. Smart cast
25. Inlining
26. Typealias
27. Inicialización tardía y perezosa

## Programación Orientada a Objetos
La programación orientada a objetos es un paradigma de programación que se basa en el concepto de objetos, los cuales contienen información en forma de campos (a veces también referidos como atributos o propiedades) y código en forma de métodos.

Los objetos son capaces de interactuar y modificar los valores contenidos en sus campos o atributos (estado) a través de sus métodos (comportamiento) y siempre tienen una identidad.

Algunas características clave de la programación orientada a objetos son herencia, cohesión, abstracción, polimorfismo, acoplamiento y encapsulamiento.

## Objetos
Un objeto es una entidad que tiene un estado y un comportamiento. El estado de un objeto es almacenado en campos (atributos) y el comportamiento es mostrado por métodos (funciones) y tienen una identidad. En lenguajes tipados, un objeto es una instancia de una clase (nos sirve para tipar). 

- Objetos: unidad que engloba dentro de sí un conjunto de datos y módulos necesarios para el tratamiento de esos datos. Cada objeto contiene datos y funciones.
- Atributos: Son los datos incluidos en el objeto y definen su estado. Parecidas a las variables de C clásico pero incluidas en los objetos.
- Métodos: Son módulos que pertenecen a los objetos y que manejarán los atributos, definen su comportamiento.
- Identidad: Cada objeto tiene una identidad única que lo distingue de los demás objetos. La identidad de un objeto no puede ser cambiada durante la ejecución del programa.
- Mensajes: El modo mediante el que se comunican los objetos. Consiste en llamar a un método de un objeto.
- Interfaz: Las clases (y, por lo tanto, los objetos) tienen partes públicas y partes privadas. La parte pública es visible para todos los objetos, mientras que la parte privada es sólo visible para el propio objeto. A la parte pública de un objeto se le denomina interfaz.

```kotlin
// Llamando a un objeto
val persona = Persona()
persona.nombre = "José Luis"
persona.apellidos = "González Sánchez"
persona.programar(lenguaje= "Kotlin")
```

## Clases
Una clase es un modelo o plantilla para crear objetos. Una clase define el estado en base a propiedades y el comportamiento en base a los métodos de un objeto. Un objeto es una instancia de una clase. La clase nos va a servir para tipar los objetos. Recuerda que tipar nos sirve para definir el tipo de dato que vamos a utilizar en base a los estados y comportamientos que queremos que tenga el objeto.

```kotlin
// Definiendo una clase
class Persona {
    // Estado del objeto
    var nombre: String = ""
    var apellidos: String = ""

    // Comportamiento del objeto
    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
}
```

## Creación e Instanciación de Objetos
La instanciación de objetos es el proceso de crear un objeto a partir de una clase. La instanciación de objetos se realiza mediante la palabra reservada new (Java), o llamando a su constructor (Kotlin). Cuando se crea un objeto, se reserva memoria para el objeto y se inicializan sus atributos o propiedades, es decir, estado a su valor por defecto.

A los miembros de un objeto se accede a través de su referencia. La sintaxis es:
nombre_referencia.miembro

```kotlin
// Instanciando un objeto
val persona = Persona()
persona.nombre = "José Luis"
persona.programar(lenguaje= "Kotlin")
```

## Propiedades y métodos
Los atributos definen el estado de un objeto. Las propiedades se definen en la clase y representan los atributos del estado y se acceden a través de la referencia del objeto.

Los métodos definen el comportamiento de un objeto. Los métodos se definen en la clase y representan las acciones del comportamiento y se acceden a través de la referencia del objeto.

Podemos tener propiedades y métodos públicos, privados y protegidos. Por defecto, las propiedades y métodos son públicos. Si son privados, sólo pueden ser accedidos desde la propia clase. Si son protegidos, sólo pueden ser accedidos desde la propia clase y sus subclases. De esta manera podemos encapsular y ocultar la información y acciones que deseemos.

```kotlin
// Definiendo una clase
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
}

// Instanciando un objeto
val persona = Persona()
persona.nombre = "José Luis"
persona.programar(lenguaje= "Kotlin")
// No puedo acceder a lo privados de la clase
```

## Constructores e instanciadores
### Constructores
Los constructores son métodos especiales que se utilizan para inicializar los objetos. Los constructores se definen en la clase y se ejecutan al instanciar un objeto. Los constructores pueden tener parámetros y pueden ser sobrecargados.

Debemos tener en cuenta que los constructores no devuelven ningún valor y no tienen tipo de retorno. Su objetivo es inicializar el objeto y con ello crear la memoria y el estado inicial del objeto.

No es necesario definir un constructor, ya que si no se define ningún constructor, se crea un constructor vacío por defecto, es decir, crearía e instanciaría el objeto con el estado por defecto de las variables.

### Constructor primario y secundario

En Kotlin existe un constructor primario y uno secundario. El constructor primario se define en la cabecera de la clase y el secundario se define en el cuerpo de la clase. El constructor primario no puede tener código, pero el secundario sí. Si no se define ningún constructor, se crea un constructor primario vacío.

Consejo: A la hora de definir un constructor debemos tener en cuenta que es conveniente solamente instanciar los atributos que definen el estado fundamental y necesario del objeto, no es necesario instanciar todos los atributos. Si queremos instanciar un atributo que no forma parte del estado fundamental del objeto, podemos hacerlo en el constructor secundario. Para usar el constructor secundario, debemos llamar al constructor primario mediante la palabra reservada this. Si no se llama al constructor primario, no se inicializará el estado del objeto. Podemos tener varios constructores secundarios. Pero es importante no sobrecargar en exceso si podemos hacer uso de los parámetros por defecto.

### Inicializador de instancia
Inicializador de instancia: es un bloque de código que se ejecuta al instanciar un objeto. Se define en el cuerpo de la clase y se ejecuta antes del constructor secundario.

```kotlin
// Definiendo una clase con constructor primario, en ellos ponemos solo los atributos que son necesarios para la creación del objeto
// y con ello ya forman parte de su estado
// De esta manera estamos definiendo en ese constructor ya los atributos de la clase
// Podemos definirlos como var o val, pero o añadirle caracteristicas como private o protected para su visibilidad

class Persona(val nombre: String, val apellidos: String, var experiencia: Int = 0) {
    // Otros aotributos que forman parte del estado
    var direccion: String = ""

    private val nivel: Int = 0

    // Constructor secuendario, en el que podemos añadir mas atributos
    // Es importante no crear demasiados constructores secundarios, ya que puede ser confuso y usar parámetros con valor por defecto
    constructor(nombre: String, apellidos: String, experiencia: Int = 0, nivel: Int = 0, direccion: String ="") : this(nombre, apellidos, experiencia) {
        this.direccion = direccion
        this.nivel = nivel
    }
    // El inicializador de instancia se ejecuta antes del constructor secundario, por si queremos ejecutar algún código antes de que se ejecute el constructor secundario y despues del constructor primario
    init {
        println("Inicializando instancia")
    }
    
    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }

    private fun dormir() {
        println("Durmiendo...")
    }
}
```

### Algún detalle más
En el fondo hemos hecho esto:
```kotlin
class Persona constructor(nombre: String) { /*...*/ }

// Si el constructor no tiene anotaciones ni modificadores de visibilidad, el modificador constructor se puede omitir:
class Persona(nombre: String) { /*...*/ }
```

## Referencia this
La referencia this es una referencia al objeto actual. Se utiliza para acceder a los miembros de la clase. Si no se utiliza la referencia this, se accede a los miembros de la clase.

```kotlin
// Definiendo una clase con constructor primario
class Persona(val nombre: String, val apellidos: String, var experiencia: Int = 0) {
       var direccion: String = ""

    private val nivel: Int = 0

    // Constructor secuendario, utilizando la referencia this para llamar al constructor primario
    // y acceder a los miembros de la clase y no a los parámetros del constructor

    constructor(nombre: String, apellidos: String, experiencia: Int = 0, nivel: Int = 0, direccion: String="") : this(nombre, apellidos, experiencia) {
        this.direccion = direccion
        this.nivel = nivel
    }
    init {
        println("Inicializando instancia")
    }
    
    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }

    private fun dormir() {
        println("Durmiendo...")
    }
    
    // usamos la referencia this para acceder a los miembros de la clase y no a los parámetros
    fun setExperiencia(experiencia: Int) {
        this.experiencia = experiencia
    }
}
```

## Getters y Setters
Los getters y setters son métodos especiales que se utilizan para acceder/cambiar a los atributos de un objeto. Los getters y setters se definen en la clase y se acceden a través de la referencia del objeto.
```kotlin
// Definiendo una clase con getters y setters
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
    
    // Getter
    fun getExperiencia(): Int {
        return experiencia
    }
    // Setter
    fun setExperiencia(experiencia: Int) {
        this.experiencia = experiencia
    }
}
```

En Kotlin podemos definir getters y setters de forma automática. Para ello, debemos definir los atributos con la palabra reservada var (getter/setter). Si definimos los atributos con la palabra reservada val, sólo se creará el getter.

### Getters y setters personalizados

Podemos crear campos calculados, es decir, campos que no se almacenan en memoria, sino que se calculan a partir de otros campos. Para ello, debemos definir el campo con la palabra reservada val y no con var.

También podemos cambiar como se almacenan los atributos en memoria. Por ejemplo, podemos almacenarlos en minúsculas o en mayúsculas. Para ello, debemos definir el getter y el setter de forma manual.

```kotlin
// Clase con getters y setters automáticos
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    //private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
    
    // Campos calculados
    val nombreCompleto: String
        get() = "$nombre $apellidos"

    // Campos con almacenamiento personalizado
    var experiencia: Int = 99
        get() = field
        set(value) {
            if (value > 0) {
                field = value
            } else {
                field = 0
            }
        }
}
```

## Igualdad e identidad
En Kotlin, para comparar objetos, debemos utilizar el operador ==. Este operador compara el contenido de los objetos (estado). Realmente ejecuta el método equals. Si queremos comparar la identidad de los objetos, debemos utilizar el operador ===. Este operador compara la referencia de los objetos (identidad).

En Java el operador == compara la identidad de los objetos. Para comparar el contenido de los objetos, debemos utilizar el método equals.

```kotlin
// Clase Persona
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    //private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
    
    // Campos calculados
    val nombreCompleto: String
        get() = "$nombre $apellidos"

    // Campos con almacenamiento personalizado
    var experiencia: Int = 99
        get() = field
        set(value) {
            if (value > 0) {
                field = value
            } else {
                field = 0
            }
        }

        // Sobreescribimos el método equals, solo serán iguales si tienen el mismo nombre y apellidos
        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Persona) {
                return false
            }
            return nombre == other.nombre && apellidos == other.apellidos
        }
}

// Comparar con equals
val persona1 = Persona()
persona1.nombre = "Juan"
persona1.apellidos = "Pérez"

val persona2 = Persona()
persona2.nombre = "Juan"
persona2.apellidos = "Pérez"

println(persona1 == persona2) // true
println(persona1.equals(persona2)) // true
println(persona1 === persona2) // false

// Comparar con ===
val persona3 = persona1
println(persona1 === persona3) // true
```

### equals y hashCode
El método equals se utiliza para comparar el contenido de los objetos. El método hashCode se utiliza para calcular el código hash de los objetos. El código hash es un número que se utiliza para identificar de forma única a un objeto. El método hashCode se utiliza para comparar objetos, dos objetos son iguales si tienen el mismo código hash. Por lo tanto, si sobreescribimos el método equals, debemos sobreescribir también el método hashCode y los campos que usemos para comparar los objetos, deben ser inmutables. Es importante que los atributos que usemos para comparar los objetos, sean inmutables. Si no lo son, el código hash puede cambiar y los objetos no serán iguales.

Por otro lado, es importante que los métodos equals y hashCode sean consistentes. Es decir, si dos objetos son iguales, deben tener el mismo código hash. Si dos objetos tienen el mismo código hash, no necesariamente deben ser iguales. Por lo tanto intenta que las propiedadesa que uses para el método equals sean las mismas que uses para el método hashCode.

```kotlin
// Clase Persona
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    //private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
    
    // Campos calculados
    val nombreCompleto: String
        get() = "$nombre $apellidos"

    // Campos con almacenamiento personalizado
    var experiencia: Int = 99
        get() = field
        set(value) {
            if (value > 0) {
                field = value
            } else {
                field = 0
            }
        }

        // Sobreescribimos el método equals, solo serán iguales si tienen el mismo nombre y apellidos
        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Persona) {
                return false
            }
            return nombre == other.nombre && apellidos == other.apellidos
        }

        // Sobreescribimos el método hashCode, solo serán iguales si tienen el mismo nombre y apellidos
        override fun hashCode(): Int {
            return nombre.hashCode() + apellidos.hashCode()
        }
}

// Comparar con equals
val persona1 = Persona()
persona1.nombre = "Juan"
persona1.apellidos = "Pérez"

val persona2 = Persona()
persona2.nombre = "Juan"
persona2.apellidos = "Pérez"

println(persona1 == persona2) // true
println(persona1.equals(persona2)) // true

// Comparar con ===
val persona3 = persona1
println(persona1 === persona3) // true

// Comparar con hashCode
println(persona1.hashCode()) // 131
println(persona2.hashCode()) // 131
println(persona3.hashCode()) // 131

if (persona1.hashCode() == persona2.hashCode()) {
    println("Los objetos tienen el mismo código hash")
} else {
    println("Los objetos tienen distinto código hash")
}
```

## Representación de objetos como cadenas
El método toString se utiliza para representar un objeto como una cadena. Por defecto, el método toString devuelve el nombre de la clase y el código hash del objeto. Podemos sobreescribir el método toString para que devuelva la información que queramos.

```kotlin
// Clase Persona
class Persona {
    var nombre: String = ""
    var apellidos: String = ""
    //private var experiencia: Int = 99

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }
    private fun dormir() {
        println("Durmiendo...")
    }
    
    // Campos calculados
    val nombreCompleto: String
        get() = "$nombre $apellidos"

    // Campos con almacenamiento personalizado
    var experiencia: Int = 99
        get() = field
        set(value) {
            if (value > 0) {
                field = value
            } else {
                field = 0
            }
        }

        // Sobreescribimos el método equals, solo serán iguales si tienen el mismo nombre y apellidos
        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Persona) {
                return false
            }
            return nombre == other.nombre && apellidos == other.apellidos
        }

        // Sobreescribimos el método hashCode, solo serán iguales si tienen el mismo nombre y apellidos
        override fun hashCode(): Int {
            return nombre.hashCode() + apellidos.hashCode()
        }

        // Sobreescribimos el método toString
        override fun toString(): String {
            return "Persona(nombre=$nombre, apellidos=$apellidos, experiencia=$experiencia)"
        }
}

// Representación de objetos como cadenas
val persona1 = Persona()
persona1.nombre = "Juan"
persona1.apellidos = "Pérez"
persona1.experiencia = 10

println(persona1) // Persona(nombre=Juan, apellidos=Pérez, experiencia=10)
```


## Data classes: POJOS y POKOS
Los POJOS (Plain Old Java Objects) son objetos simples que no tienen lógica de negocio en Java. Los POKOS (Plain Old Kotlin Objects) son objetos simples que no tienen lógica de negocio en Kotlin. En Kotlin, los POJOS y POKOS se definen como clases de datos. Para definir una clase de datos, debemos utilizar la palabra reservada data en Kotlin, en Java podremos usar los records.

Las data classes tienen los siguientes miembros:
- Estado del objeto con el constructor primario con los parámetros que se pasan al constructor y definen su estado fundamental.
- Propiedades deberían ser inmutables para cada parámetro del constructor primario.
- Método equals: compara el contenido de los objetos.
- Método hashCode: calcula el hash del objeto. Se utiliza para comparar objetos, pues dos objetos con el mismo hash son iguales.
- Método toString: devuelve una cadena con el nombre de la clase y los valores de los atributos.


Si las propiedades de la data class son inmutables, se creará un getter para cada propiedad. Si las propiedades de la data class son mutables, se creará un getter y un setter para cada propiedad. Podemos hacer uso de copy para crear una copia de la data class variando las propiedades que nos interesen.

```kotlin
// Definiendo una clase de persona como data class
data class Persona(val nombre: String, val apellidos: String, var experiencia: Int)

val persona1 = Persona("Juan", "Pérez", 99)
println(persona1) // Persona(nombre=Juan, apellidos=Pérez, experiencia=99)
println(persona1.nombre) // Juan

val persona2 = persona1.copy(nombre = "Pepe")
println(persona2) // Persona(nombre=Pepe, apellidos=Pérez, experiencia=99)

val persona3 = persona1.copy()
println(persona3) // Persona(nombre=Juan, apellidos=Pérez, experiencia=99)

println(persona1 == persona2) // false
println(persona1 == persona3) // true
println(persona1 === persona2) // false
println(persona1 === persona3) // false
println(persona1.hashCode() == persona2.hasCode()) // false
println(persona1.hashCode() == persona3.hasCode()) // true
```

Los métodos equals, hashCode y toString se generan automáticamente. Si queremos sobreescribirlos, debemos hacerlo manualmente. Esto nos permite poder usarlos en cualquier clase, no solo en las data classes.

```kotlin
// Clase Persona, equivalente a la data class Persona
class Persona(val nombre: String, val apellidos: String, var experiencia: Int) {
    // Sobreescribimos el método equals, solo serán iguales si tienen el mismo nombre y apellidos
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Persona) {
            return false
        }
        return nombre == other.nombre && apellidos == other.apellidos
    }

    // Sobreescribimos el método hashCode, solo serán iguales si tienen el mismo nombre y apellidos
    override fun hashCode(): Int {
        return nombre.hashCode() + apellidos.hashCode()
    }

    // Sobreescribimos el método toString, solo serán iguales si tienen el mismo nombre y apellidos
    override fun toString(): String {
        return "Persona(nombre=$nombre, apellidos=$apellidos, experiencia=$experiencia)"
    }
}
```

### Inmutabilidad y copia de objetos
Si queremos que el estado de un objeto no pueda ser modificado, debemos declarar sus propiedades como inmutables. En Kotlin, las propiedades de una data class son deberían ser inmutables por defecto. Para cambiar el estado de un objeto, debemos crear una copia del objeto con los valores que queramos modificar gracias a la función copy.

```kotlin
// Definiendo una clase de persona como data class
data class Persona(val nombre: String, val apellidos: String, var experiencia: Int)

val persona1 = Persona("Juan", "Pérez", 99)
println(persona1) // Persona(nombre=Juan, apellidos=Pérez, experiencia=99)
println(persona1.nombre) // Juan

val persona2 = persona1.copy(nombre = "Pepe")
println(persona2) // Persona(nombre=Pepe, apellidos=Pérez, experiencia=99)

val persona3 = persona1.copy()
println(persona3) // Persona(nombre=Juan, apellidos=Pérez, experiencia=99)
```

### Desestructuración de objetos
Podemos desestructurar un objeto en sus propiedades. Esto nos permite acceder a las propiedades de un objeto sin tener que acceder a sus atributos gracias a la función componentN. Se acceden por el mismo orden y si no nos interesa algún campo, lo ignoramos con _.

```kotlin
// Definiendo una clase de persona como data class
data class Persona(val nombre: String, val apellidos: String, var experiencia: Int)

val persona1 = Persona("Juan", "Pérez", 99)
val (nombre, apellidos, experiencia) = persona1
println(nombre) // Juan
println(apellidos) // Pérez
println(experiencia) // 99

val (nombre2, _, experiencia2) = persona1
println(nombre2) // Juan
println(experiencia2) // 99
```

## Atributos y métodos de clase
Un atributo de clase es una variable miembro que no se asocia a un objeto (instancia) de una clase, sino que se asocia a la clase misma; no hay una copia del dato para cada objeto sino una sola copia que es compartida por todos los objetos de la clase. El acceso a las variables estáticas desde fuera de la clase donde se definen se realiza a través del nombre de la clase y no del nombre del objeto como sucede con las variables miembro normales (no estática). 

Para los métodos, la idea es la misma que para los datos: los métodos de clase se asocian a una clase, no a una instancia. Los métodos de clase se pueden invocar sin necesidad de crear una instancia de la clase.

En Java podemos definir atributos y métodos estáticos con la palabra reservada static. En Kotlin, no existe la palabra reservada static, pero podemos definir atributos y métodos de clases a través de companion object. Los atributos y métodos de companion object se pueden acceder sin necesidad de crear una instancia de la clase, es decir, un objeto.

```kotlin
class Persona(val nombre: String, val apellidos: String, var experiencia: Int) {
    val id = Persona.nextId()

    override toString(): String {
        return "Persona(id=$id, nombre=$nombre, apellidos=$apellidos, experiencia=$experiencia)"
    }

    // Definimos un companion object, es decir los atributos y metodos de clase
    companion object {
        var contador = 0
        private fun nextId() {
            return contador++
        }

        fun gritar() {
            println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
        }
    }
}

val persona1 = Persona("Juan", "Pérez", 99)
println(persona1) // Persona(id=1, nombre=Juan, apellidos=Pérez, experiencia=99)
val persona2 = Persona("Pepe", "García", 99)
println(persona2) // Persona(id=2, nombre=Pepe, apellidos=García, experiencia=99)
val persona3 = Persona("Ana", "García", 99)
println(persona3) // Persona(id=3, nombre=Ana, apellidos=García, experiencia=99)

Persona.gritar() // ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
```


## Enums class
Los tipos enumerados son una forma de definir un conjunto de constantes. En Kotlin, los tipos enumerados se definen con la palabra reservada enum class. Los valores de un tipo enumerado se pueden acceder con el nombre de la clase y el nombre del valor separados por un punto. A veces es necesario acceder al valor de un tipo enumerado como un objeto, en ese caso podemos usar la función valueOf(). Por otro lado, podemos almacenar un valor en base a su constructor si lo definimos (solo en Kotlin).

```kotlin
// Enums colores
enum class Color {
    ROJO, VERDE, AZUL
}

// Accedemos a los valores del enum
println(Color.ROJO) // ROJO
println(Color.VERDE) // VERDE
println(Color.AZUL) // AZUL

// Accedemos a los valores del enum como objetos
println(Color.valueOf("ROJO")) // ROJO
println(Color.valueOf("VERDE")) // VERDE
println(Color.valueOf("AZUL")) // AZUL

// saber el orden de los valores del enum
println(Color.ROJO.ordinal) // 0
println(Color.VERDE.ordinal) // 1

// Obtener values del enum
val colores = Color.values()
println(colores) // [ROJO, VERDE, AZUL]

// Enums con constructor, solo en Kotlin
enum class Color(val rgb: Int) {
    ROJO(0xFF0000),
    VERDE(0x00FF00),
    AZUL(0x0000FF)
}

// Accedemos a los valores del enum
println(Color.ROJO) // ROJO
// Obtenemos el valor rgb
println(Color.ROJO.rgb) // 0xFF0000
```

## Paquetes y visibilidad
En Kotlin, los paquetes son un mecanismo para organizar el código fuente. Los paquetes se definen con la palabra reservada package. Los paquetes se utilizan para evitar conflictos de nombres entre clases con el mismo nombre. Por ejemplo, si tenemos dos clases con el mismo nombre en dos paquetes diferentes, podemos acceder a ellas con su nombre de paquete.


```kotlin
// Definimos un paquete
package com.joseluisgs

// Definimos una clase
class Persona(val nombre: String, val apellidos: String)
```

Para usar una clase de otro paquete, debemos importarla con la palabra reservada import. Si queremos importar todas las clases de un paquete, podemos usar el operador *.

```kotlin
// importamos una clase
import com.joseluisgs.Persona

// importamos todas las clases de un paquete
import com.joseluisgs.*
```

### Alias
Podemos usar alias para importar clases de otros paquetes. Esto es útil cuando tenemos clases con el mismo nombre en diferentes paquetes.

```kotlin
// importamos una clase con alias
import com.joseluisgs.Persona as PersonaJoseluisgs
import com.joseluisgs.Persona as PersonaJoseluisgs2
```

### Visibilidad
En Kotlin, podemos definir la visibilidad de las clases, funciones y propiedades. Por defecto, las clases, funciones y propiedades son públicas. Si queremos que una clase, función o propiedad sea privada, debemos usar la palabra reservada private. Si queremos que una clase, función o propiedad sea interna, debemos usar la palabra reservada internal. Si queremos que una clase, función o propiedad sea protegida, debemos usar la palabra reservada protected.
- public: Puede ser accedido desde cualquier lugar.
- private: Solo puede ser accedido desde la clase que lo define.
- internal: Solo puede ser accedido desde el mismo módulo/Paquete.
- protected: Solo puede ser accedido desde la clase que lo define y sus subclases.


## Composición de objetos
La composición de objetos es una forma de reutilizar código. Consiste en crear una clase que contenga como atributos objetos de otras clases. De esta forma, podemos reutilizar los métodos de las clases que componen la clase que estamos creando.

Si es una relación 1-1 asignamos el objeto como atributo de la clase. Si es una relación 1-N asignamos una colección de objetos como atributo de la clase.

```kotlin
// una persona tiene un coche
data class Coche(val marca: String, val modelo: String, val color: String)
data class Persona(val nombre: String, val apellidos: String, val coche: Coche)

// una persona tiene varios coches
data class Persona(val nombre: String, val apellidos: String, val coches: Array<Coche>)
```

## Clases internas y anidadas
Una forma de hacer una composición fuerte es el uso de las clases internas son clases que se definen dentro de otras clases y que pueden acceder a los atributos y métodos de la clase que las contiene. Las clases internas pueden ser privadas o públicas. Si una clase interna es privada, solo puede ser accedida desde la clase que la contiene. Si una clase interna es pública, puede ser accedida desde cualquier lugar.

En Kotlin si usamos el modificador inner, la clase interna podrá acceder a los atributos y métodos de la clase que la contiene, de otra forma no

```kotlin
class Persona(val nombre: String, val apellidos: String) {
    // Clase interna, con inner puede acceder a los atributos de la clase que la contiene
    inner class Coche(val marca: String, val modelo: String, val color: String) {
        fun mostrar() {
            println("Coche de $nombre: $marca $modelo $color")
        }
    }
}

fun main() {
    val persona = Persona("Pepe", "Perez")
    val coche = persona.Coche("Renault", "Megane", "Azul")
    coche.mostrar() // Coche de Pepe: Renault Megane Azul
}
```

Muchas veces veras que los enums se definen como clases anidadas, siempre que su campo de acción sea esa propia clase que los necesita y nos ahorramos tener que crear una clase nueva.

```kotlin
class Persona(val nombre: String, val apellidos: String, val sexo: Sexo = Sexo.OTRO) {
    enum class Sexo {
        HOMBRE, MUJER, OTRO
    }
}

fun main() {
    val persona = Persona("Pepe", "Perez", Persona.Sexo.HOMBRE)
    println(persona.sexo) // HOMBRE
}
```

## Inyección de dependencias

Debemos tener en cuenta que cuando componemos asignamos un objeto de una clase a un atributo de otra clase. Si usamos clases anidadas o internas, damos por hecho que el objeto que componemos nunca podrá ser accedido desde fuera de la clase que lo contiene. Si queremos que el objeto que componemos pueda ser accedido desde fuera de la clase que lo contiene, debemos usar la composición tal y como hemos visto anteriormente.

Por lo tanto debemos inyectar el objeto que componemos en el constructor de la clase que lo contiene, esto es lo que se conoce como inyección de dependencias.

```kotlin
class Persona(val nombre: String, val apellidos: String) {
    // Clase interna, con inner puede acceder a los atributos de la clase que la contiene
    inner class Coche(val marca: String, val modelo: String, val color: String) {
        fun mostrar() {
            println("Coche de $nombre: $marca $modelo $color")
        }
    }
}

// No existe el coche fuera de la clase Persona
fun main() {
    val persona = Persona("Pepe", "Perez")
    val coche = persona.Coche("Renault", "Megane", "Azul")
    coche.mostrar() // Coche de Pepe: Renault Megane Azul
    println(coche) // Error
}

// Si queremos que el coche tenga naturaleza y existencia independiente de la persona usamos composición, no clases internas
// Para ello debemos inyectar la dependencia necesaria.
data class Coche(val marca: String, val modelo: String, val color: String)
data class Persona(val nombre: String, val apellidos: String, val coche: Coche)

fun main() {
    val coche = Coche("Renault", "Megane", "Azul")
    val persona = Persona("Pepe", "Perez", coche)
    println(persona) // Persona(nombre=Pepe, apellidos=Perez, coche=Coche(marca=Renault, modelo=Megane, color=Azul))
    println(coche) // Coche(marca=Renault, modelo=Megane, color=Azul)
}
```

## Singleton
El patrón singleton es un patrón de diseño que nos permite tener una única instancia de una clase. Por mucho que instanciamos un objeto, siempre nos devolverá la instancia original. En Kotlin podemos usar el modificador object para crear una objetos siguiendo el patrón singleton. 

```kotlin
// Sin object es una clase normal con constructor privado y instancia pública de clase
class Persona private constructor(val nombre: String, val apellidos: String) {
    companion object {
        private var persona: Persona? = null
        fun getInstance(nombre: String, apellidos: String): Persona {
            if (persona == null) {
                persona = Persona(nombre, apellidos)
            }
            return persona!!
        }
    }
}

fun main() {
    val persona1 = Persona.getInstance("Pepe", "Perez")
    val persona2 = Persona.getInstance("Juan", "García")
    println(persona1) // Persona(nombre=Pepe, apellidos=Perez)
    println(persona2) // Persona(nombre=Pepe, apellidos=Perez)
}
```

```kotlin
// Con object
object Persona {
    var nombre: String = ""
    var apellidos: String = ""
}

fun main() {
    Persona.nombre = "Pepe"
    Persona.apellidos = "Perez"
    println(Persona) // Persona(nombre=Pepe, apellidos=Perez)
}
```

## Factory
El patrón factory es un patrón de diseño que nos permite crear objetos de una clase sin tener que conocer la clase que los crea o poder especificar casos concretos. En Kotlin podemos usar el modificador object para crear una objetos siguiendo el patrón factory, funciones u otras clases. 

```kotlin
// Ejemplo de clase con factory
class Persona(val nombre: String, val apellidos: String) {

    enum class Sexo {
        HOMBRE, MUJER, OTRO
    }

    companion object {
        fun createHombre(nombre: String, apellidos: String): Persona {
            return Persona(nombre, apellidos, Sexo.HOMBRE)
        }

        fun createMujer(nombre: String, apellidos: String): Persona {
            return Persona(nombre, apellidos, Sexo.MUJER)
        }

        fun create(nombre: String, apellidos: String): Persona {
            return Persona(nombre, apellidos, Sexo.OTRO)
        }
    }
}

fun main() {
    val persona1 = Persona.createHombre("Pepe", "Perez")
    val persona2 = Persona.createMujer("Juan", "García")
    val persona3 = Persona.create("Ana", "García")
    println(persona1) // Persona(nombre=Pepe, apellidos=Perez, sexo=HOMBRE)
    println(persona2) // Persona(nombre=Juan, apellidos=García, sexo=MUJER)
    println(persona3) // Persona(nombre=Ana, apellidos=García, sexo=OTRO)
}
```
## Fachada
El patrón fachada es un patrón de diseño que nos permite crear una interfaz simplificada para acceder a una funcionalidad compleja. Podemos decir, que es como preguntarle a alguien que encapsula una funcionalidad que puede estar repartada entre distintos objetos o métodos.
```kotlin
class Ventana {
    fun abrir() {
        println("Ventana abierta")
    }

    fun cerrar() {
        println("Ventana cerrada")
    }
}

class Puerta {
    fun abrir() {
        println("Puerta abierta")
    }

    fun cerrar() {
        println("Puerta cerrada")
    }
}

// Casa tiene como dependencias a Ventana y Puerta y ademas es la fachada para acceder a ellas y simplificar su uso
class Casa {
    private val ventana = Ventana()
    private val puerta = Puerta()

    fun abrirVentana() {
        ventana.abrir()
    }

    fun cerrarVentana() {
        ventana.cerrar()
    }

    fun abrirPuerta() {
        puerta.abrir()
    }

    fun cerrarPuerta() {
        puerta.cerrar()
    }

    fun abrirTodo() {
        abrirVentana()
        abrirPuerta()
    }

    fun cerrarTodo() {
        cerrarVentana()
        cerrarPuerta()
    }
}
```

## Herencia
Herencia: propiedad que nos permite crear nuevas clases a partir de clases existentes, conservando propiedades de la clase original e incorporando otras nuevas.

La nueva clase obtenida se llama clase derivada o hija y la clase a partir de la cual se crea se llama clase base o padre.
Con la herencia, las clases se clasifican en una jerarquía estricta. Cada clase tiene una superclase (de la cual hereda) y una o varias subclases (que derivan de ella).

Ventajas: cada vez que se crea un objeto derivado se crea un solo objeto que contiene toda la información heredada. El programa será más flexible a cambios y ampliaciones.

Tenderemos que tener en cuenta que:
- Las clases/métodos pueden ser abiertas o cerradas. Las clases cerradas no pueden ser heredadas.
- Las clases/métodos pueden ser abstractas o concretas. Las clases abstractas no pueden ser instanciadas. Los métodos abstractos no tienen implementación y deben ser implementados en las clases derivadas.

En Kotlin, la herencia de clases y métodos se realiza mediante la palabra reservada **open** (son cerradas por defecto). Podemos sobreescribir métodos de la clase padre con la palabra reservada **override**. Podemos acceder a los métodos de la clase padre con la palabra reservada **super**. Usamos los constructores para definir el estado propio no heredado de la clase, llamando al constructor de la clase con el estado que necesita, ya sea en constructores primarios o secundarios.

```kotlin
abstract class Vehiculo(val marca: String, val modelo: String) {
    abstract fun arrancar()
    abstract fun parar()

    open fun acelerar() {
        println("Acelerando...")
    }
}

class Coche(marca: String, modelo: String, val color: String) : Vehiculo(marca, modelo) {
    override fun arrancar() {
        println("Arrancando...")
    }

    override fun parar() {
        println("Parando...")
    }

    override fun acelerar() {
        super.acelerar()
        println("Acelerando más...")
    }
}
```

## Modificadores de acceso
- **public**: Acceso público. Por defecto.
- **private**: Acceso privado. Solo se puede acceder desde la clase que lo define.
- **protected**: Acceso protegido. Solo se puede acceder desde la clase que lo define y sus subclases.
- **internal**: Acceso interno. Solo se puede acceder desde el mismo módulo.

## Polimorfismo
El polimorfismo es la propiedad por la cual es posible referirse a un objeto de una superclase de varias formas diferentes, cada una de las cuales define un comportamiento específico. 

El polimorfismo tiene que ver con la relación que se establece entre la llamada a un método y el código que efectivamente se ejecuta. A esta relación se le llama vinculación o binding. Puede ser:
-Temprana: se conocer en tiempo de compilación (sobrecarga).
-Tardía: se conoce en tiempo de ejecución (override o redefinición).

Esta vinculación permite que, si tenemos un método redefinido en carias clases, sea el tipo de objeto y no la referencia en sí la que determine qué método se ejecuta.

Es  importante saber que el polimorfismo no es una propiedad de los objetos, sino de las referencias. Si tenemos una referencia de tipo padre, podemos asignarle un objeto de tipo hijo, pero no al revés. Es importante para poder descartar la posibilidad de que el objeto hijo no tenga el método que se está llamando, por lo que se recmienda hacer un casting a la clase hija si se quiere llamar a un método que no está en la clase padre.

```kotlin
open class Vehiculo(val marca: String, val modelo: String) {
    open fun arrancar() {
        println("Arrancando...")
    }

    open fun parar() {
        println("Parando...")
    }

    open fun acelerar() {
        println("Acelerando...")
    }
}

class Coche(marca: String, modelo: String, val color: String) : Vehiculo(marca, modelo) {
    override fun arrancar() {
        println("Arrancando...")
    }

    override fun parar() {
        println("Parando...")
    }

    override fun acelerar() {
        super.acelerar()
        println("Acelerando más...")
    }

    fun pintar(color: String) {
        this.color = color
    }
}

class Moto(marca: String, modelo: String, val cilindrada: Int) : Vehiculo(marca, modelo) {
    override fun arrancar() {
        println("Arrancando...")
    }

    override fun parar() {
        println("Parando...")
    }

    override fun acelerar() {
        super.acelerar()
        println("Acelerando más...")
    }
}

fun main() {
    val coche = Coche("Seat", "Ibiza", "Rojo")
    val moto = Moto("Yamaha", "MT-07", 689)

    coche.arrancar()
    coche.acelerar()
    coche.parar()
    coche.pintar("Azul")

    moto.arrancar()
    moto.acelerar()
    moto.parar()

    val vehiculos = arrayOf(coche, moto)
    for (vehiculo in vehiculos) {
        vehiculo.arrancar()
        vehiculo.acelerar()
        vehiculo.parar()
        if (vehiculo is Coche) {
            vehiculo.pintar("Verde")
        }
    }
}
```

## Interfaces
Las interfaces son un conjunto de métodos y variables (finales) que no estan obligadas a tener implementación. Son similares a una clase asbtracta. Se definen con la palabra reservada interface. Una clase puede implementar una o varias interfaces. Su objetivo es fijar un comportamiento o contrato que las clases están obligadas a cumplir, ya sea redefiniendo los métodos o aceptando la implementación por defecto si la hay.

Una interfaz también nos sirve para tipar una variable, ya que al ser un contrato, podemos asegurar que la variable que estamos usando cumple con ese contrato.

```kotlin
interface Vehiculo {
    fun arrancar()
    fun parar()
    fun acelerar() {
        println("Acelerando...")
    }
}

class Coche(val marca: String, val modelo: String, val color: String) : Vehiculo {
    override fun arrancar() {
        println("Arrancando...")
    }

    override fun parar() {
        println("Parando...")
    }

    override fun acelerar() {
        println("Acelerando...")
    }

    fun pintar(color: String) {
        this.color = color
    }
}

class Moto(val marca: String, val modelo: String, val cilindrada: Int) : Vehiculo {
    override fun arrancar() {
        println("Arrancando...")
    }

    override fun parar() {
        println("Parando...")
    }

    override fun acelerar() {
        println("Acelerando...")
    }
}

fun main() {
    val coche = Coche("Seat", "Ibiza", "Rojo")
    val moto = Moto("Yamaha", "MT-07", 689)

    coche.arrancar()
    coche.acelerar()
    coche.parar()
    coche.pintar("Azul")

    moto.arrancar()
    moto.acelerar()
    moto.parar()

    val vehiculos = arrayOf(coche, moto)
    for (vehiculo in vehiculos) {
        vehiculo.arrancar()
        vehiculo.acelerar()
        vehiculo.parar()
        if (vehiculo is Coche) {
            vehiculo.pintar("Verde")
        }
    }
}
```

## Sealed Classes
Las clases selladas son una forma de definir una jerarquía de clases que no se pueden extender fuera de ese fichero. Se definen con la palabra reservada sealed. Se usan para definir un conjunto de clases que tienen un comportamiento en común y que no queremos que se extiendan fuera de ese fichero. Ideales para tipar. En el fondo una sealed class es uan clase asbtracta  y sus clases hijas son clases normales pero definidas todas en el mismo fichero.

```kotlin
sealed class Vehiculo {
    abstract val marca: String
    abstract val modelo: String
    abstract val color: String

    fun arrancar() {
        println("Arrancando...")
    }

    fun parar() {
        println("Parando...")
    }

    fun acelerar() {
        println("Acelerando...")
    }
}

class Coche(override val marca: String, override val modelo: String, override val color: String) : Vehiculo() {
    fun pintar(color: String) {
        this.color = color
    }
}

class Moto(override val marca: String, override val modelo: String, val cilindrada: Int) : Vehiculo() 

fun main() {
    val coche = Coche("Seat", "Ibiza", "Rojo")
    val moto = Moto("Yamaha", "MT-07", 689)

    coche.arrancar()
    coche.acelerar()
    coche.parar()
    coche.pintar("Azul")

    moto.arrancar()
    moto.acelerar()
    moto.parar()

    val vehiculos = arrayOf(coche, moto)
    for (vehiculo in vehiculos) {
        vehiculo.arrancar()
        vehiculo.acelerar()
        vehiculo.parar()
        if (vehiculo is Coche) {
            vehiculo.pintar("Verde")
        }
    }
}
```

## Smart Casts
Los smart casts se usa para evitar el uso de is y as contínuamente. Está pensando para tipar variables. Se usa con la palabra reservada is. Cuando usamos is, el compilador sabe que la variable es de ese tipo y por tanto podemos acceder a sus propiedades y métodos sin necesidad de usar as. 
- is: Comprueba si la variable es de ese tipo y si es así, el compilador sabe que es de ese tipo y por tanto podemos acceder a sus propiedades y métodos sin necesidad de usar as.
- !is: Comprueba si la variable no es de ese tipo.
- as: Convierte una variable a un tipo. Si no es de ese tipo, lanza una excepción. 
- as?: Convierte una variable a un tipo. Si no es de ese tipo, devuelve null.
  
```kotlin
open class Vehiculo {
    open val marca: String = ""
    open val modelo: String = ""
    open val color: String = ""

    fun arrancar() {
        println("Arrancando...")
    }

    fun parar() {
        println("Parando...")
    }

    fun acelerar() {
        println("Acelerando...")
    }
}

class Coche(override val marca: String, override val modelo: String, override val color: String) : Vehiculo() {
    fun pintar(color: String) {
        this.color = color
    }
}

class Moto(override val marca: String, override val modelo: String, val cilindrada: Int) : Vehiculo()

fun main() {
    val coche = Coche("Seat", "Ibiza", "Rojo")
    val moto = Moto("Yamaha", "MT-07", 689)

    coche.arrancar()
    coche.acelerar()
    coche.parar()
    coche.pintar("Azul")

    moto.arrancar()
    moto.acelerar()
    moto.parar()

    val vehiculos = arrayOf(coche, moto)
    for (vehiculo in vehiculos) {
        vehiculo.arrancar()
        vehiculo.acelerar()
        vehiculo.parar()
        if (vehiculo is Coche) {
            vehiculo.pintar("Verde")
        }
    }

    val vehiculo: Vehiculo = coche
    val coche = vehiculo as Coche
    coche.pintar("Azul")
    val coche2 = vehiculo as? Coche
    coche2?.pintar("Azul")
}
```

## Inlining
El inlining es una técnica que permite que el compilador copie el código de una función en el lugar donde se llama a la función. Esto permite que el código sea más eficiente y que se pueda optimizar mejor. Se usa con la palabra reservada inline. Con las clases nos permitirá crear un wrapper sobre algún tipo y con ello agilizar su lectura y el código limpio.

```kotlin
@JvmInline
value class IdAlumno(val id: Int)
@JvmInline
value class IdModulo(val id: Int)
@JvmInline
value class IdCentro(val id: Int)

class Alumno(
    val id: IdAlumno,
    val idModlulo: IdModulo,
    val idCentro: IdCentro,
    val nombre: String
)

fun main() {
    //val alumno = Alumno(1, 2, 3, "Nombre")
    val alumno = Alumno(IdAlumno(1), IdModulo(2), IdCentro(3), "Nombre")
}
```

## Type Aliases
Podemos hacer un alias de un tipo de dato. Esto nos permite cambiar el nombre de un tipo de dato y que sea más legible. Se usa con la palabra reservada typealias.
```kotlin
ypealias IdAlumno2 = Int
typealias IdModulo2 = Int
typealias IdCentro2 = Int

typealias ArrayAlumno = Array<Alumno2>
// typealias MatrizAlumno = Array<Array<Alumno2>>
typealias MatrizAlumno = Array<ArrayAlumno>

class Alumno2(
    val id: IdAlumno2,
    val idModlulo: IdModulo2,
    val idCentro: IdCentro2,
    val nombre: String
)


fun main() {
    //val alumno = Alumno(1, 2, 3, "Nombre")
    val alumno = Alumno2(1, 2, 3, "Nombre")

    val array: ArrayAlumno = arrayOf(
        Alumno2(1, 2, 3, "Nombre"),
        Alumno2(1, 2, 3, "Nombre"),
        Alumno2(1, 2, 3, "Nombre")
    )

    for (alumno in array) {
        println(alumno)
    }

    val matriz = MatrizAlumno(3) {
        ArrayAlumno(3) { Alumno2(1, 2, 3, "Nombre") }
    }

    for (fila in matriz) {
        for (alumno in fila) {
            println(alumno)
        }
    }
}
```

Ademas podemos hacer alias de los imports si tenemos dos clases que se llaman igual. Esto nos permite usar el alias en vez del nombre completo.
```kotlin
import java.util.Date as UtilDate
import java.sql.Date as SqlDate

fun main() {
    val utilDate = UtilDate()
    val sqlDate = SqlDate(utilDate.time)
    println(utilDate)
    println(sqlDate)
}
```

## Inicialización tardía y perezosa
En Kotlin podemos inicializar las variables de forma perezosa y tardía. Esto nos permite inicializarlas cuando se necesiten y no antes. Esto nos permite ahorrar recursos y que el código sea más eficiente.
- lateinit: Se usa para inicializar una variable de forma tardía. Se usa con variables no nulas. Se usa con var. Debemos inicializarla antes de usarla, si no nos dará una excepción.
- lazy: Se usa para inicializar una variable de forma perezosa. Se usa con variables no nulas. Se usa con val. Se inicializa cuando se usa por primera vez.
```kotlin
class Alumno(
    val id: Int,
    val nombre: String
) {
    lateinit var fecha: Date
    val fecha2: Date by lazy { Date() }

    fun init() {
        fecha = Date()
    }
}

fun main() {
    val alumno = Alumno(1, "Nombre")
    alumno.init()
    println(alumno.fecha)
    println(alumno.fecha2)
}
```

## Recursos
- Twitter: https://twitter.com/joseluisgonsan
- GitHub: https://github.com/joseluisgs
- Web: https://joseluisgs.github.io
- Discord del módulo: https://discord.gg/RRGsXfFDya
- Aula DAMnificad@s: https://discord.gg/XT8G5rRySU


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/joseluisgonsan)

[![Twitter](https://img.shields.io/twitter/follow/joseluisgonsan?style=social)](https://twitter.com/joseluisgonsan)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto
<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.github.io/" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/joseluisgonsan" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://discordapp.com/users/joseluisgs#3560" target="_blank">
        <img src="https://logodownload.org/wp-content/uploads/2017/11/discord-logo-4-1.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>    
</p>

### ¿Un café?
<p><a href="https://www.buymeacoffee.com/joseluisgs"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" height="50" alt="joseluisgs" /></a></p><br><br><br>

## Licencia de uso

Este repositorio y todo su contenido está licenciado bajo licencia **Creative Commons**, si desea saber más, vea la [LICENSE](https://joseluisgs.github.io/docs/license/). Por favor si compartes, usas o modificas este proyecto cita a su autor, y usa las mismas condiciones para su uso docente, formativo o educativo y no comercial.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">JoseLuisGS</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="https://joseluisgs.github.io/" property="cc:attributionName" rel="cc:attributionURL">José Luis González Sánchez</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional License</a>.<br />Creado a partir de la obra en <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/joseluisgs" rel="dct:source">https://github.com/joseluisgs</a>.
