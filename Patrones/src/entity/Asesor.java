package entity;

import Interface.Profesion;

import java.util.Arrays;

public class Asesor extends Empleado implements Profesion {
    private String[] funciones = new String[]{"Orientación bancaria", "\nManejo de persona", "\nManejo de caja", "\nContaduria"};

    public Asesor(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(this.funciones);
    }

    @Override
    public String datosEmpleado() {
        return "Asesor{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones =\n        " + Arrays.toString(this.funciones) +"\n}";
    }
}
