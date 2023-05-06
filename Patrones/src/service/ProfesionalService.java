package service;

import Interface.Database;
import Interface.Profesion;
import entity.Empleado;
import entity.ProfesionalFactory;
import repository.ProfesionalRepository;

public class ProfesionalService {

    ProfesionalRepository repo;

    public void enLaBaseDatos(String nombreBD){
        repo = new ProfesionalRepository(nombreBD);
    }

    public Empleado crearProfesional(String cedula, String nombre, String type) {
        Profesion empleado = ProfesionalFactory.createProfesional(cedula, nombre, type);
        return repo.createProfesional((Empleado) empleado);
    }

}
