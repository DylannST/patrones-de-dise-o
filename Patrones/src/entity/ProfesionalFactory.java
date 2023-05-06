package entity;

import Interface.Database;
import Interface.Profesion;
import database.MySql;
import database.Postgres;

public class ProfesionalFactory {
    public static Profesion createProfesional( String cedula,String nombre,String type) {
        return switch (type) {
            case "Desarrollador" -> new Desarrollador(nombre,cedula);
            case "Asesor" -> new Asesor(nombre,cedula);
            case "Recursos Humanos" -> new RecursosHumanos(nombre,cedula);
            default -> throw new IllegalArgumentException("Profesión no existente" + type);
        };
    }
}
