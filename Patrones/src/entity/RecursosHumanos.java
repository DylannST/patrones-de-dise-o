package entity;

import Interface.Profesion;

import java.util.Arrays;

public class RecursosHumanos  extends Empleado implements Profesion {

    private String[] funciones = new String[]{"Reclutamiento\n", "Administración de personal\n", "Evaluación de desempeño"};

    public RecursosHumanos(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(this.funciones);
    }


    @Override
    public String datosEmpleado() {
        return "Recursos Humanos{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones=\n        " + Arrays.toString(this.funciones) +"\n}";
    }
}