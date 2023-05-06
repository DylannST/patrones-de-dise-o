package entity.employee;

import interfaces.Profesional;

import java.util.Arrays;

public class Asesor extends Empleado implements Profesional {
    private String[] funciones = new String[]{"Orientación bancaria", "\n        Manejo de persona", "\n        Manejo de caja", "\n        Contaduria"};

    public Asesor(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(this.funciones);
    }

    @Override
    public String datosDelProfesional() {
        return "Asesor{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones =\n        " + Arrays.toString(this.funciones) +"\n}";
    }
}
