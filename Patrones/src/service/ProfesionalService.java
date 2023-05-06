package service;

import Interface.Database;
import Interface.Profesion;
import entity.Empleado;
import entity.ProfesionalFactory;
import repository.ProfesionalRepository;

import java.util.Arrays;

public class ProfesionalService {
    ProfesionalRepository repo = new ProfesionalRepository("postgres");

    public Empleado crearProfesional(String cedula, String nombre, String type) {
        Profesion empleado = ProfesionalFactory.createProfesional(cedula, nombre, type);
        return repo.createProfesional((Empleado) empleado);
    }

}
