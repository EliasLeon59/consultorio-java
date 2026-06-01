# Sistema de Gestión de Consultorio Médico

## Descripción del proyecto

Este proyecto consiste en un sistema de gestión para un consultorio médico desarrollado en Java, el cual permite administrar doctores, pacientes y citas médicas de manera organizada.

El sistema incluye un inicio de sesión para el administrador y maneja la persistencia de datos mediante archivos CSV, permitiendo que la información se conserve incluso después de cerrar el programa.

## Funcionalidades

- Inicio de sesión de administrador.
- Registro de doctores.
- Registro de pacientes.
- Creación de citas médicas.
- Visualización de doctores registrados.
- Visualización de pacientes registrados.
- Visualización de citas médicas.
- Relación entre doctor y paciente en cada cita.
- Persistencia de datos mediante archivos CSV.

## Tecnologías utilizadas

- Java 11
- Programación Orientada a Objetos (POO)
- IntelliJ IDEA
- Git
- GitHub
- FileReader
- FileWriter
- BufferedReader
- Archivos CSV

## Instalación y configuración

1. Instalar Java Development Kit (JDK) versión 11.
2. Instalar IntelliJ IDEA.
3. Instalar Git.
4. Clonar o descargar el repositorio desde GitHub.
5. Abrir el proyecto en IntelliJ IDEA.
6. Verificar que exista la carpeta **db** para el almacenamiento de archivos CSV.
7. Ejecutar la clase **Main.java**.

## Uso del programa

1. Ejecutar la aplicación.
2. Iniciar sesión con las credenciales del administrador.
3. Registrar doctores.
4. Registrar pacientes.
5. Crear citas médicas.
6. Consultar la información almacenada.
7. Cerrar la aplicación cuando se desee.

### Credenciales predeterminadas

Usuario:

```text
admin
```

Contraseña:

```text
admin123
```

## Persistencia de datos

La aplicación almacena la información en archivos CSV dentro de la carpeta **db**.

Los datos que se almacenan son:

- Doctores registrados.
- Pacientes registrados.
- Citas médicas registradas.

Al volver a ejecutar el programa, la información es cargada automáticamente desde los archivos CSV existentes.

## Estructura del proyecto

### Clases principales

- **Persona:** clase abstracta base para los usuarios del sistema.
- **Doctor:** representa a los doctores registrados.
- **Paciente:** representa a los pacientes registrados.
- **Cita:** representa una cita médica y relaciona un doctor con un paciente.
- **Administrador:** representa al usuario con acceso al sistema.

### Clases de servicio

- **LoginService:** valida las credenciales de acceso.
- **ArchivoManager:** administra la lectura y escritura de archivos CSV.
- **CitaService:** administra la creación y búsqueda de citas.

### Interfaz

- **Menu:** administra la interacción con el usuario mediante consola.
- **Main:** punto de inicio de la aplicación.

## Créditos

Desarrollado por:

**Bernardo Elias León León**

Proyecto realizado para la materia de Computación en Java.

## Licencia

Este proyecto fue desarrollado con fines académicos y educativos.

Su distribución y uso están permitidos únicamente para actividades relacionadas con el aprendizaje y la práctica de programación.

## Nota personal

Este proyecto me ayudó a comprender mejor la programación orientada a objetos, especialmente la herencia, el uso de clases abstractas, la relación entre objetos y la persistencia de datos mediante archivos CSV. También reforcé mis conocimientos en Git, GitHub y el manejo de excepciones para desarrollar una aplicación más completa y funcional.
