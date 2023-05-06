package service;

import interfaces.Profesional;
import entity.Empleado;
import factory.profesional.ProfesionalFactory;
import repository.ProfesionalRepository;

public class ProfesionalService {

    ProfesionalRepository repo;

    public void enLaBaseDatos(String nombreBD){
        repo = new ProfesionalRepository(nombreBD);
    }

    public Empleado crearProfesional(String cedula, String nombre, String type) {
        Profesional empleado = ProfesionalFactory.createProfesional(cedula, nombre, type);
        return repo.createProfesional((Empleado) empleado);
    }

}
