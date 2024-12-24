# Sistema de gestion de inventario de una heladeria

Este proyecto se ha realizado con la intencion de practicar pruebas unitarias.
## Mockito

En ocasiones, las pruebas unitarias requieren que se simulen comportamientos de clases o servicios externos. Mockito es una biblioteca que permite crear objetos falsos o simulados (mocks) para inyectarlos en las clases bajo prueba.

mock(IOHandler.class) y mock(IceCreamController.class) crean mocks de la clase especificada dentro de los parentesis

when(...).thenReturn(...) simula las entradas del usuario.

verify(...) asegura que los métodos del mock se llamen con los parámetros correctos.

## JUnit 4

JUnit es un framework de pruebas unitarias para el lenguaje de programación Java.  Las pruebas unitarias son pruebas pequeñas y aisladas que verifican el comportamiento de unidades específicas de código, como un método o una clase.

Anotaciones:

@Test: Se usa para marcar un método como un caso de prueba.

@BeforeEach o @Before: Ejecuta un método antes de cada prueba (usado para configuraciones previas).

@AfterEach o @After: Ejecuta un método después de cada prueba (usado para limpieza o liberación de recursos).

@BeforeAll o @BeforeClass: Ejecuta un método antes de todas las pruebas de la clase (se usa generalmente para configuraciones globales).

@AfterAll o @AfterClass: Ejecuta un método después de todas las pruebas de la clase.

@Disabled: Desactiva una prueba.

## Cobertura de pruebas
La cobertura de pruebas mide qué porcentaje del código fuente está siendo ejecutado por las pruebas unitarias. Una alta cobertura no garantiza que el software sea libre de errores, pero es un buen indicador de que el código está bien probado.

## Inyeccion de dependencias

La Inyección de Dependencias es una técnica en la que un objeto recibe sus dependencias desde el exterior, en lugar de crearlas por sí mismo.  Esto permite que las clases sean más modulares, reutilizables y fáciles de probar.

DI (por sus siglas en ingles Dependency Injection) hace que las clases sean más fáciles de probar porque podemos inyectar dependencias simuladas (mocks o stubs) en lugar de depender de las implementaciones reales. 

Esto es muy útil cuando estamos trabajando con pruebas unitarias, ya que podemos controlar el comportamiento de las dependencias sin necesidad de ejecutar código real.

Hay 3 tipos de inyeccion de dependencias, en este proyecto veremos la mas usada que es inyeccion a traves del contructor.



    // Inyección de dependencia a través del constructor
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

En este caso Tenemos una clase ClienteService que depende de ClienteRepository, pero no crea una instancia de esta clase directamente si no que la inyectamos cuado creamos la instancia de ClienteService!!
