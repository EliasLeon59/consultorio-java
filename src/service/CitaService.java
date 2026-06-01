package service;

import model.Cita;
import model.Doctor;
import model.Paciente;

import java.util.ArrayList;

public class CitaService {

    public Cita crearCita(
            int id,
            String fechaHora,
            String motivo,
            Doctor doctor,
            Paciente paciente) {

        return new Cita(
                id,
                fechaHora,
                motivo,
                doctor,
                paciente
        );
    }

    public Doctor buscarDoctorPorNombre(
            String nombre,
            ArrayList<Doctor> doctores) {

        for (Doctor doctor : doctores) {

            if (doctor.getNombreCompleto().equals(nombre)) {
                return doctor;
            }

        }

        return null;
    }

    public Paciente buscarPacientePorNombre(
            String nombre,
            ArrayList<Paciente> pacientes) {

        for (Paciente paciente : pacientes) {

            if (paciente.getNombreCompleto().equals(nombre)) {
                return paciente;
            }

        }

        return null;
    }
}