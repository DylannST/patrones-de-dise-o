package factory.profesional;

import builders.employee.Asesor;
import builders.employee.Desarrollador;
import builders.employee.RecursosHumanos;
import interfaces.Profesional;

public class ProfesionalFactory {
    public static Profesional createProfesional(String cedula, String nombre, String type) {
        return switch (type) {
            case "Desarrollador" ->  new Desarrollador(nombre,cedula);
            case "Asesor" -> new Asesor(nombre,cedula);
            case "Recursos Humanos" -> RecursosHumanos.getInstance(nombre,cedula);
            default -> throw new IllegalArgumentException("Profesión no existente" + type);
        };
    }
}
