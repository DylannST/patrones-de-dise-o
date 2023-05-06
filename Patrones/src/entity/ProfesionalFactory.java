package entity;

import Interface.Database;
import Interface.Profesion;
import database.MySql;
import database.Postgres;

public class ProfesionalFactory {
    public static Profesion createProfesional( String cedula,String nombre,String type) {
        return switch (type) {
            case "desarrollador" -> new Desarrollador(nombre,cedula);
            case "asesor" -> new Asesor(nombre,cedula);
            default -> throw new IllegalArgumentException("Profesión no existente" + type);
        };
    }
}
