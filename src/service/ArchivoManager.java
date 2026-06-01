package service;

import model.Doctor;
import model.Paciente;
import java.io.FileWriter;
import java.io.IOException;
import model.Cita;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import service.CitaService;

public class ArchivoManager {

    public void guardarDoctor(Doctor doctor) {

        try {

            FileWriter writer = new FileWriter(
                    "db/doctores.csv",
                    true
            );

            writer.write(
                    doctor.getId() + ","
                            + doctor.getNombreCompleto() + ","
                            + doctor.getEspecialidad()
                            + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar doctor: "
                            + e.getMessage()
            );

        }

    }
    public ArrayList<Doctor> cargarDoctores() {

        ArrayList<Doctor> doctores = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("db/doctores.csv")
                    );

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String especialidad = datos[2];

                Doctor doctor =
                        new Doctor(
                                id,
                                nombre,
                                especialidad
                        );

                doctores.add(doctor);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println(
                    "No se pudieron cargar doctores."
            );

        }

        return doctores;
    }
    public ArrayList<Paciente> cargarPacientes() {

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("db/pacientes.csv")
                    );

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                Paciente paciente =
                        new Paciente(
                                id,
                                nombre
                        );

                pacientes.add(paciente);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println(
                    "No se pudieron cargar pacientes."
            );

        }

        return pacientes;
    }
    public void guardarPaciente(Paciente paciente) {

        try {

            FileWriter writer = new FileWriter(
                    "db/pacientes.csv",
                    true
            );

            writer.write(
                    paciente.getId() + ","
                            + paciente.getNombreCompleto()
                            + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar paciente: "
                            + e.getMessage()
            );

        }

    }
    public void guardarCita(Cita cita) {

        try {

            FileWriter writer = new FileWriter(
                    "db/citas.csv",
                    true
            );

            writer.write(
                    cita.getId() + ","
                            + cita.getFechaHora() + ","
                            + cita.getMotivo() + ","
                            + cita.getDoctor().getNombreCompleto() + ","
                            + cita.getPaciente().getNombreCompleto()
                            + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar cita: "
                            + e.getMessage()
            );

        }

    }
    public ArrayList<Cita> cargarCitas(
            ArrayList<Doctor> doctores,
            ArrayList<Paciente> pacientes) {

        ArrayList<Cita> citas = new ArrayList<>();

        CitaService citaService = new CitaService();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("db/citas.csv")
                    );

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String fechaHora = datos[1];
                String motivo = datos[2];

                String nombreDoctor = datos[3];
                String nombrePaciente = datos[4];

                Doctor doctor =
                        citaService.buscarDoctorPorNombre(
                                nombreDoctor,
                                doctores
                        );

                Paciente paciente =
                        citaService.buscarPacientePorNombre(
                                nombrePaciente,
                                pacientes
                        );

                if (doctor != null && paciente != null) {

                    Cita cita =
                            citaService.crearCita(
                                    id,
                                    fechaHora,
                                    motivo,
                                    doctor,
                                    paciente
                            );

                    citas.add(cita);
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al cargar citas: "
                            + e.getMessage()
            );

        }

        return citas;
    }
}
