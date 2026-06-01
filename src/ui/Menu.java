package ui;

import model.Doctor;
import model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;
import model.Cita;
import service.ArchivoManager;

public class Menu {

    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;
    private ArchivoManager archivoManager;

    public Menu() {

        archivoManager = new ArchivoManager();

        doctores = archivoManager.cargarDoctores();
        pacientes = archivoManager.cargarPacientes();

        citas = archivoManager.cargarCitas(
                doctores,
                pacientes
        );

    }

    public void mostrarMenu() {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE CITAS =====");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Mostrar doctores");
            System.out.println("5. Mostrar pacientes");
            System.out.println("6. Mostrar citas");
            System.out.println("7. Salir");

            try {

                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

            } catch (Exception e) {

                System.out.println(
                        "Debe ingresar un número."
                );

                scanner.nextLine();

                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    registrarDoctor(scanner);
                    break;

                case 2:
                    registrarPaciente(scanner);
                    break;

                case 3:
                    crearCita(scanner);
                    break;

                case 4:
                    mostrarDoctores();
                    break;

                case 5:
                    mostrarPacientes();
                    break;

                case 6:
                    mostrarCitas();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

    }
    private void registrarDoctor(Scanner scanner) {

        System.out.print("ID del doctor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombre, especialidad);

        doctores.add(doctor);

        archivoManager.guardarDoctor(doctor);

        System.out.println("Doctor registrado correctamente.");
    }
    private void registrarPaciente(Scanner scanner) {

        System.out.print("ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombre);

        pacientes.add(paciente);

        archivoManager.guardarPaciente(paciente);

        System.out.println("Paciente registrado correctamente.");
    }
    private void mostrarDoctores() {

        System.out.println("\n--- LISTA DE DOCTORES ---");

        for (Doctor doctor : doctores) {

            System.out.println(
                    "ID: " + doctor.getId()
                            + " | Nombre: " + doctor.getNombreCompleto()
                            + " | Especialidad: " + doctor.getEspecialidad()
            );

        }
    }
    private void mostrarPacientes() {

        System.out.println("\n--- LISTA DE PACIENTES ---");

        for (Paciente paciente : pacientes) {

            System.out.println(
                    "ID: " + paciente.getId()
                            + " | Nombre: " + paciente.getNombreCompleto()
            );

        }
    }
    private void crearCita(Scanner scanner) {

        if (doctores.isEmpty() || pacientes.isEmpty()) {

            System.out.println("Debe existir al menos un doctor y un paciente.");
            return;
        }

        System.out.print("ID de la cita: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Fecha y hora: ");
        String fechaHora = scanner.nextLine();

        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.println("\nSeleccione un doctor:");

        for (Doctor doctor : doctores) {
            System.out.println(
                    doctor.getId() + " - "
                            + doctor.getNombreCompleto()
            );
        }

        int idDoctor = scanner.nextInt();

        Doctor doctorSeleccionado = null;

        for (Doctor doctor : doctores) {
            if (doctor.getId() == idDoctor) {
                doctorSeleccionado = doctor;
                break;
            }
        }

        System.out.println("\nSeleccione un paciente:");

        for (Paciente paciente : pacientes) {
            System.out.println(
                    paciente.getId() + " - "
                            + paciente.getNombreCompleto()
            );
        }

        int idPaciente = scanner.nextInt();

        Paciente pacienteSeleccionado = null;

        for (Paciente paciente : pacientes) {
            if (paciente.getId() == idPaciente) {
                pacienteSeleccionado = paciente;
                break;
            }
        }

        Cita cita = new Cita(
                id,
                fechaHora,
                motivo,
                doctorSeleccionado,
                pacienteSeleccionado
        );

        citas.add(cita);

        archivoManager.guardarCita(cita);

        System.out.println("Cita creada correctamente.");
    }
    private void mostrarCitas() {

        System.out.println("\n--- LISTA DE CITAS ---");

        for (Cita cita : citas) {

            System.out.println(
                    "ID: " + cita.getId()
                            + " | Fecha y Hora: " + cita.getFechaHora()
                            + " | Motivo: " + cita.getMotivo()
                            + " | Doctor: " + cita.getDoctor().getNombreCompleto()
                            + " | Paciente: " + cita.getPaciente().getNombreCompleto()
            );

        }
    }
}