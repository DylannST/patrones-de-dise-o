package entity.employee;

import interfaces.Profesional;

import java.util.Arrays;

public class Desarrollador extends Empleado implements Profesional {
    private String[] funciones = new String[]{"Desarrollo de software", "\n        " +
            "Soporte", "\n        Manejo de Infraestructura AWS", "\n        " +
            "Manejo de Infraestructura de AzureDevops"};

    public Desarrollador(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(this.funciones);
    }

    @Override
    public String datosDelProfesional() {
        return "Desarrollador{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones=\n        " + Arrays.toString(this.funciones) +"\n}";
    }

}
