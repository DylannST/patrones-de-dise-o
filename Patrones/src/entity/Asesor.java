package entity;

import Interface.Profesion;

import java.util.Arrays;

public class Asesor extends Empleado implements Profesion {
    private String[] funciones = new String[]{"Orientación bancaria", "Manejo de personal", "Manejo de caja", "Contaduria"};

    public Asesor(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(funciones);
    }

    @Override
    public String datosEmpleado() {
        return "Asesor{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones = " + Arrays.toString(funciones) +"\n}";
    }

    @Override
    public String getFunciones() {
        return Arrays.toString(this.funciones);
    }
}
