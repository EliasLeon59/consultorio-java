# Sistema de Gestión de Consultorio Médico

## 📌 Descripción del proyecto

Este proyecto consiste en un sistema de gestión para un consultorio médico desarrollado en Java, el cual permite administrar doctores, pacientes y citas médicas de manera organizada.

El sistema incluye un inicio de sesión para el administrador y maneja la persistencia de datos mediante archivos CSV, lo que permite que la información se conserve incluso después de cerrar el programa.

---

## ⚙️ Funcionalidades

- Inicio de sesión de administrador
- Registro de doctores
- Registro de pacientes
- Creación de citas médicas
- Visualización de doctores
- Visualización de pacientes
- Visualización de citas
- Relación entre doctor y paciente en una cita
- Persistencia de datos en archivos CSV

---

## 🧠 Tecnologías utilizadas

- Java
- Programación Orientada a Objetos (POO)
- Manejo de archivos (FileReader, FileWriter, BufferedReader)
- Archivos CSV

---

## 🏗️ Estructura del proyecto

- Persona (clase base)
- Doctor (hereda de Persona)
- Paciente (hereda de Persona)
- Cita (gestiona relación entre doctor y paciente)
- Sistema de archivos CSV para almacenamiento

---

## 💾 Persistencia de datos

El sistema guarda automáticamente la información en archivos `.csv`, lo que permite:

- Mantener doctores registrados
- Mantener pacientes registrados
- Mantener citas guardadas

Aunque el programa se cierre, los datos se conservan y se vuelven a cargar al iniciar.

---

## ▶️ Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA o cualquier IDE de Java
2. Ejecutar la clase principal
3. Iniciar sesión con el usuario administrador
4. Usar el menú para gestionar doctores, pacientes y citas

---

## 👨‍💻 Autor

Desarrollado por: Elías León

Este proyecto fue realizado como práctica de Programación Orientada a Objetos en Java, aplicando estructuras reales de un sistema administrativo.

---

## 📌 Nota personal

Este proyecto me ayudó a comprender mejor la programación orientada a objetos, especialmente la relación entre clases, la persistencia de datos y la importancia de estructurar un sistema completo desde cero.
