# Quásar Fire Operation by Rebel Alliance

Programa en Java que retorna la fuente y contenido del mensaje de auxilio de una nave en el espacio. Para esto, cuenta con tres satélites que te permitirán triangular la posición utilizando el método de Trilateración.

### Estructura del proyecto

Se hizo teniendo en cuenta los principios de Clean Arquitecture y patrones de diseño SOLID.

### Pre-requisitos 📋

_Herramientas necesarias para correr el proyecto:_

```
1. JDK 17
2. Spring Boot
2. IntelliJ
3. Postman
4. Gradle (Recomendado)
5. Git (Recomendado)
```
## Corriendo el proyecto 🚀

_Para correr el proyecto seguir las siguientes instrucciones:_

```
1. Clonar este repositorio en la rama develop
2. Importar proyecto desde IntelliJ 
3. En la clase QuasarFireApplication dar click derecho y elegir opción Run
```

### Consumo de la API 🔧

**URL:** http://localhost:8081/api/v1

**Servicios:**

- **Send Top Secret:** Retorna la posición de la nave y el mensaje descifrado.

```bash
POST -> /topsecret/
{
    "satellites": [
        {
            "name": "Kenobi",
            "distance": 100.0,
            "message": [
                "este",
                "",
                "",
                "mensaje",
                ""
            ]
        },
        {
            "name": "skywalker",
            "distance": 115.5,
            "message": [
                "",
                "es",
                "",
                "",
                "secreto"
            ]
        },
        {
            "name": "sato",
            "distance": 142.7,
            "message": [
                "este",
                "",
                "un",
                "",
                ""
            ]
        }
    ]
}
```

- **Top Secret Split Satellite:** Actualiza la distancia y el mensaje a un satelite en especifico.

```bash
POST -> topsecret_split/{satellite_name}
{
    "distance": 50.0,
    "message": [
        "este",
        "",
        "",
        "mensaje",
        ""
    ]
}
```

- **Get Top Secret:** Retorna la posición de la nave y el mensaje descifrado usando la información previamente guardada.
```bash
GET -> /topsecret/
```

## Construido con 🛠️

_Herramientas utilizadas_

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [Junit](https://junit.org/junit5/) - Framework de pruebas unitarias



## Autor
* **Julian David Quiroz** 🤓- [JDChuma1108](https://github.com/JDChuma1108)

